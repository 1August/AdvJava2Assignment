package com.example.advjava2assignment.genericTypes.subtypes;

import com.example.advjava2assignment.entities.abstractClasses.Animal;
import com.example.advjava2assignment.entities.realClasses.Wolf;
import com.example.advjava2assignment.genericTypes.Cage;

public class WolfCage extends Cage {
    public WolfCage(int areaSize) {
        super(areaSize);
    }

    @Override
    public Animal add(Animal animal) throws Exception {
        if (!(animal instanceof Wolf)) throw new Exception("It isn't wolf.");
        return super.add(animal);
    }
}
