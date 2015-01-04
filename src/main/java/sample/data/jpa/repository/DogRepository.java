package sample.data.jpa.repository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import sample.data.jpa.domain.Dog;

public interface DogRepository extends RestrictedRepository<Dog, Long> {

	@Query("select d from Dog d where ?1 MEMBER OF d.owners")
	List<Dog> findAllForUser(String username);

//	@Query("select d from Dog d where ?1 MEMBER OF d.owners and d.id = ?2")
//	Dog findOneForUser(String username, Long id);

}

