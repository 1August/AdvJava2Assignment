package com.example.advjava2assignment.entities.abstractClasses;

import com.example.advjava2assignment.interfaces.IMovable;
import com.example.advjava2assignment.interfaces.IWalkable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public abstract class Animal implements IMovable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int size = 1;

    public Animal(int size) {
        this.size = size;
    }
}