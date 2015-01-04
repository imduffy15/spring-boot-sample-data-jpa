package sample.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.data.jpa.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

}
