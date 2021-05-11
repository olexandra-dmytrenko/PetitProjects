package ua.kpi.tef.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
/**
 * Run http://localhost:8080/actuator/health to see all health by springboot means
 */
public class HealthController {

    @GetMapping()
    public ResponseEntity<String> checkServerWorks() {
        return ResponseEntity.ok().build();
    }

}
