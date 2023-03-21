package com.bach_work.yachtwebsite.ships.repository;
import com.bach_work.yachtwebsite.ships.model.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TypeRepository extends JpaRepository <ShipType, Integer> {
}