package dev.notyouraverage.spring_security.services;

import dev.notyouraverage.spring_security.models.h2.Post;
import java.util.List;

public interface PostService {

    List<Post> getAllPosts();
}
