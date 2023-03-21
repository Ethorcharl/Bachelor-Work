package com.bach_work.yachtwebsite.ships.controller;

import com.bach_work.yachtwebsite.ships.model.Ship;
import com.bach_work.yachtwebsite.ships.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SearchController {

    private final ShipService shipService;

    public SearchController(ShipService shipService) {
        this.shipService = shipService;
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/filterByName")
    public String filterByName(Model model, @RequestBody String ship ){

        List<Ship> ships = shipService
                .findAll()
                .stream()
                .filter(s->s.getName().equalsIgnoreCase(ship))
                .collect(Collectors.toList());


        model.addAttribute("ships",  ships); //contains for text
        return "listShip";
    }
    /*@GetMapping("/filterByName")
    public String filterByName(Model model){
        List<Ship> ships = shipService.findAll();
        model.addAttribute("ships",  ships
                .stream()
                .filter(s->s.getName().contains("Titan")).collect(Collectors.toList())); //contains for text
        return "listShip";
    }*/

    @GetMapping("/filterByLength")
    public String filterByLength(Model model){
        List<Ship> ships = shipService.findAll();
        model.addAttribute("ships",  ships
                .stream()
                .filter(s->s.getLength()>15).collect(Collectors.toList()));
        return "listShip";
    }

    @GetMapping("/filterByGuest")
    public String filterByGuest(Model model){
        List<Ship> ships = shipService.findAll();
        model.addAttribute("ships",  ships
                .stream()
                .filter(s->s.getGuests()>3).collect(Collectors.toList()));
        return "listShip";
    }

    @GetMapping("/filterByRentCost")
    public String filterByRentCost(Model model){
        List<Ship> ships = shipService.findAll();
        model.addAttribute("ships",  ships
                .stream()
                .filter(s->s.getRent_cost()>50).collect(Collectors.toList()));
        return "listShip";
    }

    @GetMapping("/filterBySpeed")
    public String filterBySpeed(Model model){
        List<Ship> ships = shipService.findAll();
        model.addAttribute("ships",  ships
                .stream()
                .filter(s->s.getRent_cost()>50).collect(Collectors.toList()));
        return "listShip";
    }

    @GetMapping("/filterByBuiltYear")
    public String filterByBuiltYear(Model model){
        List<Ship> ships = shipService.findAll();
        model.addAttribute("ships",  ships
                .stream()
                .filter(s->s.getBuilt_year()>1990).collect(Collectors.toList()));
        return "listShip";
    }

}
