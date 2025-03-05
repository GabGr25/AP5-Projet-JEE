package junia.projetJEE.core.service;

import jakarta.transaction.Transactional;
import junia.projetJEE.core.dao.CompetenceDAO;
import junia.projetJEE.core.entity.Competence;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CompetenceService extends GenericService<Competence> {

    public CompetenceService(CompetenceDAO internalDAO) {
        super(internalDAO);
    }
}
