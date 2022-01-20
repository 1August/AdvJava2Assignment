package com.example.advjava2assignment.controllers;

import com.example.advjava2assignment.entities.abstractClasses.Animal;
import com.example.advjava2assignment.entities.realClasses.*;
import com.example.advjava2assignment.genericTypes.Habitat;
import com.example.advjava2assignment.models.HabitatRequest;
import org.apache.coyote.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@Controller
public class HandlerController {
    Habitat habitat = new Habitat(20);

    Animal crow = new Crow();
    Animal fox = new Fox();
    Animal ostrich = new Ostrich();
    Animal penguin = new Penguin();
    Animal pike = new Pike();
    Animal shark = new Shark();
    Animal sparrow = new Sparrow();
    Animal tiger = new Tiger();
    Animal turtle = new Turtle();
    Animal wolf = new Wolf();


    Animal animals[] = {tiger, crow, fox, ostrich, penguin, pike, shark, sparrow, turtle, wolf};
    String animalNamesInhabitat = "";

    @PostMapping("/places/habitat/add")
    String addToHabitatHandler(@ModelAttribute HabitatRequest request, Model model){
        boolean isExists = false;
        int indexOfAnimal = -1;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].getClass().getSimpleName().toLowerCase(Locale.ROOT).equals(request.getAnimalName().toLowerCase(Locale.ROOT))){
                isExists = true;
                indexOfAnimal = i;
                break;
            }
        }
        if (!isExists) {
            model.addAttribute("error", "This animal doesn't exist.");
            System.out.println("Animal doesn't exist.");
            return "errorPage";
        }
        for (int i = 0; i < request.getAnimalNumber(); i++) {
            try {
                habitat.add(animals[indexOfAnimal]);
                animalNamesInhabitat += animals[indexOfAnimal].getClass().getSimpleName() + ", ";
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                System.out.println(e);
                return "errorPage";
            }
        }
        model.addAttribute("animalsInHabitat", animalNamesInhabitat);
        return "habitat";
    }
}
