package com.example.advjava2assignment.entities.abstractClasses;

import com.example.advjava2assignment.interfaces.ISwimable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Fish extends Animal implements ISwimable {
    private int size = 2;

    @Override
    public int getComfortableSpace() {
        return getSize() * 2;
    }
}
