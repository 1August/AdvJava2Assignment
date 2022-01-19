package com.example.advjava2assignment.entities.realClasses;

import com.example.advjava2assignment.entities.abstractClasses.Animal;
import com.example.advjava2assignment.interfaces.IWalkable;

public class Fox extends Animal implements IWalkable {
    @Override
    public int getComfortableSpace() {
        return getSize() * 4;
    }
}
