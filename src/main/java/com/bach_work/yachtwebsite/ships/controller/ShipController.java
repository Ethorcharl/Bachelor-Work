package com.bach_work.yachtwebsite.ships.controller;
import com.bach_work.yachtwebsite.auth.model.User;
import com.bach_work.yachtwebsite.auth.service.UserService;
import com.bach_work.yachtwebsite.ships.model.*;
import com.bach_work.yachtwebsite.ships.service.*;
import com.bach_work.yachtwebsite.ships.model.Ship;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
@Controller
public class ShipController {
    private final ShipService shipService;
    private final TypeService typeService;
    private final LocationService locationService;
    private final UserService userService;
    public ShipController(ShipService shipService, ImageService imageService, TypeService typeService, LocationService locationService, UserService userService, ComparisonService comparisonService, RequestService requestService) {
        this.shipService = shipService;
        this.typeService = typeService;
        this.locationService = locationService;
        this.userService = userService;
    }
    @GetMapping("/ships")
    public String findAll(Model model, String entername, Integer enterlength, Integer enterguests, Integer enterCost) {
        List<Ship> ships = shipService.findAll();
        if (entername != null && !entername.isEmpty()) // empty need
        {
            model.addAttribute("ships", shipService.findByEnterName(entername));
        } else if (enterlength != null || enterguests != null || enterCost != null) {
            model.addAttribute("ships", shipService.findByLength(enterlength, enterguests, enterCost));
        } else {
            model.addAttribute("ships", ships);
        }
        return "listShip";
    }
    @GetMapping("/createShip")
    public String createShipForm(Ship ship, Model model) {
        List<ShipType> shipTypes = typeService.findAll();
        model.addAttribute("shipTypes", shipTypes);
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);

        return "createShip";
    }
    @PostMapping("/createShip")
    public String createShip(Ship ship) {
        shipService.saveShip(ship);
        return "redirect:/ships";
    }
    @GetMapping("/deleteShip")
    public String deleteShip( Integer id) {
        shipService.deleteById(id);
        return "redirect:/ships";
    }
    @GetMapping("/updateShip")
    public String updateShipForm( Integer id, Model model) {
        List<ShipType> shipTypes = typeService.findAll();
        model.addAttribute("shipTypes", shipTypes);
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        Ship ship = shipService.findById(id);
        model.addAttribute("ship", ship);
        return "/updateShip";
    }
    @PostMapping("/updateShip")
    public String updateShip(Ship ship) {
        shipService.saveShip(ship);
        return "redirect:/ships";
    }
    @GetMapping("/moreInfo")
    public String moreInfo(Integer id, Model model) {
        Ship ships = shipService.findById(id);
        model.addAttribute("ships", ships);
        return "infoShip";
    }
    @GetMapping("/users")
    public String findUser(Model model, String enterEmail) {
        User users = userService.findByEnterEmail(enterEmail);
        model.addAttribute("users", users);
        return "listShip";
    }
}
