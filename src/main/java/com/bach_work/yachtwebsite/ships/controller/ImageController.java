package com.bach_work.yachtwebsite.ships.controller;
import com.bach_work.yachtwebsite.ships.model.Image;
import com.bach_work.yachtwebsite.ships.model.Ship;
import com.bach_work.yachtwebsite.ships.service.ImageService;
import com.bach_work.yachtwebsite.ships.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class ImageController {
    private final ImageService imageService;
    private final ShipService shipService;

    public ImageController(ImageService imageService, ShipService shipService) {
        this.imageService = imageService;
        this.shipService = shipService;
    }
    @GetMapping("/images")
    public String findAll(Model model){
        List<Image> images = imageService.findAll();
        model.addAttribute("images", images);

        return "listImages";
    }
    @GetMapping("/createImage")
    public String createImagesForm(Image image, Model model){
        List<Ship> ships = shipService.findAll();
        model.addAttribute("ships", ships);
        return "createImage";
    }
    @PostMapping("/createImage")
    public String createImages(Image image){
        imageService.saveImage(image);

        return "redirect:/images";
    }
    @GetMapping("/deleteImage/{id}")
    public String deleteImages(@PathVariable("id") Integer id){
        imageService.deleteById(id);
        return "redirect:/images";
    }
    @GetMapping("/updateImage/{id}")
    public String updateImagesForm(@PathVariable("id") Integer id, Model model){
        Image image = imageService.findById(id);
        model.addAttribute("image", image);
        List<Ship> ships = shipService.findAll();
        model.addAttribute("ships", ships);
        return "/updateImage";
    }
    @PostMapping("/updateImage")
    public String updateLocation(Image image){
        imageService.saveImage(image);
        return "redirect:/images";
    }
}
