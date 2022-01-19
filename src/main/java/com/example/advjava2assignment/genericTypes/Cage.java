package com.example.advjava2assignment.genericTypes;

import com.example.advjava2assignment.entities.abstractClasses.Animal;
import com.example.advjava2assignment.entities.abstractClasses.Bird;
import com.example.advjava2assignment.entities.realClasses.Penguin;
import com.example.advjava2assignment.interfaces.IFlyable;
import com.example.advjava2assignment.interfaces.IWalkable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cage<T extends Animal>/* All of them animals, but we need exact tiger, fox... */ {
    private int areaSize;
    private List<Animal> animalList; // we can make it [] for that reason, this var shouldn't be dynamic (it should be static)

    public Cage(int areaSize) {
        this.areaSize = areaSize;
        animalList = new ArrayList<>(areaSize);
    }

    public Animal add(T animal) throws Exception {
        if (animal instanceof IFlyable) throw new Exception("Can't accept animals that can fly");
        if (!(animal instanceof IWalkable)) throw new Exception("Can't accept animals that can't walk");
        if (animal.getSize() > areaSize) throw new Exception("Size out of available space.");
////        Penguin is Bird, but it can't fly
//        if (animal instanceof Bird && !(animal instanceof Penguin)) throw new Exception("Bird can not be placed.");
        animalList.add(animal);
        areaSize -= animal.getSize();
        return animal;
    }
}
