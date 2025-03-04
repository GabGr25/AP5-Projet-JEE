package junia.projetJEE.core.service;

import jakarta.transaction.Transactional;
import junia.projetJEE.core.dao.PhaseDAO;
import junia.projetJEE.core.entity.Phase;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PhaseService extends GenericService<Phase> {

    protected PhaseService(PhaseDAO internalDAO) {
        super(internalDAO);
    }
}
