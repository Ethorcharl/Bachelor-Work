package com.bach_work.yachtwebsite.ships.service;
import com.bach_work.yachtwebsite.ships.model.Comparison;
import com.bach_work.yachtwebsite.ships.repository.ComparisonRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ComparisonService {
    private final ComparisonRepository comparisonRepository;
    public ComparisonService(ComparisonRepository comparisonRepository) {
        this.comparisonRepository = comparisonRepository;
    }
    public Comparison findById(Integer id) {
        return comparisonRepository.findById(id).orElse(null);
    }
    public List<Comparison> findAll() {
        return comparisonRepository.findAll();
    }
    public Comparison saveComparison(Comparison comparison) {
        return comparisonRepository.save(comparison);
    }
    public void deleteById(Integer id) {
        comparisonRepository.deleteById(id);
    }
    public List<Comparison> findByEnterUserId(Integer enterUserId) {
        return comparisonRepository.findByEnterUserId(enterUserId);
    }
}