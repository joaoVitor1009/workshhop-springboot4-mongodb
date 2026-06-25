package com.joaoVitor1009.workshopmongo.resources;

import com.joaoVitor1009.workshopmongo.DTO.UserDTO;
import com.joaoVitor1009.workshopmongo.domain.Post;
import com.joaoVitor1009.workshopmongo.domain.User;
import com.joaoVitor1009.workshopmongo.resources.util.URL;
import com.joaoVitor1009.workshopmongo.services.PostService;
import com.joaoVitor1009.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static java.awt.SystemColor.text;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "" ) String text){
        text = URL.decodeParam(text);
        List<Post> list = service.finByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
