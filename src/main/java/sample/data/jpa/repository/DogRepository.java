package sample.data.jpa.repository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import sample.data.jpa.domain.Dog;

public interface DogRepository extends RestrictedRepository<Dog, Long> {
}

