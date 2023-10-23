package com.senai.intellivision.controller.event;

import com.senai.intellivision.domain.event.Event;
import com.senai.intellivision.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/event")
public class EventController {
    final EventService eventService;

    EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> save(@RequestBody Event event) {

        try {
            return new ResponseEntity<>(eventService.save(event), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Event>> getAll(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int sizePerPage,
                                             @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {

        Pageable pageRequest = PageRequest.of(page, sizePerPage, sortDirection, "event");
        return ResponseEntity.ok(eventService.findAllByPage(pageRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable String id) {

        try {
            return ResponseEntity.ok(eventService.getEventById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
