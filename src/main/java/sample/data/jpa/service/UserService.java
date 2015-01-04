package sample.data.jpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import sample.data.jpa.domain.User;
import sample.data.jpa.repository.UserRepository;

@Service
@Transactional
public class UserService extends AbstractService<User, String> {


	UserRepository userRepository;

	@Inject
	UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	protected UserRepository getRepository() {
		return userRepository;
	}
}
