package com.example.advjava2assignment.genericTypes;

import com.example.advjava2assignment.entities.abstractClasses.Animal;
import com.example.advjava2assignment.interfaces.IMovable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Habitat<T extends Animal> {
    private int areaSize;
    private List<Animal> animalList; // we can make it [] for that reason, this var shouldn't be dynamic (it should be static)

    public Habitat(int areaSize) {
        this.areaSize = areaSize;
        animalList = new ArrayList<>(areaSize);
    }

    public Animal add(T animal) throws Exception {
        if (!(animal instanceof IMovable)) throw new Exception("Not interface of Movable");
        System.out.println(animal.getComfortableSpace() + " " + areaSize);
        if (animal.getComfortableSpace() > areaSize) throw new Exception("Size out of available space.");
        animalList.add(animal);
        areaSize -= animal.getComfortableSpace();
        return animal;
    }
}
