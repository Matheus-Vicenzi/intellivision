package com.senai.intellivision.service.event;

import com.senai.intellivision.domain.event.Event;
import com.senai.intellivision.domain.event.EventFactory;
import com.senai.intellivision.domain.event.InputEventDTO;
import com.senai.intellivision.infra.exception.InvalidTokenException;
import com.senai.intellivision.infra.repositories.event.EventRepository;
import com.senai.intellivision.infra.repositories.organization.OrganizationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EventService {
    final EventRepository eventRepository;
    final OrganizationRepository organizationRepository;

    EventService(EventRepository eventRepository, OrganizationRepository organizationRepository) {
        this.eventRepository = eventRepository;
        this.organizationRepository = organizationRepository;
    }

    public Event save(InputEventDTO eventInputDTO) {
        validateEvent(eventInputDTO);
        Event event = EventFactory.dtoToEntity(eventInputDTO);
        return eventRepository.save(event);
    }

    private void validateEvent(InputEventDTO eventInputDTO) {
        var organization = organizationRepository.findByOrgToken(eventInputDTO.orgToken());
        if (organization.isEmpty()) {
            log.error("Invalid token ("+eventInputDTO.orgToken()+")");
            throw new InvalidTokenException();
        }
        if (!organization.get().getMacAddressList().contains(eventInputDTO.macAddress())) {
            log.error("Invalid mac address ("+eventInputDTO.macAddress()+") for token ("+eventInputDTO.orgToken()+")");
            throw new InvalidTokenException();
        }
    }

    public Page<Event> findAllByPage(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    public Event getEventById(String id) {
        return eventRepository.findById(id).orElseThrow();
    }
}
