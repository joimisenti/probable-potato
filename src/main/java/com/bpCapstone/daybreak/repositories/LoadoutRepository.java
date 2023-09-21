package com.bpCapstone.daybreak.repositories;

import com.bpCapstone.daybreak.entities.Loadout;
import com.bpCapstone.daybreak.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadoutRepository extends JpaRepository<Loadout, Long> {
    List<Loadout> findAllByUserEquals(User user);
}
