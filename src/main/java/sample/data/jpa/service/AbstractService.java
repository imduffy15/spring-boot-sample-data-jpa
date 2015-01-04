package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

@Transactional
public abstract class AbstractService<T, ID extends Serializable> {

	public void delete(ID id) {
		findOne(id);
		getRepository().delete(id);
	}

	@Transactional(readOnly = true)
	public List<T> findAll() {
		return getRepository().findAll();
	}

	@Transactional(readOnly = true)
	public T findOne(ID id) {
		T entity = getRepository().findOne(id);
		if (entity == null) {
			throw new EntityNotFoundException();
		}
		return entity;
	}

	abstract protected JpaRepository<T, ID> getRepository();
}
