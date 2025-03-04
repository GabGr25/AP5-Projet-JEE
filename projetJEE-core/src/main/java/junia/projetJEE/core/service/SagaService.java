package junia.projetJEE.core.service;

import jakarta.transaction.Transactional;
import junia.projetJEE.core.dao.SagaDAO;
import junia.projetJEE.core.entity.Saga;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SagaService extends GenericService<Saga> {

    private final SagaDAO sagaDAO;

    protected SagaService(SagaDAO sagaDAO) {
        super(sagaDAO);
        this.sagaDAO = sagaDAO;
    }

    public List<Saga> findAllWithPhasesAndMovies() {
        return sagaDAO.findAllWithPhasesAndMovies();
    }
}
