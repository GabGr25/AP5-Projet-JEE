package junia.projetJEE.core.service;

import jakarta.transaction.Transactional;
import junia.projetJEE.core.dao.DonjonDAO;
import junia.projetJEE.core.entity.Donjon;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DonjonService extends GenericService<Donjon> {

    public DonjonService(DonjonDAO internalDAO) {
        super(internalDAO);
    }
}
