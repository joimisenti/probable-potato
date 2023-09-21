package com.bpCapstone.daybreak.repositories;

import com.bpCapstone.daybreak.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
