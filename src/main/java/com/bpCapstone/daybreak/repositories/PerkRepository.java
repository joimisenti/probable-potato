package com.bpCapstone.daybreak.repositories;

import com.bpCapstone.daybreak.entities.Perk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerkRepository extends JpaRepository<Perk, Long> {
}
