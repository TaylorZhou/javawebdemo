package com.test.zx.zhujie.annotations;


import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Taylor
 * @version 1.0
 */
public class InterfaceProcessor extends AbstractProcessor {

    private Types typeUtils;
    private Elements elementUtils;
    private Filer filer;
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
        elementUtils = env.getElementUtils();
        filer = env.getFiler();
        typeUtils = env.getTypeUtils();
        messager = env.getMessager();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new TreeSet<>();
        types.add(Interface.class.getCanonicalName());
        return types;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }


    /**
     * {@inheritDoc}
     *
     * @param annotations
     * @param roundEnv
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        Map<String, AnnotatedClass> classMap = new HashMap<>();

        // 得到所有注解@Interface的Element集合
        Set<? extends Element> elementSet = env.getElementsAnnotatedWith(Interface.class);

        for (Element e : elementSet) {
            if (e.getKind() != ElementKind.METHOD) {
                error(e, "错误的注解类型，只有函数能够被该 @%s 注解处理", Interface.class.getSimpleName());
                return true;
            }

            ExecutableElement element = (ExecutableElement) e;
            AnnotatedMethod annotatedMethod = new AnnotatedMethod(element);

            String classname = annotatedMethod.getSimpleClassName();
            AnnotatedClass annotatedClass = classMap.get(classname);
            if (annotatedClass == null) {
                PackageElement pkg = elementUtils.getPackageOf(element);
                annotatedClass = new AnnotatedClass(pkg.getQualifiedName().toString(), element.getAnnotation(Interface.class).value());
                annotatedClass.addMethod(annotatedMethod);
                classMap.put(classname, annotatedClass);
            } else
                annotatedClass.addMethod(annotatedMethod);

        }
        // 代码生成
        for (AnnotatedClass annotatedClass : classMap.values()) {
            annotatedClass.generateCode(elementUtils, filer);
        }
        return false;
    }

    private void error(Element e, String msg, Object... args) {
        messager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args), e);
    }
}
