package com.workintech.zoo.exceptions;

import com.workintech.zoo.entity.Animal;
import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class AnimalValidator {

    public static void isIdValid(int id) {
        if (id < 0) {
            throw new AnimalException("Id must be greater than 0: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdExist(Map animals, int id) {
        if (animals.containsKey(id)) {
            throw new AnimalException("Animal with given id is already exist: " + id, HttpStatus.NOT_FOUND);
        }
    }

    public static void isAnimalValid(Animal animal){
        if((animal.getName() == null || animal.getName().isEmpty()) ||
        animal.getWeight() <= 0 || animal.getWeight() > 100){
            throw new AnimalException("Animal is not valid: " + animal, HttpStatus.BAD_REQUEST);
        }
    }

    public static void isKangarooValid(Kangaroo kangaroo){
        if(kangaroo.getHeight()< 0.5 || kangaroo.getHeight() > 2){
            throw new AnimalException("Kangaroo is not valid: " + kangaroo, HttpStatus.BAD_REQUEST);
        }
    }

    public static void isKoalaValid(Koala koala){
        if(koala.getSleepHour()<18){
            throw new AnimalException("Koala is not valid: " + koala, HttpStatus.BAD_REQUEST);
        }
    }


}
