package com.example.microfeur.user.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.microfeur.user.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
