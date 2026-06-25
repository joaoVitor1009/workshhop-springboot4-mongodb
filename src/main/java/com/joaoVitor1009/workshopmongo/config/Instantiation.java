package com.joaoVitor1009.workshopmongo.config;

import com.joaoVitor1009.workshopmongo.DTO.AuthorDTO;
import com.joaoVitor1009.workshopmongo.DTO.CommentDTO;
import com.joaoVitor1009.workshopmongo.domain.Post;
import com.joaoVitor1009.workshopmongo.domain.User;
import com.joaoVitor1009.workshopmongo.repositories.PostRepository;
import com.joaoVitor1009.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        postRepository.deleteAll();
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Brown", "alex@gmail.com");
        User bob = new User(null, "Bob Brown", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para SP!!!", new AuthorDTO(maria));
        Post post2 = new Post(null,sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje",new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mana!", sdf.parse("21/03/2018"),new AuthorDTO(bob));
        CommentDTO c2 = new CommentDTO("tenha uma otima viagem", sdf.parse("22/03/2018"),new AuthorDTO(alex));
        CommentDTO c3 = new CommentDTO("Fico feliz, bom dia", sdf.parse("23/03/2018"),new AuthorDTO(alex));

        post1.getComment().addAll(Arrays.asList(c1, c2));
        post2.getComment().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);
    }
}
