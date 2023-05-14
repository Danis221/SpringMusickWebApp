package ru.itis.mv.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.itis.mv.dto.NewPostDto;
import ru.itis.mv.dto.PostDto;
import ru.itis.mv.dto.PostPage;
import ru.itis.mv.model.Forum;
import ru.itis.mv.model.Post;
import ru.itis.mv.model.User;
import ru.itis.mv.repository.ForumRepository;
import ru.itis.mv.repository.PostRepository;
import ru.itis.mv.repository.UserRepository;
import ru.itis.mv.service.PostService;
import ru.itis.mv.service.UserService;

import java.util.Optional;

import static ru.itis.mv.dto.PostDto.fromEntity;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ForumRepository forumRepository;
    private final UserService userService;

    private final int defaultPageSize = 10;

    @Override

    public PostDto create(NewPostDto newPost) {
        Forum forum = forumRepository.findById(newPost.getForumId())
                .orElseThrow(() -> new NotFoundException("Forum with " + newPost.getForumId() + "id not found"));

        Post post = Post.builder()
                .content(newPost.getContent())
                .forum(forum)
                .author(userService.getCurrentUser())
                .build();

        postRepository.save(post);

        return fromEntity(post);
    }

    @Override
    public PostPage getaAllPostsByForumId(int page, int forumId) {
        PageRequest pageRequest = PageRequest.of(page, defaultPageSize);
        Page<Post> postPage = postRepository.findAllByForumId(pageRequest, forumId);
        return PostPage.builder()
                .posts(fromEntity(postPage.getContent()))
                .totalPagesCount(postPage.getTotalPages())
                .build();
    }
}
