package com.senai.intellivision.service.event;

import com.senai.intellivision.domain.event.Event;
import com.senai.intellivision.infra.db.event.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    final EventRepository eventRepository;

    EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event save(Event eventInputDTO) {
        return eventRepository.save(eventInputDTO);
    }

    public Page<Event> findAllByPage(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    public Event getEventById(String id) {
        return eventRepository.findById(id).orElseThrow();
    }
}
