package com.bach_work.yachtwebsite.service;
import com.bach_work.yachtwebsite.ships.model.Location;
import com.bach_work.yachtwebsite.ships.model.Ship;
import com.bach_work.yachtwebsite.ships.model.ShipType;
import com.bach_work.yachtwebsite.ships.repository.ShipRepository;
import com.bach_work.yachtwebsite.ships.service.ShipService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
public class ShipServiceTest {
    private final ShipRepository shipRepository = Mockito.mock(ShipRepository.class);
    private final ShipService shipService = new ShipService(shipRepository);
    private final int shipId = 777;
    @Test
    public void findByIdTest() {
        when(shipRepository.findById(shipId)).thenReturn(Optional.of(getTestShip()));
        Ship ship = shipService.findById(shipId);
        assertEquals(22, ship.getShip_id());
    }
    @Test
    public void findByIdTestFailure() {
        when(shipRepository.findById(shipId)).thenReturn(Optional.empty());
        Ship ship = shipService.findById(shipId);
        assertNull(ship);
    }
    @Test
    public void findAllTest() {
        when(shipRepository.findAll()).thenReturn(getShipList());
        assertEquals(2, shipService.findAll().size());
    }
    @Test
    public void saveShip() {
        Ship shipToSave=getTestShip();
        when(shipRepository.save(shipToSave)).thenReturn(shipToSave);
        Ship ship = shipService.saveShip(shipToSave);
        assertEquals(getTestShip().getShip_id(), ship.getShip_id());
    }
    @Test
    public void deleteByIdTest() {
        assertDoesNotThrow(()->shipService.deleteById(shipId));
    }
    @Test
    public void findByEnterNameTest() {

        when(shipRepository.findByEnterName("Hello")).thenReturn(getShipList());
        assertEquals(2, shipService.findByEnterName("Hello").size());

    }
    @Test
    public void findByLengthTest() {
        when(shipRepository.findByLength(5,5,5)).thenReturn(getShipList());
        assertEquals(2, shipService.findByLength(5,5,5).size());
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
    private List<Ship> getShipList() {
        List<Ship> shipList = new ArrayList<>();
        shipList.add(getTestShip());
        Ship ship = getTestShip();
        ship.setShip_id(33);
        shipList.add(ship);
        return shipList;
    }
}