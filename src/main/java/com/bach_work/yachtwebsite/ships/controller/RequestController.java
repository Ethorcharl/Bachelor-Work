package com.bach_work.yachtwebsite.ships.controller;
import com.bach_work.yachtwebsite.auth.model.User;
import com.bach_work.yachtwebsite.auth.service.UserService;
import com.bach_work.yachtwebsite.ships.model.Request;
import com.bach_work.yachtwebsite.ships.model.Ship;
import com.bach_work.yachtwebsite.ships.model.Status_request;
import com.bach_work.yachtwebsite.ships.service.RequestService;
import com.bach_work.yachtwebsite.ships.service.ShipService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Date;
import java.util.List;
@Controller
public class RequestController {
    private final RequestService requestService;
    private final UserService userService;
    private final ShipService shipService;
    public RequestController(RequestService requestService, UserService userService, ShipService shipService) {
        this.requestService = requestService;
        this.userService = userService;
        this.shipService = shipService;
    }
    @GetMapping("/requests")
    public String findAll(Model model){
        List<Request> requests = requestService.findAll();
        model.addAttribute("requests",requests);
        return "listRequest";
    }
    @PostMapping("/request")
    public String newrequest( Integer id, String field, Model model){
        Ship ships = shipService.findById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User user = userService.findByEnterEmail(currentUserName);
            Request request=new Request();
            Date date = new Date();
            request.setShip(ships);
            request.setUser_user(user);
            request.setDescription(field);
            request.setDatesending(date);
            request.setStatus(Status_request.WAITING);
            requestService.saveRequest(request);
        }
        return "redirect:/ships";
    }
    @GetMapping("/createRequest")
    public String createRequestForm(Request request){
        return "createRequest";
    }
    @PostMapping("/createRequest")
    public String createRequest(Request request){
        requestService.saveRequest(request);
        return "redirect:/requests";
    }
    @GetMapping("/deleteRequest/{id}")
    public String deleteRequest(@PathVariable("id") Integer id){
        requestService.deleteById(id);
        return "redirect:/requests";
    }
    @GetMapping("/updateRequest/{id}")
    public String updateRequestForm(@PathVariable("id") Integer id, Model model){
        Request request = requestService.findByID(id);
        model.addAttribute("request",request);
        List<User> user =  userService.findAll();
        model.addAttribute("users",user);
        return "/updateRequest";
    }
    @PostMapping("/updateRequest")
    public String updateRequest(Request request){
        requestService.saveRequest(request);
        return "redirect:/requests";
    }
}