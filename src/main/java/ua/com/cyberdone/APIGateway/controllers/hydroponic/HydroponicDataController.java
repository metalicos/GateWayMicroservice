package ua.com.cyberdone.APIGateway.controllers.hydroponic;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cyberdone.APIGateway.feign.DeviceMicroserviceClient;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicDataDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hydroponic/data")
@Tag(name = "Hydroponic Data API", description = "Інтерфейс для CRUD операцій із даними сенсорів гідропоніки")
public class HydroponicDataController {
    private final DeviceMicroserviceClient deviceMicroserviceClient;

    @GetMapping("/last")
    @Operation(summary = "Отримати дані гідропоніки",
            description = "Витягує з БД останні дані пристрою із можливістю пагінації")
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
    public ResponseEntity<List<HydroponicDataDto>> getLastDataInDeviceWithUUID(
            @Parameter(description = "Унікальний ідентифікатор пристрою") @RequestParam String uuid,
            @Parameter(description = "Номер сторінки") @RequestParam Integer page,
            @Parameter(description = "Кількість елементів на сторінці")  @RequestParam Integer limit) {
        return deviceMicroserviceClient.getLastDataInDeviceWithUUID(uuid, page, limit);
    }

    @DeleteMapping
    @Operation(summary = "Видалити дані гідропоніки")
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
    public ResponseEntity<Void> deleteAllDataInDeviceWithUUID(@Parameter(description = "Ідентифікатор елементу для видаленння") @RequestParam Long id) {
        deviceMicroserviceClient.deleteAllDataInDeviceWithUUID(id);
        return ResponseEntity.ok().build();
    }
}