package ru.itis.mv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import ru.itis.mv.dto.NewPostDto;
import ru.itis.mv.dto.PostDto;
import ru.itis.mv.dto.PostPage;
import ru.itis.mv.service.PostService;

import static ru.itis.mv.dto.PostDto.fromEntity;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create/post")
    public PostDto createPost(@RequestBody NewPostDto newPost) {
       return postService.create(newPost);
    }

    @GetMapping("forums/{id}/discussion")
    public PostPage getPosts(@PathVariable("id") int id, @RequestParam(value = "page", defaultValue = "0") int page) {
        return postService.getaAllPostsByForumId(page, id);
    }
}
