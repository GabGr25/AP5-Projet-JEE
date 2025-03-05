package junia.projetJEE.core.service;

import jakarta.transaction.Transactional;
import junia.projetJEE.core.dao.PersonnageDAO;
import junia.projetJEE.core.entity.Personnage;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonnageService extends GenericService<Personnage> {

    public PersonnageService(PersonnageDAO internalDAO) {
        super(internalDAO);
    }
}
