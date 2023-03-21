package com.bach_work.yachtwebsite.service;
import com.bach_work.yachtwebsite.auth.model.Role;
import com.bach_work.yachtwebsite.auth.model.Status;
import com.bach_work.yachtwebsite.auth.model.User;
import com.bach_work.yachtwebsite.auth.repository.UserRepository;
import com.bach_work.yachtwebsite.auth.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
public class UserServiceTest {
    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository);
    private final int userId = 11;
    @Test
    public void findByIdTest() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(getTestUser()));
        User user = userService.findById(userId);
        assertEquals(22, user.getUserid());
    }
    @Test
    public void findByIdTestFailure() {
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        User user = userService.findById(userId);
        assertNull(user);
    }
    @Test
    public void findAllTest() {
        when(userRepository.findAll()).thenReturn(getUserList());
        assertEquals(2, userService.findAll().size());
    }
    @Test
    public void saveShip() {
        User userToSave = getTestUser();
        when(userRepository.save(userToSave)).thenReturn(userToSave);
        User user = userService.saveUser(userToSave);
        assertEquals(getTestUser().getUserid(), user.getUserid());
    }
    @Test
    public void deleteByIdTest() {
        assertDoesNotThrow(() -> userService.deleteById(userId));
    }
    @Test
    public void findByEnterEmailTest() {
        when(userRepository.findByEnterEmail("Hello")).thenReturn(getTestUser());
        assertEquals(getTestUser(), userService.findByEnterEmail("Hello"));
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
    private List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(getTestUser());
        User user = getTestUser();
        user.setUserid(33);
        userList.add(user);
        return userList;
    }
}