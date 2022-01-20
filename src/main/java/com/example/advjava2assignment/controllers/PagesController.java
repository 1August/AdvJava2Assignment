package com.example.advjava2assignment.controllers;

import com.example.advjava2assignment.entities.abstractClasses.Animal;
import com.example.advjava2assignment.entities.realClasses.*;
import com.example.advjava2assignment.genericTypes.Aquarium;
import com.example.advjava2assignment.genericTypes.Cage;
import com.example.advjava2assignment.genericTypes.Cell;
import com.example.advjava2assignment.genericTypes.Habitat;
import com.example.advjava2assignment.genericTypes.subtypes.TigerCage;
import com.example.advjava2assignment.genericTypes.subtypes.WolfCage;
import com.example.advjava2assignment.models.AddAnimalRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
public class PagesController {
    Habitat habitat = new Habitat(20);
    Cell cell = new Cell(20);
    Cage cage = new Cage(20);
    TigerCage tigerCage = new TigerCage(20);
    WolfCage wolfCage = new WolfCage(20);
    Aquarium aquarium = new Aquarium(20);

    String animalNamesInHabitat = "";
    String animalNamesInCell = "";
    String animalNamesInCage = "";
    String animalNamesInAquarium = "";

    String animalNamesInTigerCage = "";
    boolean isTigerCageOn = false;

    String animalNamesInWolfCage = "";
    boolean isWolfCageOn = false;

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

    Animal[] animals = {tiger, crow, fox, ostrich, penguin, pike, shark, sparrow, turtle, wolf};

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    String main(Model model){
        model.addAttribute("isTigerCageOn", isTigerCageOn);
        model.addAttribute("isWolfCageOn", isWolfCageOn);
        return "index";
    }

    @GetMapping("/places/habitat")
    String habitatGet(Model model){
        model.addAttribute("animalsInHabitat", animalNamesInHabitat);
        model.addAttribute("addAnimalRequest", new AddAnimalRequest());
        return "habitat";
    }

    @GetMapping("/places/cell")
    String cellGet(Model model){
        model.addAttribute("animalsInCell", animalNamesInCell);
        model.addAttribute("addAnimalRequest", new AddAnimalRequest());
        return "cell";
    }

    @GetMapping("/places/cage")
    String cageGet(Model model){
        model.addAttribute("animalsInCage", animalNamesInCage);
        model.addAttribute("addAnimalRequest", new AddAnimalRequest());
        return "cage";
    }

    @GetMapping("/places/tigerCage")
    String tigerCageGet(Model model){
        model.addAttribute("animalsInTigerCage", animalNamesInTigerCage);
        model.addAttribute("addAnimalRequest", new AddAnimalRequest());
        return "tigerCage";
    }

    @GetMapping("/places/wolfCage")
    String wolfCageGet(Model model){
        model.addAttribute("animalsInWolfCage", animalNamesInWolfCage);
        model.addAttribute("addAnimalRequest", new AddAnimalRequest());
        return "wolfCage";
    }

    @GetMapping("/places/aquarium")
    String aquariumGet(Model model){
        model.addAttribute("animalsInAquarium", animalNamesInAquarium);
        model.addAttribute("addAnimalRequest", new AddAnimalRequest());
        return "aquarium";
    }


    /**
     * Error Page
     * @return error page with attribute of error
     */
    @GetMapping("/error")
    String errorPageGet(){
        return "errorPage";
    }


    /**
     *
     * @param model model of tiger page
     * @return String redirect to home page
     */
    @GetMapping("/addTigerCage")
    String addTigerCage(Model model){
        isTigerCageOn = true;
        model.addAttribute("isTigerCageOn", true);
        return "redirect:/";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/addWolfCage")
    String addWolfCage(Model model){
        isWolfCageOn = true;
        model.addAttribute("isWolfCageOn", true);
        return "redirect:/";
    }


    /**
     *
     * @param request add animal request model
     * @param model
     * @return
     */
    @PostMapping("/places/habitat/add")
    String addToHabitatHandler(@ModelAttribute AddAnimalRequest request, Model model){
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
                animalNamesInHabitat += animals[indexOfAnimal].getClass().getSimpleName() + ", ";
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                System.out.println(e);
                return "errorPage";
            }
        }
        model.addAttribute("animalsInHabitat", animalNamesInHabitat);
        return "redirect:/places/habitat";
    }

    @PostMapping("/places/cell/add")
    String addToCellHandler(@ModelAttribute AddAnimalRequest request, Model model){
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
                cell.add(animals[indexOfAnimal]);
                animalNamesInCell += animals[indexOfAnimal].getClass().getSimpleName() + ", ";
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                System.out.println(e);
                return "errorPage";
            }
        }
        model.addAttribute("animalsInCell", animalNamesInCell);
        return "redirect:/places/cell";
    }

    @PostMapping("/places/cage/add")
    String addToCageHandler(@ModelAttribute AddAnimalRequest request, Model model){
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
                cage.add(animals[indexOfAnimal]);
                animalNamesInCage += animals[indexOfAnimal].getClass().getSimpleName() + ", ";
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                System.out.println(e);
                return "errorPage";
            }
        }
        model.addAttribute("animalsInCage", animalNamesInCage);
        return "redirect:/places/cage";
    }

    @PostMapping("/places/tigerCage/add")
    String addToTigerCageHandler(@ModelAttribute AddAnimalRequest request, Model model){
        if (!request.getAnimalName().toLowerCase(Locale.ROOT).equals("tiger")) {
            model.addAttribute("error", "This animal isn't tiger.");
            System.out.println("This animal isn't tiger.");
            return "errorPage";
        }
        for (int i = 0; i < request.getAnimalNumber(); i++) {
            try {
                tigerCage.add(tiger);
                animalNamesInTigerCage += "Tiger, ";
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                System.out.println(e);
                return "errorPage";
            }
        }
        model.addAttribute("animalsInTigerCage", animalNamesInTigerCage);
        return "redirect:/places/tigerCage";
    }

    @PostMapping("/places/wolfCage/add")
    String addToWolfCageHandler(@ModelAttribute AddAnimalRequest request, Model model){
        if (!request.getAnimalName().toLowerCase(Locale.ROOT).equals("wolf")) {
            model.addAttribute("error", "This animal isn't wolf.");
            System.out.println("This animal isn't wolf.");
            return "errorPage";
        }
        for (int i = 0; i < request.getAnimalNumber(); i++) {
            try {
                wolfCage.add(wolf);
                animalNamesInWolfCage += "Wolf, ";
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                System.out.println(e);
                return "errorPage";
            }
        }
        model.addAttribute("animalsInTigerCage", animalNamesInTigerCage);
        return "redirect:/places/wolfCage";
    }

    @PostMapping("/places/aquarium/add")
    String addToAquariumHandler(@ModelAttribute AddAnimalRequest request, Model model){
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
                aquarium.add(animals[indexOfAnimal]);
                animalNamesInAquarium += animals[indexOfAnimal].getClass().getSimpleName() + ", ";
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                System.out.println(e);
                return "errorPage";
            }
        }
        model.addAttribute("animalsInAquarium", animalNamesInAquarium);
        return "redirect:/places/aquarium";
    }
}
