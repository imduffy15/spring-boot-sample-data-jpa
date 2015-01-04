package sample.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface RestrictedRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	List<T> findAllForUser(String username);
	T findOneForUser(String username, ID id);

}
