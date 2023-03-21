package com.bach_work.yachtwebsite.ships.controller;
import com.bach_work.yachtwebsite.ships.model.Location;
import com.bach_work.yachtwebsite.ships.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
@Controller
public class LocationController {
    private final LocationService locationService;
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @GetMapping("/locations")
    public String findAll(Model model) {
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        return "listLocation";
    }
    @GetMapping("/createLocation")
    public String createLocationForm(Location location) {
        return "createLocation";
    }
    @PostMapping("/createLocation")
    public String createLocation(Location location) {
        locationService.saveLocation(location);
        return "redirect:/locations";
    }
    @GetMapping("/deleteLocation/{id}")
    public String deleteLocation(@PathVariable("id") Integer id) {
        locationService.deleteById(id);
        return "redirect:/locations";
    }
    @GetMapping("/updateLocation/{id}")
    public String updateLocationForm(@PathVariable("id") Integer id, Model model) {
        Location location = locationService.findById(id);
        model.addAttribute("location", location);
        return "/updateLocation";
    }
    @PostMapping("/updateLocation")
    public String updateLocation(Location location) {
        locationService.saveLocation(location);
        return "redirect:/locations";
    }
}