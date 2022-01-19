package com.example.advjava2assignment.genericTypes;

import com.example.advjava2assignment.entities.abstractClasses.Animal;
import com.example.advjava2assignment.entities.abstractClasses.Fish;
import com.example.advjava2assignment.entities.realClasses.Penguin;
import com.example.advjava2assignment.interfaces.ISwimable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Aquarium<T extends Fish> {
    private int areaSize;
    private List<Animal> animalList; // we can make it [] for that reason, this var shouldn't be dynamic (it should be static)

    public Aquarium(int areaSize) {
        this.areaSize = areaSize;
        animalList = new ArrayList<>(areaSize);
    }

    public Animal add(T animal) throws Exception {
        if (!(animal instanceof ISwimable)) throw new Exception("Animal can't swim.");
        if (animal.getSize() > areaSize) throw new Exception("Size out of available space.");
//        if (animal instanceof Penguin) throw new Exception("Penguin can't be accepted.");
        animalList.add(animal);
        areaSize -= animal.getSize();
        return animal;
    }
}
