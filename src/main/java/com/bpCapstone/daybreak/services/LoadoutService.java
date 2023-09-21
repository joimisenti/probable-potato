package com.bpCapstone.daybreak.services;

import com.bpCapstone.daybreak.dtos.LoadoutDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface LoadoutService {
    // Add a loadout to the user's list
    @Transactional
    void addLoadout(LoadoutDto loadoutDto, Long userId);

    // Delete a loadout from the user's list
    @Transactional
    void deleteLoadoutById(Long loadoutId);

    // Update a loadout in the user's list
    @Transactional
    void updateLoadoutById(LoadoutDto loadoutDto);

    // Finding all loadouts by a user
    List<LoadoutDto> getAllLoadoutsByUserId(Long userId);

    // Getting a Loadout by the loadout Id
    Optional<LoadoutDto> getLoadoutById(Long loadoutId);
}
