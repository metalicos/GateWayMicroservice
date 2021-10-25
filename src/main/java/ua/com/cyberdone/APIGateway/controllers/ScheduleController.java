package ua.com.cyberdone.APIGateway.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cyberdone.APIGateway.feign.DeviceMicroserviceClient;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.RegularScheduleDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.RegularScheduleUpdateDto;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
@Tag(name = "Schedule API", description = "Інтерфейс для створення та зміни регулярних подій")
public class ScheduleController {
    private final DeviceMicroserviceClient deviceMicroserviceClient;

    @GetMapping("/{key}")
    @Operation(summary = "Отримати регулярні події за ключем")
    public ResponseEntity<List<RegularScheduleDto>> getSchedulesByKey(@RequestHeader("Authorization") String token,
                                                                      @RequestParam String uuid,
                                                                      @PathVariable String key) {
        return deviceMicroserviceClient.getSchedulesByKey(token, uuid, key);
    }

    @PostMapping
    @Operation(summary = "Створити регулярну подію")
    public ResponseEntity<String> createSchedule(@RequestHeader("Authorization") String token,
                                                 @RequestBody RegularScheduleDto schedule) {
        return deviceMicroserviceClient.createSchedule(token, schedule);
    }

    @PatchMapping
    @Operation(summary = "Оновити метадані регулярної події")

    public ResponseEntity<String> updateScheduleMetaInfo(@RequestHeader("Authorization") String token,
                                                         @RequestBody RegularScheduleUpdateDto schedule) {
        return deviceMicroserviceClient.updateScheduleMetaInfo(token, schedule);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Видалити регулярну подію за її ідентифікатором")

    public ResponseEntity<String> deleteScheduleById(@RequestHeader("Authorization") String token,
                                                     @PathVariable Long id) {
        return deviceMicroserviceClient.deleteScheduleById(token, id);
    }
}
