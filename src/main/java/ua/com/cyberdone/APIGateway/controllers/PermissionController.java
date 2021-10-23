package ua.com.cyberdone.APIGateway.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    ResponseEntity<Object> readPermissions(@RequestHeader("Authorization") String token,
                                           @RequestParam(value = "name", required = false) String name) {
        return accountMicroserviceClient.readPermissions(token, name);
    }

    @DeleteMapping
    @Operation(summary = "Видалити дозволи / один дозвіл (якщо передати його назву в параметрах)")
    ResponseEntity<String> deletePermissions(@RequestHeader("Authorization") String token,
                                             @RequestParam(value = "name", required = false) String name) {
        return accountMicroserviceClient.deletePermissions(token, name);
    }

    @PostMapping
    @Operation(summary = "Створити дозвіл")
    ResponseEntity<PermissionDto> createPermission(@RequestBody CreatePermissionDto dto) {
        return createPermission(dto);
    }

    @GetMapping("/page/{page}/size/{size}/sort-by/{sort-by}/direction/{direction}")
    @Operation(summary = "Отримати дозволи із пагінацією")
    ResponseEntity<PermissionsDto> readPermissions(@RequestHeader("Authorization") String token,
                                                   @PathVariable("page") Integer page,
                                                   @PathVariable("size") Integer size,
                                                   @PathVariable("sort-by") String sortBy,
                                                   @PathVariable("direction") String direction) {
        return accountMicroserviceClient.readPermissions(token, page, size, sortBy, direction);
    }
}
