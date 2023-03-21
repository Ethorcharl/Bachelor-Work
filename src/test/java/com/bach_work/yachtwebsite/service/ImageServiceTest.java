package com.bach_work.yachtwebsite.service;
import com.bach_work.yachtwebsite.ships.model.Image;
import com.bach_work.yachtwebsite.ships.model.Location;
import com.bach_work.yachtwebsite.ships.model.Ship;
import com.bach_work.yachtwebsite.ships.model.ShipType;
import com.bach_work.yachtwebsite.ships.repository.ImageRepository;
import com.bach_work.yachtwebsite.ships.service.ImageService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
public class ImageServiceTest {
    private final ImageRepository imageRepository = Mockito.mock(ImageRepository.class);
    private final ImageService imageService = new ImageService(imageRepository);
    private final int imageId = 22;
    @Test
    public void findByIdTest() {
        when(imageRepository.findById(imageId)).thenReturn(Optional.of(getTestImage()));
        Image image = imageService.findById(imageId);
        assertEquals(33, image.getImage_id());
    }
    @Test
    public void findByIdFail() {
        when(imageRepository.findById(imageId)).thenReturn(Optional.empty());
        Image image = imageService.findById(imageId);
        assertNull(image);
    }
    @Test
    public void findAllTest() {
        when(imageRepository.findAll()).thenReturn(getImageList());
        assertEquals(2, imageService.findAll().size());
    }
    @Test
    public void saveImageTest() {
        Image imageToSave=getTestImage();
        when(imageRepository.save(imageToSave)).thenReturn(imageToSave);
        Image image = imageService.saveImage(imageToSave);
        assertEquals(getTestImage().getImage_id(), image.getImage_id());
    }
    @Test
    public void deleteByIdTest() {
        assertDoesNotThrow(()->imageService.deleteById(imageId));
    }
    private Ship getTestShip() {
        Ship ship = new Ship();
        ship.setShip_id(22);
        ship.setName("Hello");
        ship.setLength(5);
        ship.setGuests(5);
        ship.setRent_cost(5);
        ship.setSpeed(5);
        ship.setBuilt_year(5);
        ship.setDescription("Hello");
        ship.setShipType(new ShipType());
        ship.setLocation(new Location());
        return ship;
    }
    private Image getTestImage() {
        Image image = new Image();
        image.setImage_id(33);
        image.setSh(getTestShip());
        image.setPath("path");
        return image;
    }
    private List<Image> getImageList() {
        List<Image> imageList = new ArrayList<>();
        imageList.add(getTestImage());
        Image image = getTestImage();
        image.setImage_id(33);
        imageList.add(image);
        return imageList;
    }
}
