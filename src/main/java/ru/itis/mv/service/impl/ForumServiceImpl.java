package ru.itis.mv.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.itis.mv.aspect.Loggable;
import ru.itis.mv.dto.ForumDto;
import ru.itis.mv.dto.ForumPage;
import ru.itis.mv.dto.NewForumDto;
import ru.itis.mv.model.Forum;
import ru.itis.mv.model.User;
import ru.itis.mv.repository.ForumRepository;
import ru.itis.mv.repository.UserRepository;
import ru.itis.mv.service.ForumService;
import ru.itis.mv.service.UserService;

import java.time.LocalDate;

import static ru.itis.mv.dto.ForumDto.fromEntity;

@RequiredArgsConstructor
@Service
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;
    private final UserService userService;

    private final int defaultPageSize = 4;

    @Loggable
    @Override
    public ForumDto create(NewForumDto forum) {
        Forum newForum = Forum.builder()
                .author(userService.getCurrentUser())
                .forumHeader(forum.getForumHeader())
                .created(LocalDate.now())
                .build();

        forumRepository.save(newForum);

        return  fromEntity(newForum);
    }

    @Loggable
    @Override
    public ForumPage getAllForums(int page) {
        PageRequest pageRequest = PageRequest.of(page, defaultPageSize);
        Page<Forum> forumPage = forumRepository.findAll(pageRequest);

        return ForumPage.builder()
                .forums(fromEntity(forumPage.getContent()))
                .totalPagesCount(forumPage.getTotalPages())
                .build();
    }
}
