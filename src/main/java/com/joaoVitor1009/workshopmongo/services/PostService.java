package com.joaoVitor1009.workshopmongo.services;

import com.joaoVitor1009.workshopmongo.DTO.UserDTO;
import com.joaoVitor1009.workshopmongo.domain.Post;
import com.joaoVitor1009.workshopmongo.domain.User;
import com.joaoVitor1009.workshopmongo.repositories.PostRepository;
import com.joaoVitor1009.workshopmongo.repositories.UserRepository;
import com.joaoVitor1009.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo ;

    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        Post p = null;
        if(!post.isEmpty()){
            p = post.get();
        }
        else {
            throw new ObjectNotFoundException("Post Not Found");
        }
        return p;
    }

    public List<Post> finByTitle (String text){
        return repo.searchTitle(text);
    }
}
