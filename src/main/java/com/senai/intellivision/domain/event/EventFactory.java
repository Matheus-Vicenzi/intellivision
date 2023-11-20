package com.senai.intellivision.domain.event;

import com.senai.intellivision.domain.client.Client;

import java.time.LocalDateTime;

public class EventFactory {
    public static Event dtoToEntity(InputEventDTO eventInputDTO) {
        Event event = new Event();

        event.setClient(new Client(eventInputDTO.macAddress(),
                eventInputDTO.clientUsername(),
                eventInputDTO.orgToken(),
                eventInputDTO.clientDescription()));

        event.setBase64ScreenImage(eventInputDTO.base64ScreenImage());
        event.setBase64WebcamImage(eventInputDTO.base64WebcamImage());
        event.setEventDateTime(LocalDateTime.now());
        return event;
    }
}
