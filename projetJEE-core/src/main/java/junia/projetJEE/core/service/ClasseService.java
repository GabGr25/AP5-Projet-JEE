package junia.projetJEE.core.service;

import jakarta.transaction.Transactional;
import junia.projetJEE.core.dao.ClasseDAO;
import junia.projetJEE.core.entity.Classe;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClasseService extends GenericService<Classe> {

    public ClasseService(ClasseDAO internalDAO) {
        super(internalDAO);
    }
}
