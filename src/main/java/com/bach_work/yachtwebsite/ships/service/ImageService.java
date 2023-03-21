package com.bach_work.yachtwebsite.ships.service;
import com.bach_work.yachtwebsite.ships.model.Image;
import com.bach_work.yachtwebsite.ships.repository.ImageRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ImageService {
    private final ImageRepository imageRepository;
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    public Image findById(Integer id) {
        return imageRepository.findById(id).orElse(null);
    }
    public List<Image> findAll() {
        return imageRepository.findAll();
    }
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }
    public void deleteById(Integer id) {
        imageRepository.deleteById(id);
    }
}
