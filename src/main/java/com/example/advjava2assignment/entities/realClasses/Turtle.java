package com.example.advjava2assignment.entities.realClasses;

import com.example.advjava2assignment.entities.abstractClasses.Animal;
import com.example.advjava2assignment.interfaces.ISwimable;
import com.example.advjava2assignment.interfaces.IWalkable;

public class Turtle extends Animal implements ISwimable, IWalkable {

    @Override
    public int getComfortableSpace() {
        return getSize() * 4;
    }
}
