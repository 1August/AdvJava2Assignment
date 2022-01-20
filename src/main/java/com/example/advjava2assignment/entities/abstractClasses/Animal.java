package com.example.advjava2assignment.entities.abstractClasses;

import com.example.advjava2assignment.interfaces.IMovable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Animal implements IMovable {
    private int size = 3;

    @Override
    public int getComfortableSpace() {
        return getSize() * 3;
    }
}