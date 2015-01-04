package sample.data.jpa.service;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import sample.data.jpa.repository.RestrictedRepository;

@Transactional
public abstract class AbstractRestrictedService<T, ID extends Serializable>
		extends AbstractService<T, ID> {

	@Transactional(readOnly = true)
	public List<T> findAllForUser(String username) {
		return getRepository().findAllForUser(username);
	}

	@Transactional(readOnly = true)
	public T findOneForUser(String username, ID id) {
		T entity = getRepository().findOneForUser(username, id);
		if (entity == null) {
			throw new EntityNotFoundException();
		}
		return entity;
	}

	abstract protected RestrictedRepository<T, ID> getRepository();

}
