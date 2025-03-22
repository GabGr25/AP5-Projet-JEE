package junia.projetJEE.core.service;

import jakarta.transaction.Transactional;
import junia.projetJEE.core.dao.CarteDAO;
import junia.projetJEE.core.entity.Carte;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarteService extends GenericService<Carte> {

    private final CarteDAO carteDAO;

    public CarteService(CarteDAO internalDAO) {
        super(internalDAO);
        this.carteDAO = internalDAO;
    }

    public List<String> getAllCarteNoms() {
        List<Carte> cartes = findAll();
        return cartes.stream()
                .map(Carte::getNom)
                .collect(Collectors.toList());
    }


}