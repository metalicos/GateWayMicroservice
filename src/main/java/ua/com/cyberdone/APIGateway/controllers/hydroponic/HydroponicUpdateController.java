package ua.com.cyberdone.APIGateway.controllers.hydroponic;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cyberdone.APIGateway.feign.DeviceMicroserviceClient;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicTimeDto;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/update/hydroponic")
@Tag(name = "Hydroponic Update API", description = "Інтерфейс для керуванням налаштувань та перефирії гідропоніки")
public class HydroponicUpdateController {
    private final DeviceMicroserviceClient deviceMicroserviceClient;

    @PostMapping("/time")
    @Operation(summary = "Оновити час на пристрої гідропоніки")
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
    public ResponseEntity<String> updateTime(@RequestBody HydroponicTimeDto dto) {
        deviceMicroserviceClient.updateTime(dto);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/zone")
    @Operation(summary = "Оновити часову зону на пристрої гідропоніки")
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
    public ResponseEntity<String> updateZone(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updateZone(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/autotime")
    @Operation(summary = "Оновити автосинхронізацію часу із сервером на пристрої гідропоніки")
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
    public ResponseEntity<String> updateAutoTime(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updateTime(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/pumps/phUp/{direction}")
    @Operation(summary = "Керувати насосом PH UP у пристрої гідропоніки")
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
    public ResponseEntity<String> updatePhUpPumpStatus(@RequestParam String uuid, @PathVariable String direction) {
        deviceMicroserviceClient.updatePhUpPumpStatus(uuid, direction);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/pumps/phDown/{direction}")
    @Operation(summary = "Керувати насосом PH DOWN у пристрої гідропоніки")
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
    public ResponseEntity<String> updatePhDownPumpStatus(@RequestParam String uuid, @PathVariable String direction) {
        deviceMicroserviceClient.updatePhDownPumpStatus(uuid, direction);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/pumps/tds/{direction}")
    @Operation(summary = "Керувати насосом TDS у пристрої гідропоніки")
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
    public ResponseEntity<String> updateTdsPumpStatus(@RequestParam String uuid, @PathVariable String direction) {
        deviceMicroserviceClient.updateTdsPumpStatus(uuid, direction);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/restart")
    @Operation(summary = "Перевантажити пристрій гідропоніки")
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
    public ResponseEntity<String> restart(@RequestParam String uuid) {
        deviceMicroserviceClient.restart(uuid);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/save")
    @Operation(summary = "Зберегти усі налаштування з оперативної пам'яті у флеш пам'ять гідропоніки")
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
    public ResponseEntity<String> saveAllSettings(@RequestParam String uuid) {
        deviceMicroserviceClient.saveAllSettings(uuid);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/read")
    @Operation(summary = "Вичитати налаштування із флеш пам'яті в оперативну пам'ять гідропоніки")
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
    public ResponseEntity<String> readAllSettings(@RequestParam String uuid) {
        deviceMicroserviceClient.readAllSettings(uuid);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/calibrate/tds")
    @Operation(summary = "Калібрувати TDS сенсор гідропоніки")
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
    public ResponseEntity<String> calibrateTdsSensor(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.calibrateTdsSensor(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/calibrate/tds/clear")
    @Operation(summary = "Очистити калібрування TDS сенсора гідропоніки")
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
    public ResponseEntity<String> clrCalibrationTdsSensor(@RequestParam String uuid) {
        deviceMicroserviceClient.clrCalibrationTdsSensor(uuid);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/calibrate/ph/low")
    @Operation(summary = "Калібрувати PH сенсор гідропоніки по нижній межі")
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
    public ResponseEntity<String> calibratePhLow(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.calibratePhLow(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/calibrate/ph/high")
    @Operation(summary = "Калібрувати PH сенсор гідропоніки по верхній межі")
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
    public ResponseEntity<String> calibratePhHigh(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.calibratePhHigh(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/calibrate/ph/clear")
    @Operation(summary = "Очистити калібрування PH сенсора гідропоніки")
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
    public ResponseEntity<String> clrCalibrationPhSensor(@RequestParam String uuid) {
        deviceMicroserviceClient.clrCalibrationPhSensor(uuid);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/setup/ph")
    @Operation(summary = "Оновити значення регулювання PH")
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
    public ResponseEntity<String> updateSetupPhValue(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updateSetupPhValue(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/setup/tds")
    @Operation(summary = "Оновити значення регулювання TDS")
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
    public ResponseEntity<String> updateSetupTdsValue(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updateSetupTdsValue(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/dispensers/recheck-time")
    @Operation(summary = "Оновити значення часу повторного регулювання")
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
    public ResponseEntity<String> updateRecheckDispensersAfterTime(@RequestParam String uuid,
                                                                   @RequestParam String value) {
        deviceMicroserviceClient.updateRecheckDispensersAfterTime(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/dose/ph/up")
    @Operation(summary = "Оновити дозу регулювання PH UP насосом")
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
    public ResponseEntity<String> updatePhUpDose(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updatePhUpDose(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/dose/ph/down")
    @Operation(summary = "Оновити дозу регулювання PH DOWN насосом")
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
    public ResponseEntity<String> updatePhDownDose(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updatePhDownDose(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/dose/tds")
    @Operation(summary = "Оновити дозу регулювання TDS насосом")
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
    public ResponseEntity<String> updateFertilizerDose(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updateFertilizerDose(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/regulator/error/ph")
    @Operation(summary = "Оновити коридор похибки регулювання PH (значення в діапазоні коридору вважається досягнутим)")
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
    public ResponseEntity<String> updateRegulatePhError(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updateRegulatePhError(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/regulator/error/tds")
    @Operation(summary = "Оновити коридор похибки регулювання TDS (значення в діапазоні коридору вважається досягнутим)")
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
    public ResponseEntity<String> updateRegulateTdsError(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updateRegulateTdsError(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/pump/speed")
    @Operation(summary = "Оновити швидкість подачі рідини насосами)")
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
    public ResponseEntity<String> updatePumpSpeed(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updatePumpSpeed(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/wifi/ssid")
    @Operation(summary = "Оновити назву точки доступу")
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
    public ResponseEntity<String> updateWifiSsid(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updateWifiSsid(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/wifi/pass")
    @Operation(summary = "Оновити пароль точки доступу")
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
    public ResponseEntity<String> updateWifiPassword(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updateWifiPassword(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/enable/sensors")
    @Operation(summary = "Дозволити зчитування даних та роботу сенсорів")
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
    public ResponseEntity<String> updateSensorsEnable(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updateSensorsEnable(uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/enable/dispensers")
    @Operation(summary = "Дозволити регулювання насосів")
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
    public ResponseEntity<String> updateDispensersEnable(@RequestParam String uuid, @RequestParam String value) {
        deviceMicroserviceClient.updateDispensersEnable(uuid, value);
        return ResponseEntity.ok("OK");
    }
}
