package com.joaoVitor1009.workshopmongo.repositories;

import com.joaoVitor1009.workshopmongo.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
