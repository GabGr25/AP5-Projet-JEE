package junia.projetJEE.core.service;

import jakarta.transaction.Transactional;
import junia.projetJEE.core.dao.PersonnageDAO;
import junia.projetJEE.core.entity.Carte;
import junia.projetJEE.core.entity.Personnage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonnageService extends GenericService<Personnage> {
    private final PersonnageDAO personnageDAO;

    public PersonnageService(PersonnageDAO internalDAO) {
        super(internalDAO);
        this.personnageDAO = internalDAO;
    }

    public List<String> getAllPersonnageNoms() {
        List<Personnage> personnages = findAll();
        return personnages.stream()
                .map(Personnage::getNom)
                .collect(Collectors.toList());
    }
}