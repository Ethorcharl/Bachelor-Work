package com.bach_work.yachtwebsite.service;
import com.bach_work.yachtwebsite.auth.model.Role;
import com.bach_work.yachtwebsite.auth.model.Status;
import com.bach_work.yachtwebsite.auth.model.User;
import com.bach_work.yachtwebsite.ships.model.Comparison;
import com.bach_work.yachtwebsite.ships.model.Location;
import com.bach_work.yachtwebsite.ships.model.Ship;
import com.bach_work.yachtwebsite.ships.model.ShipType;
import com.bach_work.yachtwebsite.ships.repository.ComparisonRepository;
import com.bach_work.yachtwebsite.ships.service.ComparisonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
public class ComparisonServiceTest {
    private final ComparisonRepository comparisonRepository = Mockito.mock(ComparisonRepository.class);
    private final ComparisonService comparisonService = new ComparisonService(comparisonRepository);
    private final int comparisonId = 11;
    @Test
    public void findByIdTest() {
        when(comparisonRepository.findById(comparisonId)).thenReturn(Optional.of(getTestComparison()));
        Comparison comparison = comparisonService.findById(comparisonId);
        assertEquals(22, comparison.getComparison_id());
    }
    @Test
    public void findByIdTestFailure() {
        when(comparisonRepository.findById(comparisonId)).thenReturn(Optional.empty());
        Comparison comparison = comparisonService.findById(comparisonId);
        assertNull(comparison);
    }
    @Test
    public void findAllTest() {
        when(comparisonRepository.findAll()).thenReturn(getComparisonList());
        assertEquals(2, comparisonService.findAll().size());
    }
    @Test
    public void saveShip() {
        Comparison comparisonToSave=getTestComparison();
        when(comparisonRepository.save(comparisonToSave)).thenReturn(comparisonToSave);
        Comparison comparison = comparisonService.saveComparison(comparisonToSave);
        assertEquals(getTestComparison().getComparison_id(), comparison.getComparison_id());
    }
    @Test
    public void deleteByIdTest() {
        assertDoesNotThrow(()->comparisonService.deleteById(comparisonId));
    }
    @Test
    public void findByEnterUserIdTest() {
        when(comparisonRepository.findByEnterUserId(comparisonId)).thenReturn(getComparisonList());
        assertEquals(2, comparisonService.findByEnterUserId(comparisonId).size());
    }
    private Comparison getTestComparison() {
        Comparison comparison = new Comparison();
        comparison.setComparison_id(22);
        comparison.setShip(getTestShip());
        comparison.setUser(getTestUser());
        return comparison;
    }
    private List<Comparison> getComparisonList() {
        List<Comparison> comparisonList = new ArrayList<>();
        comparisonList.add(getTestComparison());
        Comparison comparison = getTestComparison();
        comparison.setComparison_id(33);
        comparisonList.add(comparison);
        return comparisonList;
    }
    private User getTestUser() {
        User user = new User();
        user.setUserid(22);
        user.setName("Hello");
        user.setSurname("Hello");
        user.setEmail("Hello");
        user.setPassword("Hello");
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);
        return user;
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
}