package junia.projetJEE.core.dao;

import junia.projetJEE.core.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface GenericDAO<T extends GenericEntity> extends JpaRepository<T, Long> {

}
