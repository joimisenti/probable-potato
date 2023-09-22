package com.bpCapstone.daybreak.repositories;

import com.bpCapstone.daybreak.entities.Perk;
import com.bpCapstone.daybreak.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerkRepository extends JpaRepository<Perk, Long> {
    List<Perk> findAllByUserEquals(User user);
}
