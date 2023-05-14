package ru.itis.mv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.mv.model.Event;
import ru.itis.mv.model.User;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewEventDto {

    private  String performer;

    private LocalDate concertDate;

    private Integer price;

    private String venue;

    private Set<String> organizersEmails;

    public static EventDto fromEntity(Event event) {
        Set<String> organizersEmails = event.getOrganizers()
                .stream()
                .map(User::getEmail)
                .collect(Collectors.toSet());

        return EventDto.builder()
                .concertDate(event.getConcertDate())
                .performer(event.getPerformer())
                .price(event.getPrice())
                .venue(event.getVenue())
                .organizersEmails(organizersEmails)
                .build();
    }
}
