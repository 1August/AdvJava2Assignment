package com.example.advjava2assignment.genericTypes;

import com.example.advjava2assignment.entities.abstractClasses.Animal;
import com.example.advjava2assignment.entities.abstractClasses.Bird;
import com.example.advjava2assignment.interfaces.IFlyable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cell<T extends Animal> {
    private int areaSize;
    private List<Animal> animalList; // we can make it [] for that reason, this var shouldn't be dynamic (it should be static)

    public Cell(int areaSize) {
        this.areaSize = areaSize;
        animalList = new ArrayList<>(areaSize);
    }

    public Animal add(T animal) throws Exception {
        if (!(animal instanceof IFlyable)) throw new Exception("Animal can't fly.");
        if (!(animal instanceof Bird)) throw new Exception("Animal isn't bird.");
        if (animal.getComfortableSpace() > areaSize) throw new Exception("Size out of available space.");
        animalList.add(animal);
        areaSize -= animal.getComfortableSpace();
        return animal;
    }
}