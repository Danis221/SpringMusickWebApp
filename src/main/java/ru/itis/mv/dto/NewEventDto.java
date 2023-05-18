package ru.itis.mv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.mv.model.Event;
import ru.itis.mv.model.User;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewEventDto {
    @NotEmpty(message = "the performer must not be empty")
    private  String performer;

    @FutureOrPresent(message = "the date cannot be in the past")
    private LocalDate concertDate;

    @PositiveOrZero(message = "price cannot be less than zero")
    private Integer price;

    @NotEmpty(message = "the venue must not be empty")
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
