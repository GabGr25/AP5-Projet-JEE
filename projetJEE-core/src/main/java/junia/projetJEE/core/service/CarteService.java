package junia.projetJEE.core.service;

import jakarta.transaction.Transactional;
import junia.projetJEE.core.dao.CarteDAO;
import junia.projetJEE.core.entity.Carte;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CarteService extends GenericService<Carte>{

    public CarteService(CarteDAO internalDAO) {
        super(internalDAO);
    }
}
