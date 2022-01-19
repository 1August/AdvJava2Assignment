package com.example.advjava2assignment.entities.realClasses;

import com.example.advjava2assignment.entities.abstractClasses.Fish;

public class Pike extends Fish {

    @Override
    public int getComfortableSpace() {
        return getSize() * 3;
    }
}
