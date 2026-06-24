package com.joaoVitor1009.workshopmongo.services;

import com.joaoVitor1009.workshopmongo.domain.User;
import com.joaoVitor1009.workshopmongo.repositories.UserRepository;
import com.joaoVitor1009.workshopmongo.services.exception.ObjectNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();

    }
    public User findById(String id){
        Optional<User> user = repo.findById(id);
        User u = null;
        if(!user.isEmpty()){
            u = user.get();
        }
        else {
            throw new ObjectNotFoundException("User Not Found");
        }
        return u;

    }
}
