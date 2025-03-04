package junia.projetJEE.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;

import java.util.Set;

@Entity
public class Phase extends GenericEntity implements Comparable<Phase>{

    private String name;

    @ManyToOne
    private Saga saga;

    @OneToMany(mappedBy = "phase")
    @OrderBy("releaseDate asc")
    private Set<Movie> movies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Saga getSaga() {
        return saga;
    }

    public void setSaga(Saga saga) {
        this.saga = saga;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }


    @Override
    public int compareTo(Phase o) {
        return Long.compare(this.getId(),o.getId());
    }
}
