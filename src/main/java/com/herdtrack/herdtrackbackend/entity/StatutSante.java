package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;
import java.util.List;

/*

Classe Statut Santé d'un animal ou d'un parc
@author Nicolas Desdevises
 */
@Entity
@Table(name = "statut_sante")
public class StatutSante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "libelle", nullable = false, length = 50)
    private String libelle;
    @OneToMany(mappedBy = "statutSante", fetch = FetchType.LAZY)
    private List<Parc> parcs;
}
