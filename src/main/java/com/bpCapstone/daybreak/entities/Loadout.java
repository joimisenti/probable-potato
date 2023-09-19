package com.bpCapstone.daybreak.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

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

}
