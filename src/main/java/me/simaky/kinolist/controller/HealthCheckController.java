package me.simaky.kinolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping("/health")
    public String healthCheck() {
        return "ok";
    }

    @GetMapping("/hh")
    public String healthCheck2() {
        return "hh";
    }
}
