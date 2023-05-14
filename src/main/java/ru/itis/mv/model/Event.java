package ru.itis.mv.model;

import lombok.*;
import org.apache.commons.lang3.builder.HashCodeExclude;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "organizers")
@EqualsAndHashCode(exclude = "organizers")
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String performer;

    @Column(nullable = false)
    private LocalDate concertDate;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String venue;

    @ManyToMany
    @JoinTable(
            name = "organizer_event",
            joinColumns = @JoinColumn(name = "event_id",  referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<User> organizers;
}
