package com.test.zx.fanshe.bus1;

import java.text.Format;
import java.util.ArrayList;

/**
 * @author Taylor
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Pet> pets = new LiteralPetCreator().arrayList(5);
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : pets){
            counter.count(pet);
        }


        System.out.println(counter);
    }
}
