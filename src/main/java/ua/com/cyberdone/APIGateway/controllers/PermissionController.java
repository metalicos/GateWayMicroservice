package ua.com.cyberdone.APIGateway.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cyberdone.APIGateway.feign.AccountMicroserviceClient;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.permission.CreatePermissionDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.permission.PermissionDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.permission.PermissionsDto;

@RestController
@AllArgsConstructor
@RequestMapping("/permissions")
@Tag(name = "Permission API", description = "Інтерфейс для створення та зміни дозволів")
public class PermissionController {
    private final AccountMicroserviceClient accountMicroserviceClient;

    @GetMapping
    @Operation(summary = "Отримати дозволи / один дозвіл (якщо передати його назву в параметрах)")
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
    ResponseEntity<Object> readPermissions(@RequestParam(value = "name", required = false) String name) {
        return accountMicroserviceClient.readPermissions(name);
    }

    @DeleteMapping
    @Operation(summary = "Видалити дозволи / один дозвіл (якщо передати його назву в параметрах)")
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
    ResponseEntity<String> deletePermissions(@RequestParam(value = "name", required = false) String name) {
        return accountMicroserviceClient.deletePermissions(name);
    }

    @PostMapping
    @Operation(summary = "Створити дозвіл")
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
    ResponseEntity<PermissionDto> createPermission(@RequestBody CreatePermissionDto dto) {
        return createPermission(dto);
    }

    @GetMapping("/page/{page}/size/{size}/sort-by/{sort-by}/direction/{direction}")
    @Operation(summary = "Отримати дозволи із пагінацією")
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
    ResponseEntity<PermissionsDto> readPermissions(
            @PathVariable("page") Integer page, @PathVariable("size") Integer size,
            @PathVariable("sort-by") String sortBy, @PathVariable("direction") String direction) {
        return accountMicroserviceClient.readPermissions(page, size, sortBy, direction);
    }
}
