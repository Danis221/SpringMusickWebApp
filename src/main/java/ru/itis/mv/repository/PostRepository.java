package ru.itis.mv.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.mv.model.Forum;
import ru.itis.mv.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Page<Post> findAllByForumId(Pageable pageable , int id);
}
