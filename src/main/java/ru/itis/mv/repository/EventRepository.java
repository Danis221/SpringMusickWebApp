package ru.itis.mv.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itis.mv.model.Event;

import java.time.LocalDate;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {


    @Query("SELECT e FROM Event e WHERE (:startDate IS NULL OR e.concertDate >= :startDate) "
            + "AND (:endDate IS NULL OR e.concertDate <= :endDate) "
            + "AND (:price IS NULL OR e.price <= :price) "
            + "ORDER BY e.concertDate")
    Page<Event> getAllBySettings(LocalDate startDate, LocalDate endDate, Integer price, Pageable pageable);

    Page<Event> findAll(Pageable pageable);
}
