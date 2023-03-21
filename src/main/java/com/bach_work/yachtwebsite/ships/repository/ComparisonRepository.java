package com.bach_work.yachtwebsite.ships.repository;
import com.bach_work.yachtwebsite.ships.model.Comparison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ComparisonRepository extends JpaRepository<Comparison, Integer> {
    @Query(value = "select c from Comparison c where c.user.Userid = :enterUserId")
    List<Comparison> findByEnterUserId( Integer enterUserId);
}