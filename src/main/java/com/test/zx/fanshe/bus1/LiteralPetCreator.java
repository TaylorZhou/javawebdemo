package com.test.zx.fanshe.bus1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Taylor
 */
public class LiteralPetCreator extends PetCreator {
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(
            Arrays.asList(Pet.class, Dog.class, Cat.class, Mutt.class, EgyptianMau.class));
    private static final List<Class<? extends Pet>> types = allTypes.subList(
            allTypes.indexOf(Mutt.class), allTypes.size());
    public List<Class<? extends Pet>> getTypes() {
        return types;
    }
}
