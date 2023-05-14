package ru.itis.mv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.mv.model.Forum;

public interface ForumRepository extends JpaRepository<Forum, Integer> {
}
