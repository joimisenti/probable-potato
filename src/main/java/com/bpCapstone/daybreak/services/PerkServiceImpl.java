package com.bpCapstone.daybreak.services;

import com.bpCapstone.daybreak.dtos.PerkDto;
import com.bpCapstone.daybreak.entities.Perk;
import com.bpCapstone.daybreak.entities.User;
import com.bpCapstone.daybreak.repositories.LoadoutRepository;
import com.bpCapstone.daybreak.repositories.PerkRepository;
import com.bpCapstone.daybreak.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PerkServiceImpl {

    @Autowired
    private PerkRepository perkRepository;
    @Autowired
    private LoadoutRepository loadoutRepository;
    @Autowired
    private UserRepository userRepository;

    // Get all Perks
    public List<Perk> getAllPerks() {
        return perkRepository.findAll();
    }

    // Add a perk to the Perks list set uniquely by a User
//    @Transactional
//    public void addPerkByUser(PerkDto perkDto, Long userId) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        Perk perk = new Perk(perkDto);
//        userOptional.ifPresent(perk::setUser);
//        perkRepository.saveAndFlush(perk);
//    }

    // Delete a Perk
    @Transactional
    public void deletePerkById(Long perkId) {
        Optional<Perk> perkOptional = perkRepository.findById(perkId);
        perkOptional.ifPresent(perk -> perkRepository.delete(perk));
    }

    // Updating a Perk
    @Transactional
    public void updatePerkById(PerkDto perkDto) {
        Optional<Perk> perkOptional = perkRepository.findById(perkDto.getId());
        perkOptional.ifPresent(perk -> {
            perk.setName(perkDto.getName());
            perk.setSurvivor(perkDto.getSurvivor());
            perkRepository.saveAndFlush(perk);
        });
    }

    // Get all Perks made by a User
    public List<PerkDto> getAllPerksByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Perk> perkList = perkRepository.findAllByUserEquals(userOptional.get());
            return perkList.stream().map(perk -> new PerkDto(perk)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    // Get a Perk by the Perk id
    public Optional<PerkDto> getPerkById(Long perkId) {
        Optional<Perk> perkOptional = perkRepository.findById(perkId);
        if (perkOptional.isPresent()) {
            return Optional.of(new PerkDto(perkOptional.get()));
        }
        return Optional.empty();
    }
}
