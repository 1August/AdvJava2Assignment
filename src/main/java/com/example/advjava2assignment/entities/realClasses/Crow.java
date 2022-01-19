package com.example.advjava2assignment.entities.realClasses;

import com.example.advjava2assignment.entities.abstractClasses.Bird;
import com.example.advjava2assignment.interfaces.IFlyable;

public class Crow extends Bird implements IFlyable {
    @Override
    public int getComfortableSpace() {
        return getSize() * 2;
    }
}
