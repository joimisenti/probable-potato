package com.bpCapstone.daybreak.repositories;

import com.bpCapstone.daybreak.entities.Loadout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadoutRepository extends JpaRepository<Loadout, Long> {
}
