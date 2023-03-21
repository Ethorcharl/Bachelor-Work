package com.bach_work.yachtwebsite.ships.controller;
import com.bach_work.yachtwebsite.ships.model.ShipType;
import com.bach_work.yachtwebsite.ships.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
@Controller
public class TypeController {
    private final TypeService typeService;
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }
    @GetMapping("/types")
    public String findAll(Model model){
        List<ShipType> types = typeService.findAll();
        model.addAttribute("types", types);
        return "listType";
    }
    @GetMapping("/createType")
    public String createTypeForm(ShipType shipType){
        return "createType";
    }
    @PostMapping("/createType")
    public String createType(ShipType shipType){
        typeService.saveType(shipType);
        return "redirect:/types";
    }
    @GetMapping("/deleteType/{id}")
    public String deleteType(@PathVariable("id") Integer id){
        typeService.deleteById(id);
        return "redirect:/types";
    }
    @GetMapping("/updateType/{id}")
    public String updateTypeForm(@PathVariable("id") Integer id, Model model){
        ShipType shipType= typeService.findById(id);
        model.addAttribute("shipType",shipType);
        return "/updateType";
    }
    @PostMapping("/updateType")
    public String updateType(ShipType shipType){
        typeService.saveType(shipType);
        return "redirect:/types";
    }
}