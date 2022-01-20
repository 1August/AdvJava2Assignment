package com.example.advjava2assignment.entities.abstractClasses;

import com.example.advjava2assignment.interfaces.IMovable;
import com.example.advjava2assignment.interfaces.IWalkable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public abstract class Animal implements IMovable {
    private int size = 3;
}