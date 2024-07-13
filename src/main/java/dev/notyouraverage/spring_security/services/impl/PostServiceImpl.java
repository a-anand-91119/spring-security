package dev.notyouraverage.spring_security.services.impl;

import dev.notyouraverage.spring_security.models.h2.Post;
import dev.notyouraverage.spring_security.repositories.h2.PostRepository;
import dev.notyouraverage.spring_security.services.PostService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
