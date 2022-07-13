package com.herdtrack.herdtrackbackend.repository;


import com.herdtrack.herdtrackbackend.entity.Raison;
import com.herdtrack.herdtrackbackend.entity.Sortie;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SortieRepo extends JpaRepository<Sortie, Long> {


    /**
     * Recherchez une sortie par son identifiant et renvoyez-la en option.
     *
     * @param id L'identifiant de la sortie que vous souhaitez rechercher.
     * @return Facultatif<Sortie>
     */
    Optional<Sortie> findById(Long id);

    /**
     * Trouvez toutes les sorties qui se sont produites à la date donnée.
     *
     * @param date La date de la sortie.
     * @return Une liste d'objets Sortie.
     */
    List<Sortie> findByDate(Date date);


    List<Sortie> findByRaison(Raison raison);

}
