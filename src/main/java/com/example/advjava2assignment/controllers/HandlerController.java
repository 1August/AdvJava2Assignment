package com.example.advjava2assignment.controllers;

import com.example.advjava2assignment.entities.abstractClasses.Animal;
import com.example.advjava2assignment.entities.realClasses.Crow;
import com.example.advjava2assignment.entities.realClasses.Tiger;
import com.example.advjava2assignment.genericTypes.Habitat;
import com.example.advjava2assignment.interfaces.IMovable;
import com.example.advjava2assignment.models.HabitatRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
public class HandlerController {
    Habitat habitat = new Habitat(20);
    Animal crow = new Crow();
    Animal tiger = new Tiger();

    Animal animals[] = {tiger, crow};

    @PostMapping("/places/habitat/add")
    String addToHabitatHandler(@ModelAttribute HabitatRequest request, Model model) throws Exception {

        System.out.println(request.getAnimalName() + " " + request.getAnimalNumber());

        for (int i = 0; i < request.getAnimalNumber(); i++){
            Animal animal = null;
            for (Animal animalTemp : animals) {
                if (animalTemp.getClass().getName().toLowerCase(Locale.ROOT).equals(request.getAnimalName().toLowerCase(Locale.ROOT)))
                    System.out.println("name is equal");
                    animal = animalTemp;
            }
            System.out.println(animal + " " + (animal instanceof IMovable));
            habitat.add(animal);
        }
        model.addAttribute("isError", false);
        return "habitat";
    }
}
