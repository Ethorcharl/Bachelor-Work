package com.bach_work.yachtwebsite.ships.repository;
import com.bach_work.yachtwebsite.ships.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ShipRepository extends JpaRepository<Ship, Integer> {
    @Query(value = "select * from ships s where s.name like %:entername% ", nativeQuery = true)
    List<Ship> findByEnterName(@Param("entername") String entername);
    @Query(value = "select s from Ship s where " +
            "s.length <= :enterlength and " +
            "s.guests<= :enterguests and " +
            "s.rent_cost<= :enterCost ")
    List<Ship> findByLength( @Param("enterlength") Integer enterlength, Integer enterguests, Integer enterCost);
}
