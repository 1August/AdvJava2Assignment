package com.example.advjava2assignment.genericTypes.subtypes;

import com.example.advjava2assignment.entities.abstractClasses.Animal;
import com.example.advjava2assignment.entities.realClasses.Tiger;
import com.example.advjava2assignment.genericTypes.Cage;

public class TigerCage extends Cage {
    public TigerCage(int areaSize) {
        super(areaSize);
    }

    @Override
    public Animal add(Animal animal) throws Exception {
        if (!(animal instanceof Tiger)) throw new Exception("It isn't tiger.");
        return super.add(animal);
    }
}
