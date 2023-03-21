package com.bach_work.yachtwebsite.ships.service;
import com.bach_work.yachtwebsite.ships.model.Ship;
import com.bach_work.yachtwebsite.ships.repository.ShipRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ShipService {
    private final ShipRepository shipRepository;
    public ShipService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }
    public Ship findById(Integer id) {
        return shipRepository.findById(id).orElse(null);
    }
    public List<Ship> findAll() {
        return shipRepository.findAll();
    }
    public Ship saveShip(Ship ship) {
        return shipRepository.save(ship);
    }
    public void deleteById(Integer id) {
        shipRepository.deleteById(id);
    }
    public List<Ship> findByEnterName(String entername) {
        return shipRepository.findByEnterName(entername);
    }
    public List<Ship> findByLength(Integer enterlength, Integer enterguests, Integer enterCost) {
        return shipRepository.findByLength(enterlength, enterguests, enterCost);
    }
}
