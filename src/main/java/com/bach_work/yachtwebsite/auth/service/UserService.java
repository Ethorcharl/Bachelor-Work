package com.bach_work.yachtwebsite.auth.service;
import com.bach_work.yachtwebsite.auth.model.User;
import com.bach_work.yachtwebsite.auth.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
    public User findByEnterEmail(String enterEmail) {
        return userRepository.findByEnterEmail(enterEmail);
    }
}