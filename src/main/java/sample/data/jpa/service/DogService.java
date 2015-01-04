package sample.data.jpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import sample.data.jpa.domain.Dog;
import sample.data.jpa.repository.DogRepository;

@Service
@Transactional
public class DogService extends AbstractRestrictedService<Dog, Long> {


	DogRepository dogRepository;

	@Inject
	DogService(DogRepository dogRepository) {
		this.dogRepository = dogRepository;
	}

	@Override
	protected DogRepository getRepository() {
		return dogRepository;
	}
}
