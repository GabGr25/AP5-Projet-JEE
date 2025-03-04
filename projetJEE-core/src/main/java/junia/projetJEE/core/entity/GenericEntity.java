package junia.projetJEE.core.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class GenericEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public long getId() {
        return id;
    }


}
