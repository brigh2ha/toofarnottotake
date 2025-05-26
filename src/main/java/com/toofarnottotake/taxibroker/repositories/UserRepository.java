package com.toofarnottotake.taxibroker.repositories;

import com.toofarnottotake.taxibroker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByEmail(String email);
}
