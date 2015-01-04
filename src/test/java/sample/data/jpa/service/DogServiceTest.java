package sample.data.jpa.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import sample.data.jpa.SampleDataJpaApplication;
import sample.data.jpa.domain.Dog;
import sample.data.jpa.domain.User;
import sample.data.jpa.repository.DogRepository;
import sample.data.jpa.repository.UserRepository;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleDataJpaApplication.class)
public class DogServiceTest {

	public Dog dog1;

	public Dog dog2;

	// This is horrible but it will do for a quick example.
	public User user1;

	public User user2;

	@Inject
	DogRepository dogRepository;

	@Inject
	DogService dogService;

	@Inject
	UserRepository userRepository;

	@Before
	public void Setup() {
		dogService = new DogService(dogRepository);

		user1 = new User("example-user1");
		user2 = new User("example-user2");
		userRepository.save(user1);
		userRepository.save(user2);

		dog1 = new Dog("example-dog1", Arrays.asList(user1));
		dog2 = new Dog("example-dog2", Arrays.asList(user2));
		dogRepository.save(dog1);
		dogRepository.save(dog2);
	}

	@Test
	public void findAllForUserTest() {
		List<Dog> dogs = dogService.findAllForUser("example-user1");
		assert dogs.size() == 1;

		dogs = dogService.findAllForUser("example-user2");
		assert dogs.size() == 1;
	}

	@Test
	public void findAllTest() {
		List<Dog> dogs = dogService.findAll();
		assert dogs.size() == 2;
	}

	@Test
	public void findOne() {
		Dog dog = dogService.findOne(dog1.getId());
		assert dog != null;
		assert dog.getId() == dog1.getId();
	}

	@Test
	public void findOneForUserTest() {
		Dog dog = dogService.findOneForUser("example-user1", dog1.getId());
		assert dog != null;
		assert dog.getId() == dog1.getId();
	}
}
