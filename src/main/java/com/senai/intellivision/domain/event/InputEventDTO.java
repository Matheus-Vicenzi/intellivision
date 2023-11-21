package com.senai.intellivision.domain.event;

public record InputEventDTO(String macAddress,
                            String clientUsername,
                            String clientDescription,
                            String base64ScreenImage,
                            String base64WebcamImage,
                            String orgToken) {
}
