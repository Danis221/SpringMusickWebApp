package ru.itis.mv.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.itis.mv.aspect.Loggable;
import ru.itis.mv.dto.EventDto;
import ru.itis.mv.dto.EventPage;
import ru.itis.mv.dto.NewEventDto;
import ru.itis.mv.model.Event;
import ru.itis.mv.model.User;
import ru.itis.mv.repository.EventRepository;
import ru.itis.mv.repository.UserRepository;
import ru.itis.mv.service.EventService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static ru.itis.mv.dto.EventDto.fromEntity;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    //    @Value("${default.page-size}")
    private final int defaultPageSize = 10;

    private final EventRepository eventRepository;

    private final UserRepository userRepository;

    @Loggable
    @Override
    public EventPage getAllEvents(int page) {
        PageRequest pageRequest = PageRequest.of(page, defaultPageSize);
        Page<Event> eventPage = eventRepository.findAll(pageRequest);

        return EventPage.builder()
                .events(fromEntity(eventPage.getContent()))
                .totalPagesCount(eventPage.getTotalPages())
                .build();
    }

    @Loggable
    @Override
    public EventDto create(NewEventDto event) {
        Set<User> organizers = userRepository.findAllByEmailIn(event.getOrganizersEmails());

        Event newEvent = Event.builder()
                .concertDate(event.getConcertDate())
                .venue(event.getVenue())
                .performer(event.getPerformer())
                .price(event.getPrice())
                .organizers(organizers)
                .build();


        eventRepository.save(newEvent);

        return  fromEntity(newEvent);
    }

    @Loggable
    @Override
    public EventDto getEvent(Integer id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found for id: " + id));

        return fromEntity(event);
    }

     @Loggable
    @Override
    public EventPage getAllBySettings(LocalDate startDate, LocalDate endDate, Integer price, Integer page) {
        PageRequest pageRequest = PageRequest.of(page, defaultPageSize);
        Page<Event> events = eventRepository.getAllBySettings(startDate, endDate, price, pageRequest);


        return EventPage.builder()
                .events(fromEntity(events.getContent()))
                .totalPagesCount(events.getTotalPages())
                .build();
    }
}
