package com.bach_work.yachtwebsite.ships.service;
import com.bach_work.yachtwebsite.ships.model.ShipType;
import com.bach_work.yachtwebsite.ships.repository.TypeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TypeService {
    private final TypeRepository typeRepository;
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }
    public ShipType findById(Integer id) {
        return typeRepository.findById(id).orElse(null);
    }
    public List<ShipType> findAll() {
        return typeRepository.findAll();
    }
    public ShipType saveType(ShipType shipType) {
        return typeRepository.save(shipType);
    }
    public void deleteById(Integer id) {
        typeRepository.deleteById(id);
    }
}
