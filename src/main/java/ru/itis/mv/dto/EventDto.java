package ru.itis.mv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.mv.model.Article;
import ru.itis.mv.model.Event;
import ru.itis.mv.model.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDto {

    private  String performer;

    private LocalDate concertDate;

    private Integer price;

    private String venue;

    private Set<String> organizersEmails;

    public static EventDto fromEntity(Event event) {
        Set<String> organizerEmails = event.getOrganizers()
                .stream()
                .map(User::getEmail)
                .collect(Collectors.toSet());

        return EventDto.builder()
                .concertDate(event.getConcertDate())
                .performer(event.getPerformer())
                .price(event.getPrice())
                .venue(event.getVenue())
                .organizersEmails(organizerEmails)
                .build();
    }

    public static List<EventDto> fromEntity(List<Event> events) {
        return events.stream()
                .map(EventDto::fromEntity)
                .collect(Collectors.toList());
    }
}
