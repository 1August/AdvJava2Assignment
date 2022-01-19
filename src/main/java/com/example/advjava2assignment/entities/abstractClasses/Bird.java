package com.example.advjava2assignment.entities.abstractClasses;

import com.example.advjava2assignment.interfaces.IWalkable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public abstract class Bird extends Animal implements IWalkable{

}
