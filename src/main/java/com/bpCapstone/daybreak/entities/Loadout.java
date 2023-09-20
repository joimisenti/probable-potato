package com.bpCapstone.daybreak.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Loadouts")
public class Loadout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(40)")
    private String buildType;

    @Column(columnDefinition = "text[]")
    @Type(value = com.bpCapstone.daybreak.entities.PostgreSqlStringArrayType.class)
    private String[] perks;

    @Column(columnDefinition = "text")
    private String summary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
    }

    public String[] getPerks() {
        return perks;
    }

    public void setPerks(String[] perks) {
        this.perks = perks;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    // No-arguments Constructor
    public Loadout() {
    }

    // All-arguments Constructor
    public Loadout(Long id, String buildType, String[] perks, String summary) {
        this.id = id;
        this.buildType = buildType;
        this.perks = perks;
        this.summary = summary;
    }

    // Create the Many-to-One relationship to the Users table
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonBackReference
    private User user;

    // Create the Many-to-Many relationship with the Loadouts table
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Loadout_Perks",
            joinColumns = { @JoinColumn(name = "loadout_id") },
            inverseJoinColumns = { @JoinColumn(name = "perk_id") }
    )
    private Set<Perk> perkSet = new HashSet<>();

}
