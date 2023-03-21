package com.bach_work.yachtwebsite.ships.controller;
import com.bach_work.yachtwebsite.auth.model.User;
import com.bach_work.yachtwebsite.auth.service.UserService;
import com.bach_work.yachtwebsite.ships.model.Comparison;
import com.bach_work.yachtwebsite.ships.model.Ship;
import com.bach_work.yachtwebsite.ships.service.ComparisonService;
import com.bach_work.yachtwebsite.ships.service.ShipService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;
@Controller
public class ComparisonController {
    private final ComparisonService comparisonService;
    private final ShipService shipService;
    private final UserService userService;
    public ComparisonController(ComparisonService comparisonService, ShipService shipService, UserService userService) {
        this.comparisonService = comparisonService;
        this.shipService = shipService;
        this.userService = userService;
    }
    @GetMapping("/comparisons")
    public String findAll(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User user = userService.findByEnterEmail(currentUserName);
            List<Comparison> comparisons = comparisonService.findByEnterUserId(user.getUserid());
            List<Ship> ships = new ArrayList<>();
            comparisons.forEach(comparison -> ships.add(comparison.getShip()));
            model.addAttribute("comparisons",comparisons);
            model.addAttribute("ships", ships);
        }
        return "listComparison";
    }
    @PostMapping("/comparison")
    public String comparisonAdd( Integer id){
        Ship ships = shipService.findById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User user =  userService.findByEnterEmail(currentUserName);
            Comparison comparison=new Comparison();
            comparison.setShip(ships);
            comparison.setUser(user);
            comparisonService.saveComparison(comparison);
        }
        return "redirect:/ships";
    }
    @GetMapping("/createComparison")
    public String createComparisonForm(Comparison comparison){
        return "createComparison";
    }
    @PostMapping("/createComparison")
    public String createCoparison(Comparison comparison, Model model)
    {
        comparisonService.saveComparison(comparison);
        return "redirect:/comparisons";
    }
    @PostMapping("/deleteComparison")
    public String deleteComparison( Integer id){
        comparisonService.deleteById(id);
        return "redirect:/comparisons";
    }
    @GetMapping("/updateComparison/{id}")
    public String updateComparisonForm(@PathVariable("id") Integer id, Model model){
        Comparison comparison= comparisonService.findById(id);
        model.addAttribute("comparison", comparison);
        return "/updateComparison";
    }
    @PostMapping("/updateComparison")
    public String updateComparison(Comparison comparison){
        comparisonService.saveComparison(comparison);
        return "redirect:/comparisons";
    }
}