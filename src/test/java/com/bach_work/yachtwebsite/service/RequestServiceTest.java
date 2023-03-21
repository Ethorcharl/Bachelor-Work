package com.bach_work.yachtwebsite.service;
import com.bach_work.yachtwebsite.auth.model.Role;
import com.bach_work.yachtwebsite.auth.model.Status;
import com.bach_work.yachtwebsite.auth.model.User;
import com.bach_work.yachtwebsite.ships.model.*;
import com.bach_work.yachtwebsite.ships.repository.RequestRepository;
import com.bach_work.yachtwebsite.ships.service.RequestService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
public class RequestServiceTest {
    private final RequestRepository requestRepository = Mockito.mock(RequestRepository.class);
    private final RequestService requestService = new RequestService(requestRepository);
    private final int requestId = 11;
    @Test
    public void findByIdTest() {
        when(requestRepository.findById(requestId)).thenReturn(Optional.of(getTestRequest()));
        Request request = requestService.findByID(requestId);
        assertEquals(22, request.getRequest_id());
    }
    @Test
    public void findByIdTestFailure() {
        when(requestRepository.findById(requestId)).thenReturn(Optional.empty());
        Request request = requestService.findByID(requestId);
        assertNull(request);
    }
    @Test
    public void findAllTest() {
        when(requestRepository.findAll()).thenReturn(getRequestList());
        assertEquals(2, requestService.findAll().size());
    }
    @Test
    public void saveShip() {
        Request requestToSave=getTestRequest();
        when(requestRepository.save(requestToSave)).thenReturn(requestToSave);
        Request request = requestService.saveRequest(requestToSave);
        assertEquals(getTestRequest().getRequest_id(), request.getRequest_id());
    }
    @Test
    public void deleteByIdTest() {
        assertDoesNotThrow(()->requestService.deleteById(requestId));
    }
    private Request getTestRequest(){
        Date dateOne = new Date();
        Request request = new Request();
        request.setRequest_id(22);
        request.setUser_user(getTestUser());
        request.setUser_manager(getTestManager());
        request.setDescription("Hello");
        request.setDatestart(dateOne);
        request.setDateend(dateOne);
        request.setDatesending(dateOne);
        request.setStatus(Status_request.WAITING);
        request.setShip(getTestShip());
        return request;
    }
    private List<Request> getRequestList() {
        List<Request> requestList = new ArrayList<>();
        requestList.add(getTestRequest());
        Request request = getTestRequest();
        request.setRequest_id(33);
        requestList.add(request);
        return requestList;
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
    private User getTestManager() {
        User user = new User();
        user.setUserid(22);
        user.setName("Hello");
        user.setSurname("Hello");
        user.setEmail("Hello");
        user.setPassword("Hello");
        user.setRole(Role.MANAGER);
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