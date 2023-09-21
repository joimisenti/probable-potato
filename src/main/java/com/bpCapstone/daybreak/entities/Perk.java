package com.bpCapstone.daybreak.entities;

import com.bpCapstone.daybreak.dtos.PerkDto;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Perks")
public class Perk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(25)")
    private String name;

    @Column(columnDefinition = "varchar(15)")
    private String survivor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurvivor() {
        return survivor;
    }

    public void setSurvivor(String survivor) {
        this.survivor = survivor;
    }

    // No-arguments Constructor
    public Perk() {
    }

    // All-arguments Constructor
    public Perk(Long id, String name, String survivor) {
        this.id = id;
        this.name = name;
        this.survivor = survivor;
    }

    // Create the Many-to-Many relationship with the Loadouts table
    @ManyToMany(mappedBy = "perks")
    private Set<Loadout> loadouts = new HashSet<>();

    public Perk(PerkDto perkDto) {
        if (perkDto.getName() != null) {
            this.name = perkDto.getName();
        }
        if (perkDto.getSurvivor() != null) {
            this.survivor = perkDto.getSurvivor();
        }
    }
}
