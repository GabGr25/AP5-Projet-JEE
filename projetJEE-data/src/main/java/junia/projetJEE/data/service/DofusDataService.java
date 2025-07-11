package junia.projetJEE.data.service;

import jakarta.annotation.PostConstruct;
import junia.projetJEE.core.entity.Personnage;
import junia.projetJEE.core.entity.Donjon;
import junia.projetJEE.core.entity.Carte;
import junia.projetJEE.core.entity.Classe;
import junia.projetJEE.core.entity.Competence;
import junia.projetJEE.core.service.PersonnageService;
import junia.projetJEE.core.service.DonjonService;
import junia.projetJEE.core.service.CarteService;
import junia.projetJEE.core.service.ClasseService;
import junia.projetJEE.core.service.CompetenceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class DofusDataService {

    private final PersonnageService personnageService;
    private final DonjonService donjonService;
    private final CarteService carteService;
    private final ClasseService classeService;
    private final CompetenceService competenceService;

    public DofusDataService(
            PersonnageService personnageService,
            DonjonService donjonService,
            CarteService carteService,
            ClasseService classeService,
            CompetenceService competenceService
    ) {
        this.personnageService = personnageService;
        this.donjonService = donjonService;
        this.carteService = carteService;
        this.classeService = classeService;
        this.competenceService = competenceService;
    }

    @PostConstruct
    public void initData() {
        if (personnageService.countAll() == 0) {
            cleanDB();
            final Map<String, Donjon> donjons = registerDonjons();
            final Map<String, Classe> classes = registerClasses();
            final Map<String, Carte> cartes = registerCartes(donjons);
            final Map<String, Personnage> personnages = registerPersonnages(donjons, classes);
            registerCompetences(classes);
            System.out.println("Base de données initialisée avec succès.");
        } else {
            System.out.println("Base de données déjà initialisée, seeding ignoré.");
        }
    }

    private void cleanDB() {
        competenceService.deleteAll();
        personnageService.deleteAll();
        carteService.deleteAll();
        classeService.deleteAll();
        donjonService.deleteAll();
    }

    private Map<String, Donjon> registerDonjons() {
        Map<String, Donjon> donjons = new HashMap<>();
        donjons.put("refuge_sylvestre", createDonjon("Refuge Sylvestre"));
        donjons.put("galaxieme_dimension", createDonjon("Galaxième Dimension"));
        donjons.put("bouftou_royal", createDonjon("Bouftou Royal"));
        donjons.put("scarafeuille", createDonjon("Scarafeuille"));
        return donjons;
    }

    private Donjon createDonjon(String nom) {
        System.out.println("Enregistrement du donjon : " + nom);
        Donjon donjon = new Donjon();
        donjon.setNom(nom);
        donjonService.save(donjon);
        return donjon;
    }

    private Map<String, Classe> registerClasses() {
        Map<String, Classe> classes = new HashMap<>();
        classes.put("cra", createClasse("Cra", "cra.png"));
        classes.put("ecaflip", createClasse("Ecaflip", "ecaflip.png"));
        classes.put("eliotrope", createClasse("Eliotrope", "eliotrope.png"));
        classes.put("eniripsa", createClasse("Eniripsa", "eniripsa.png"));
        classes.put("enutrof", createClasse("Enutrof", "enutrof.png"));
        classes.put("forgelance", createClasse("Forgelance", "forgelance.png"));
        classes.put("feca", createClasse("Feca", "feca.png"));
        classes.put("hupper", createClasse("Huppermage", "huppermage.png"));
        classes.put("iop", createClasse("Iop", "iop.png"));
        classes.put("osamodas", createClasse("Osamodas", "osamodas.png"));
        classes.put("ouginak", createClasse("Ouginak", "ouginak.png"));
        classes.put("pandawa", createClasse("Pandawa", "pandawa.png"));
        classes.put("roublard", createClasse("Roublard", "roublard.png"));
        classes.put("sacrieur", createClasse("Sacrieur", "sacrieur.png"));
        classes.put("sadida", createClasse("Sadida", "sadida.png"));
        classes.put("sram", createClasse("Sram", "sram.png"));
        classes.put("steamer", createClasse("Steamer", "steamer.png"));
        classes.put("xelor", createClasse("Xelor", "xelor.png"));
        classes.put("zobal", createClasse("Zobal", "zobal.png"));
        return classes;
    }

    private Classe createClasse(String nom, String imageUrl) {
        System.out.println("Enregistrement de la classe : " + nom);
        Classe classe = new Classe();
        classe.setNom(nom);
        classe.setImageURL("/assets/classes/" + imageUrl);
        classeService.save(classe);
        return classe;
    }

    private Map<String, Carte> registerCartes(Map<String, Donjon> donjons) {
        Map<String, Carte> cartes = new HashMap<>();
        cartes.put("refuge_sylvestre", createCarte("Donjon du Refuge Sylvestre", "donjon_refuge_sylvestre.png", donjons.get("refuge_sylvestre")));
        cartes.put("galaxieme_dimension", createCarte("Donjon de la Galaxième Dimension", "donjon_gelaxieme_dimension.png", donjons.get("galaxieme_dimension")));
        cartes.put("bouftou_royale", createCarte("Donjon du Bouf Boutou Royal", "donjon_bouftou_royal.png", donjons.get("bouftou_royal")));
        cartes.put("scarafeuille", createCarte("Donjon de Scarafeuille", "donjon_scarafeuille.png", donjons.get("scarafeuille")));
        return cartes;
    }

    private Carte createCarte(String nom, String imageUrl, Donjon donjon) {
        System.out.println("Enregistrement de la carte : " + nom);
        Carte carte = new Carte();
        carte.setNom(nom);
        carte.setImageURL("/assets/cartes/" + imageUrl);
        carte.setDonjon(donjon);
        carteService.save(carte);
        return carte;
    }

    private Map<String, Personnage> registerPersonnages(Map<String, Donjon> donjons, Map<String, Classe> classes) {
        Map<String, Personnage> personnages = new HashMap<>();
        personnages.put("coco_royal", createPersonnage("Blop Coco Royal", "blop_coco_royal.png", donjons.get("bouf_royal")));
        personnages.put("bouftou_royale", createPersonnage("Bouftou Royale", "bouftou_royale.png", donjons.get("bouftou_royal")));
        personnages.put("craqueleur", createPersonnage("Craqueleur", "Craqueleur.png", null));
        personnages.put("kwakwa", createPersonnage("Kwakwa", "kwakwa.png", null));
        personnages.put("maitre_bolet", createPersonnage("Maître Bolet", "Maitre_bolet.png", null));
        personnages.put("meulou", createPersonnage("Meulou", "Meulou.png", null));
        personnages.put("moskito", createPersonnage("Moskito", "Moskito.png", null));
        personnages.put("shin_larve", createPersonnage("Shin Larve", "shin_larve.png", null));
        personnages.put("sphincter_cell", createPersonnage("Sphincter Cell", "Sphincter_cell.png", null));
        personnages.put("tournesol_affame", createPersonnage("Tournesol Affamé", "tournesol_affame.png", null));
        personnages.put("wawabbit", createPersonnage("Wawabbit", "wawabbit.png", null));
        return personnages;
    }

    private Personnage createPersonnage(String nom, String imageUrl, Donjon donjon) {
        System.out.println("Enregistrement du personnage : " + nom);
        Personnage personnage = new Personnage();
        personnage.setNom(nom);
        personnage.setImageURL("/assets/personnages/" + imageUrl);
        personnage.setDonjon(donjon);
        personnageService.save(personnage);
        return personnage;
    }

    private void registerCompetences(Map<String, Classe> classes) {
        // Cra
        createCompetence("Tir Critique", "cra.png", classes.get("cra"));

        // Ecaflip
        createCompetence("Pile ou Face", "ecaflip.png", classes.get("ecaflip"));

        // Eliotrope
        createCompetence("Rayon de Lumière", "eliotrope.png", classes.get("eliotrope"));

        // Eniripsa
        createCompetence("Mot de Soin", "eniripsa.png", classes.get("eniripsa"));

        // Enutrof
        createCompetence("Chance de Prospection", "enutrof.png", classes.get("enutrof"));

        // Forgelance
        createCompetence("Frappe Résonante", "forgelance.png", classes.get("forgelance"));

        // Feca
        createCompetence("Bouclier Protecteur", "feca.png", classes.get("feca"));

        // Huppermage
        createCompetence("Magie Élémentaire", "huppermage.png", classes.get("hupper"));

        // Iop
        createCompetence("Frappe Divine", "iop.png", classes.get("iop"));

        // Osamodas
        createCompetence("Invocation de Créature", "osamodas.png", classes.get("osamodas"));

        // Ouginak
        createCompetence("Rage Canine", "ouginak.png", classes.get("ouginak"));

        // Pandawa
        createCompetence("Tonneau de Force", "pandawa.png", classes.get("pandawa"));

        // Roublard
        createCompetence("Piège Subtil", "roublard.png", classes.get("roublard"));

        // Sacrieur
        createCompetence("Sacrifice", "sacrieur.png", classes.get("sacrieur"));

        // Sadida
        createCompetence("Invocation de Plantes", "sadida.png", classes.get("sadida"));

        // Sram
        createCompetence("Coup Fourré", "sram.png", classes.get("sram"));

        // Steamer
        createCompetence("Vapeur Mortelle", "steamer.png", classes.get("steamer"));

        // Xelor
        createCompetence("Manipulation du Temps", "xelor.png", classes.get("xelor"));

        // Zobal
        createCompetence("Absorption Temporelle", "zobal.png", classes.get("zobal"));
    }

    private void createCompetence(String nom, String imageUrl, Classe classe) {
        System.out.println("Enregistrement de la compétence : " + nom);
        Competence competence = new Competence();
        competence.setNom(nom);
        competence.setImageURL("/assets/competences/" + imageUrl);
        competence.setClasse(classe);
        competenceService.save(competence);
    }
}