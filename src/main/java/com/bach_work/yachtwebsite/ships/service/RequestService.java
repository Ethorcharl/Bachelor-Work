package com.bach_work.yachtwebsite.ships.service;
import com.bach_work.yachtwebsite.ships.model.Request;
import com.bach_work.yachtwebsite.ships.repository.RequestRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RequestService {
    private final RequestRepository requestRepository;
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }
    public Request findByID(Integer id) {
        return requestRepository.findById(id).orElse(null);
    }
    public List<Request> findAll() {
        return requestRepository.findAll();
    }
    public Request saveRequest(Request request) {
        return requestRepository.save(request);
    }
    public void deleteById(Integer id) {
        requestRepository.deleteById(id);
    }
}