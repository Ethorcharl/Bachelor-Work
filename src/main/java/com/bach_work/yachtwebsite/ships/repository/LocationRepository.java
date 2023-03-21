package com.bach_work.yachtwebsite.ships.repository;
import com.bach_work.yachtwebsite.ships.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LocationRepository extends JpaRepository<Location, Integer> {
}