package com.example.advjava2assignment.controllers;

import com.example.advjava2assignment.models.HabitatRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/")
    String main(){
        return "index";
    }

    @GetMapping("/places/habitat")
    String habitatGet(Model model){
        model.addAttribute("habitatRequest", new HabitatRequest());
        return "habitat";
    }

    @GetMapping("/places/cell")
    String cellGet(){
        return "cell";
    }

    @GetMapping("/places/birdCell")
    String birdCellGet(){
        return "cell";
    }

    @GetMapping("/places/cage")
    String cageGet(){
        return "cage";
    }

    @GetMapping("/places/tigerCage")
    String tigerCageGet(){
        return "cage";
    }

    @GetMapping("/places/aquarium")
    String aquariumGet(){
        return "aquarium";
    }


    @GetMapping("/error")
    String errorPageGet(){
        return "errorPage";
    }
}
