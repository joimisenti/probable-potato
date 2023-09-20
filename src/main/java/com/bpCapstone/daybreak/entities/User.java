package com.bpCapstone.daybreak.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


// supabase password: pemmwAPO9qMx1L4t
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Create the One-to-Many relationship with the Loadouts table

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference
    private Set<Loadout> loadoutSet = new HashSet<>();
//    @JoinTable(
//    name = "Loadouts",
//    joinColumns = { @JoinColumn(name = "loadout_id") },
//    inverseJoinColumns = { @JoinColumn(name = "user_id")
//    @JsonManagedReference
//    private Set<Loadout> loadoutSet = new HashSet<>();

//    @OneToMany
//    @JoinTable(
//            name = "Loadouts",
//            joinColumns = @JoinColumn(name = "loadout_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private Set<Loadout> loadoutSet = new HashSet<>();
}
