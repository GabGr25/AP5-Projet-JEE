package junia.projetJEE.core.dao;

import junia.projetJEE.core.entity.Saga;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SagaDAO extends GenericDAO<Saga> {

    @Query("SELECT s FROM Saga s LEFT JOIN FETCH s.phases p LEFT JOIN FETCH p.movies ORDER BY p.id")
    List<Saga> findAllWithPhasesAndMovies();

}
