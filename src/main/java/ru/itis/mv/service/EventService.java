package ru.itis.mv.service;

import ru.itis.mv.dto.EventDto;
import ru.itis.mv.dto.EventPage;
import ru.itis.mv.dto.NewEventDto;
import ru.itis.mv.model.Event;

import java.time.LocalDate;

public interface EventService {
    EventPage getAllEvents(int page);

    EventDto create(NewEventDto event);

    EventDto getEvent(Integer id);

    EventPage getAllBySettings(LocalDate startDate, LocalDate endDate, Integer price, Integer page);
}
