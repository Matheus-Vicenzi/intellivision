package com.senai.intellivision.domain.event;

import com.senai.intellivision.domain.client.Client;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("event")
@Data
public class Event {
    @Id
    private String id;
    private Client client;
    private String base64ScreenImage;
    private String base64WebcamImage;
    private LocalDateTime eventDateTime;
}
