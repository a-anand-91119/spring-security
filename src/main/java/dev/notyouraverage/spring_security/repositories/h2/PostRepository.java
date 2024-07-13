package dev.notyouraverage.spring_security.repositories.h2;

import dev.notyouraverage.spring_security.models.h2.Post;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ListCrudRepository<Post, Integer> {

}
