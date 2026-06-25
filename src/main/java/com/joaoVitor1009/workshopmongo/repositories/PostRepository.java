package com.joaoVitor1009.workshopmongo.repositories;

import com.joaoVitor1009.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title':  { $regex:  ?0, $options : 'i'}}")
    List<Post> searchTitle(String text);

   /*
   Este metodo é o mesmo que o acima porem este não possui as declarações, a vantaagem do metodo acima é que ele pode ser personalizado.
   List<Post> findByTitleContainingIgnoreCase(String text);
   */

    @Query("{ $and :  [ {date: {$gte: ?1 } }, {date: {$lte: ?2 } } , { $or: [ {'title':  { $regex:  ?0, $options : 'i'}},{'body':  { $regex:  ?0, $options : 'i'}}, {'comments.text':  { $regex:  ?0, $options : 'i'}}]  } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

}