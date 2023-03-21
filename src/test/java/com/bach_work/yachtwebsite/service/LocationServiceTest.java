package com.bach_work.yachtwebsite.service;
import com.bach_work.yachtwebsite.ships.model.Location;
import com.bach_work.yachtwebsite.ships.repository.LocationRepository;
import com.bach_work.yachtwebsite.ships.service.LocationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
public class LocationServiceTest {
    private final LocationRepository locationRepository = Mockito.mock(LocationRepository.class);
    private final LocationService locationService = new LocationService(locationRepository);
    private final int locationId = 777;
    @Test
    public void findByIdTest(){
        when(locationRepository.findById(locationId)).thenReturn(Optional.of(getTestLocation()));
        Location location = locationService.findById(locationId);
        assertEquals(22, location.getLocation_id());
    }
    @Test
    public void findByIdFail(){
        when(locationRepository.findById(locationId)).thenReturn(Optional.empty());
        Location location = locationService.findById(locationId);
        assertNull(location);
    }
    @Test
    public void findAllTest(){
        when(locationRepository.findAll()).thenReturn(getLocationList());
        assertEquals(2, locationService.findAll().size());
    }
    @Test
    public void saveLocationTest(){
        Location locationToSave=getTestLocation();
        when(locationRepository.save(locationToSave)).thenReturn(locationToSave);
        Location location = locationService.saveLocation(locationToSave);
        assertEquals(getTestLocation().getLocation_id(), location.getLocation_id());
    }
    @Test
    public void  deleteByIdTest(){
        assertDoesNotThrow(()->locationService.deleteById(locationId));
    }

    private Location getTestLocation() {
        Location location = new Location();
        location.setLocation_id(22);
        location.setCity("Paris");
        location.setCountry("France");
        return location;
    }
    private List<Location> getLocationList() {
        List<Location> locationList = new ArrayList<>();
        locationList.add(getTestLocation());
        Location location = getTestLocation();
        location.setLocation_id(33);
        locationList.add(location);
        return locationList;
    }
}