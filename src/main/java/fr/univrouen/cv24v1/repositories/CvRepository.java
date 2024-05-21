package fr.univrouen.cv24v1.repositories;

import fr.univrouen.cv24v1.models.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<Cv, Long> {
}