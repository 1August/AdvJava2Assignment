package com.example.advjava2assignment.entities.abstractClasses;

import com.example.advjava2assignment.interfaces.IWalkable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Bird extends Animal implements IWalkable{
    private int size = 1;

    @Override
    public int getComfortableSpace() {
        return getSize() * 2;
    }
}
