package ua.com.cyberdone.APIGateway.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(examples = @ExampleObject("OK")),
                    description = "Правильно оброблені дані та повернений результат"),
            @ApiResponse(responseCode = "400", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 400,\"error\": \"Bad Request\",\"path\": \"invalid parameter 'uuid'\"}")),
                    description = "Помилка у формуванні запиту до сервера"),
            @ApiResponse(responseCode = "401", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 401,\"error\": \"Unauthorized\",\"path\": \"Token is invalid\"}")),
                    description = "Користувач не залогінився або час життя його текену вийшов"),
            @ApiResponse(responseCode = "403", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 403,\"error\": \"Forbidden\",\"path\": \"You have no permission to access this resource\"}")),
                    description = "Користувач залогінився, але прав для доступу до ресурсу не має"),
            @ApiResponse(responseCode = "404", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 404,\"error\": \"Not Found\",\"path\": \"/hydroponic/daata/last\"}")),
                    description = "Даних або заданого шляху не знайдено"),
            @ApiResponse(responseCode = "500", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 500,\"error\": \"Internal Server Error\",\"path\": \"Something went wrong\"}")),
                    description = "Запит до сервера правильний, однак сервер не зміг його опрацювати")
    })
    public ResponseEntity<List<RegularScheduleDto>> getSchedulesByKey(@RequestParam String uuid,
                                                                      @PathVariable String key) {
        return deviceMicroserviceClient.getSchedulesByKey(uuid, key);
    }

    @PostMapping
    @Operation(summary = "Створити регулярну подію")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(examples = @ExampleObject("OK")),
                    description = "Правильно оброблені дані та повернений результат"),
            @ApiResponse(responseCode = "400", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 400,\"error\": \"Bad Request\",\"path\": \"invalid parameter 'uuid'\"}")),
                    description = "Помилка у формуванні запиту до сервера"),
            @ApiResponse(responseCode = "401", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 401,\"error\": \"Unauthorized\",\"path\": \"Token is invalid\"}")),
                    description = "Користувач не залогінився або час життя його текену вийшов"),
            @ApiResponse(responseCode = "403", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 403,\"error\": \"Forbidden\",\"path\": \"You have no permission to access this resource\"}")),
                    description = "Користувач залогінився, але прав для доступу до ресурсу не має"),
            @ApiResponse(responseCode = "404", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 404,\"error\": \"Not Found\",\"path\": \"/hydroponic/daata/last\"}")),
                    description = "Даних або заданого шляху не знайдено"),
            @ApiResponse(responseCode = "500", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 500,\"error\": \"Internal Server Error\",\"path\": \"Something went wrong\"}")),
                    description = "Запит до сервера правильний, однак сервер не зміг його опрацювати")
    })
    public ResponseEntity<String> createSchedule(@RequestBody RegularScheduleDto schedule) {
        return deviceMicroserviceClient.createSchedule(schedule);
    }

    @PatchMapping
    @Operation(summary = "Оновити метадані регулярної події")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(examples = @ExampleObject("OK")),
                    description = "Правильно оброблені дані та повернений результат"),
            @ApiResponse(responseCode = "400", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 400,\"error\": \"Bad Request\",\"path\": \"invalid parameter 'uuid'\"}")),
                    description = "Помилка у формуванні запиту до сервера"),
            @ApiResponse(responseCode = "401", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 401,\"error\": \"Unauthorized\",\"path\": \"Token is invalid\"}")),
                    description = "Користувач не залогінився або час життя його текену вийшов"),
            @ApiResponse(responseCode = "403", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 403,\"error\": \"Forbidden\",\"path\": \"You have no permission to access this resource\"}")),
                    description = "Користувач залогінився, але прав для доступу до ресурсу не має"),
            @ApiResponse(responseCode = "404", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 404,\"error\": \"Not Found\",\"path\": \"/hydroponic/daata/last\"}")),
                    description = "Даних або заданого шляху не знайдено"),
            @ApiResponse(responseCode = "500", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 500,\"error\": \"Internal Server Error\",\"path\": \"Something went wrong\"}")),
                    description = "Запит до сервера правильний, однак сервер не зміг його опрацювати")
    })
    public ResponseEntity<String> updateScheduleMetaInfo(@RequestBody RegularScheduleUpdateDto schedule) {
        return deviceMicroserviceClient.updateScheduleMetaInfo(schedule);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Видалити регулярну подію за її ідентифікатором")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(examples = @ExampleObject("OK")),
                    description = "Правильно оброблені дані та повернений результат"),
            @ApiResponse(responseCode = "400", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 400,\"error\": \"Bad Request\",\"path\": \"invalid parameter 'uuid'\"}")),
                    description = "Помилка у формуванні запиту до сервера"),
            @ApiResponse(responseCode = "401", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 401,\"error\": \"Unauthorized\",\"path\": \"Token is invalid\"}")),
                    description = "Користувач не залогінився або час життя його текену вийшов"),
            @ApiResponse(responseCode = "403", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 403,\"error\": \"Forbidden\",\"path\": \"You have no permission to access this resource\"}")),
                    description = "Користувач залогінився, але прав для доступу до ресурсу не має"),
            @ApiResponse(responseCode = "404", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 404,\"error\": \"Not Found\",\"path\": \"/hydroponic/daata/last\"}")),
                    description = "Даних або заданого шляху не знайдено"),
            @ApiResponse(responseCode = "500", content = @Content(examples = @ExampleObject("{\"timestamp\": 1634594211581,\"status\": 500,\"error\": \"Internal Server Error\",\"path\": \"Something went wrong\"}")),
                    description = "Запит до сервера правильний, однак сервер не зміг його опрацювати")
    })
    public ResponseEntity<String> deleteScheduleById(@PathVariable Long id) {
        return deviceMicroserviceClient.deleteScheduleById(id);
    }
}
