package junia.projetJEE.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;

import java.util.Set;
import java.util.TreeSet;

@Entity
public class Saga extends GenericEntity{

    private String name;

    @OneToMany(mappedBy = "saga")
    @OrderBy("id asc")
    private Set<Phase> phases;

    public Saga() {
        phases = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Phase> getPhases() {
        return phases;
    }

    public void setPhases(Set<Phase> phases) {
        this.phases = phases;
    }

    public int getNumberOfMovies(){
        return phases.stream().mapToInt(p->p.getMovies().size()).sum();
    }
}
