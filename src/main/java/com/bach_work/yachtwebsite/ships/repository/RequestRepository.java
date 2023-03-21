package com.bach_work.yachtwebsite.ships.repository;
import com.bach_work.yachtwebsite.ships.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RequestRepository extends JpaRepository<Request, Integer> {
}