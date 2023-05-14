package ru.itis.mv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.mv.aspect.Loggable;
import ru.itis.mv.dto.EventDto;
import ru.itis.mv.dto.EventPage;
import ru.itis.mv.dto.NewEventDto;
import ru.itis.mv.service.EventService;

import java.time.LocalDate;


@RequiredArgsConstructor
@RequestMapping("api")
@RestController
public class EventController {
    private final EventService eventService;

    @GetMapping("events")
    public ResponseEntity<EventPage> getAllBySettings(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam(name = "price", required = false) Integer price,
            @RequestParam(name = "page", defaultValue = "0") Integer page) {

        return ResponseEntity
                .ok(eventService.getAllBySettings(startDate, endDate, price, page));
    }

    @PostMapping("create/event")
    public ResponseEntity<EventDto> create(@RequestBody NewEventDto newEvent) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(eventService.create(newEvent));
    }
}
