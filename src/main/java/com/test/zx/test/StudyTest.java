package com.test.zx.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

/**
 * @author Taylor
 * @version 1.0
 */
public class StudyTest {

    public static void main(String[] args) {



        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(null, 0);
        map.put("java", 1);
        map.put("c++", 2);
        map.put("python", 3);
        map.put("php", 4);
        map.put("nodejs", 5);

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("php".hashCode() == "c++".hashCode());

    }


}
