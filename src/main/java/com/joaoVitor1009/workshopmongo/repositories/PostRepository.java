package com.joaoVitor1009.workshopmongo.repositories;

import com.joaoVitor1009.workshopmongo.domain.Post;
import com.joaoVitor1009.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
