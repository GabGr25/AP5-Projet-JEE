package junia.projetJEE.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Donjon extends GenericEntity{

    private String nom;

    public Donjon() {

    }

    public Donjon(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
