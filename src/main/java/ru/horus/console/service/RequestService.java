package ru.horus.console.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.horus.console.controller.MenuController;
import ru.horus.console.model.Control;
import ru.horus.console.model.Mode;
import ru.horus.console.model.Request;

@Slf4j
@RequiredArgsConstructor
@Service
public class RequestService {
    private final MenuController menuController;
    private final RestTemplate restTemplate;

    @Value("orchestrator.url")
    private static String orchestratorUrl;

    public void sendRequestToOrchestrator(Request request) {
        validateRequest(request);
        log.info("To url {} was send {}", orchestratorUrl, request);
        restTemplate.postForLocation(orchestratorUrl, new HttpEntity<>(request));
    }

    private void validateRequest(Request request) {
        if (request.getMode() == Mode.MANUAL) {
            request.setControl(Control.IDLE);
            if (!request.getOffset().isValidForManual()) {
                menuController.getErrorPage("Bad offset value for manual mode");
            }
        }
    }
}
