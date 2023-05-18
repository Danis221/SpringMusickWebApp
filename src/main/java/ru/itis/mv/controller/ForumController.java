package ru.itis.mv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.mv.dto.*;
import ru.itis.mv.service.ForumService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("api")
@RestController
public class ForumController {

    private final ForumService forumService;

    @GetMapping("/forums")
    public ResponseEntity<ForumPage> getForums(@RequestParam(name = "page", defaultValue = "0")
                                                      Integer page) {
        return ResponseEntity
                .ok(forumService.getAllForums(page));
    }

    @PostMapping("/create/forum")
    public ResponseEntity<ForumDto> create(@RequestBody @Valid NewForumDto newForum) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(forumService.create(newForum));
    }
}
