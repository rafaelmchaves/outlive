package com.outlive.restaurant.controller;

import com.outlive.restaurant.controller.dto.ProfitResponse;
import com.outlive.restaurant.service.ProfitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@RestController
public class ProfitController {

    private final ProfitService profitService;

    @GetMapping("/profit")
    public ResponseEntity<ProfitResponse> calculateProfit(@RequestParam String startDate, @RequestParam String endDate) {
        final var startDateTime = LocalDateTime.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        final var endDateTime = LocalDateTime.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        final var profitResponse = profitService.getBetweenDates(startDateTime, endDateTime);

        return ResponseEntity.ok(profitResponse);
    }
}
