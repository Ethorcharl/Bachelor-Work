package com.bach_work.yachtwebsite.ships.service;

import com.bach_work.yachtwebsite.ships.model.Location;
import com.bach_work.yachtwebsite.ships.model.Location;
import com.bach_work.yachtwebsite.ships.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location findById(Integer id) {
        return locationRepository.findById(id).orElse(null);
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public void deleteById(Integer id) {
        locationRepository.deleteById(id);
    }

}
