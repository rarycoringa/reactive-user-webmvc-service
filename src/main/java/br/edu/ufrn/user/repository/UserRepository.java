package br.edu.ufrn.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufrn.user.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}
