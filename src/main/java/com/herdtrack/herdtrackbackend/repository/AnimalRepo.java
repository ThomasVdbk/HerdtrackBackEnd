package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimalRepo extends JpaRepository<Animal, Long> {


    /**
     * Trouvez un animal par son identifiant et renvoyez-le enveloppé dans un Facultatif.
     *
     * @param id L'identifiant de l'animal à trouver.
     * @return Facultatif<Animal>
     */
    Optional<Animal> findById(Long id);

    /**
     * Trouver tous les animaux avec la référence donnée.
     *
     * @param reference La référence de l'animal à rechercher.
     * @return Une liste d'animaux avec la référence donnée.
     */
    List<Animal> findByReference(String reference);

    /**
     * Trouvez tous les animaux avec le nom donné.
     *
     * @param nom le nom de la méthode
     * @return Une liste d'animaux avec le nom "nom"
     */
    List<Animal> findByNom(String nom);

}
