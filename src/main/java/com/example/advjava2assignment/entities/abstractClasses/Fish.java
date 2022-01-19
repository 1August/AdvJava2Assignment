package com.example.advjava2assignment.entities.abstractClasses;

import com.example.advjava2assignment.interfaces.ISwimable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public abstract class Fish extends Animal implements ISwimable {

}
