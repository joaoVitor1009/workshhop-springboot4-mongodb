package com.joaoVitor1009.workshopmongo.services;

import com.joaoVitor1009.workshopmongo.DTO.UserDTO;
import com.joaoVitor1009.workshopmongo.domain.User;
import com.joaoVitor1009.workshopmongo.repositories.UserRepository;
import com.joaoVitor1009.workshopmongo.services.exception.ObjectNotFoundException;
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

    public User insert (User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    public void deleteUser(String user){
        findById(user);
        repo.deleteById(user);

    }
    public User update(User u){
        Optional<User> user = repo.findById(u.getId());
        User newUser = user.get();
        updateData(newUser, u);
        return repo.save(newUser);
    }

    private void updateData(User obj, User obj2){
        obj.setEmail(obj2.getEmail());
        obj.setName(obj2.getName());
    }

}
