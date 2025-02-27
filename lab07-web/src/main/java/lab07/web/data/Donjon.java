package lab07.web.data;

public class Donjon {

    private long id;

    private String nom;

    public Donjon() {
    }

    public Donjon(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
