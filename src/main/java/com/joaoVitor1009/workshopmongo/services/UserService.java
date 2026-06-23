package com.joaoVitor1009.workshopmongo.services;

import com.joaoVitor1009.workshopmongo.domain.User;
import com.joaoVitor1009.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();

    }
}
