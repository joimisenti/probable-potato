package com.bpCapstone.daybreak.services;

import com.bpCapstone.daybreak.dtos.LoadoutDto;
import com.bpCapstone.daybreak.entities.Loadout;
import com.bpCapstone.daybreak.entities.User;
import com.bpCapstone.daybreak.repositories.LoadoutRepository;
import com.bpCapstone.daybreak.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoadoutServiceImpl implements LoadoutService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoadoutRepository loadoutRepository;

    // Add a loadout to the user's list
    @Override
    @Transactional
    public void addLoadout(LoadoutDto loadoutDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Loadout loadout = new Loadout(loadoutDto);
        userOptional.ifPresent(loadout::setUser);
        loadoutRepository.saveAndFlush(loadout);
    }

    // Delete a loadout from the user's list
    @Override
    @Transactional
    public void deleteLoadoutById(Long loadoutId) {
        Optional<Loadout> loadoutOptional = loadoutRepository.findById(loadoutId);
        loadoutOptional.ifPresent(loadout -> loadoutRepository.delete(loadout));
    }

    // Update a loadout in the user's list
    @Override
    @Transactional
    public void updateLoadoutById(LoadoutDto loadoutDto) {
        Optional<Loadout> loadoutOptional = loadoutRepository.findById(loadoutDto.getId());
        loadoutOptional.ifPresent(loadout -> {
            loadout.setBuildType(loadoutDto.getBuildType());
//            loadout.setPerks(loadoutDto.getPerks());
            loadout.setSummary(loadoutDto.getSummary());
            loadoutRepository.saveAndFlush(loadout);
        });
    }

    // Finding all loadouts by a user
    @Override
    public List<LoadoutDto> getAllLoadoutsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Loadout> loadoutList = loadoutRepository.findAllByUserEquals(userOptional.get());
            return loadoutList.stream().map(loadout -> new LoadoutDto(loadout)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    // Getting a Loadout by the loadout Id
    @Override
    public Optional<LoadoutDto> getLoadoutById(Long loadoutId) {
        Optional<Loadout> loadoutOptional = loadoutRepository.findById(loadoutId);
        if (loadoutOptional.isPresent()) {
            return Optional.of(new LoadoutDto(loadoutOptional.get()));
        }
        return Optional.empty();
    }
}
