package ru.itis.mv.service;

import ru.itis.mv.dto.NewPostDto;
import ru.itis.mv.dto.PostDto;
import ru.itis.mv.dto.PostPage;

public interface PostService {
    PostDto create(NewPostDto newPost);

    PostPage getaAllPostsByForumId(int page, int forumId);
}
