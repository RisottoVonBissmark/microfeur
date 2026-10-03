package com.exemple.microfeur.location.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.exemple.microfeur.location.model.Location;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location,Integer> {
    List<Location> findByUserId(Integer userId);
}
