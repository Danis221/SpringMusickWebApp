package ru.itis.mv.service;

import ru.itis.mv.dto.ForumDto;
import ru.itis.mv.dto.ForumPage;
import ru.itis.mv.dto.NewForumDto;

public interface ForumService {
    ForumDto create(NewForumDto forum);

    ForumPage getAllForums(int page);
}
