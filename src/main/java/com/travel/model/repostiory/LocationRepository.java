package com.travel.model.repostiory;

import com.travel.model.entities.Location;
import com.travel.model.entities.enums.LocationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByName(LocationEnum locationEnum);
}
