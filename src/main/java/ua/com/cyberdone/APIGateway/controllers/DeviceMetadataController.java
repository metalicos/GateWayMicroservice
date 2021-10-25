package ua.com.cyberdone.APIGateway.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cyberdone.APIGateway.feign.DeviceMicroserviceClient;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.DeviceMetadataDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.DeviceType;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/device/metadata")
@Tag(name = "Device Metadata API", description = "Інтерфейс для створення та зміни метаданих пристроїв")
public class DeviceMetadataController {
    private final DeviceMicroserviceClient deviceMicroserviceClient;

    @GetMapping
    @Operation(summary = "Отримати метадані пристрою")
    public ResponseEntity<DeviceMetadataDto> getMetadataByUuid(@RequestHeader("Authorization") String token,
                                                               @RequestParam String uuid) {
        return deviceMicroserviceClient.getMetadataByUuid(token, uuid);
    }

    @PostMapping
    @Operation(summary = "Створити метадані для пристрою")
    public ResponseEntity<String> updateMetadata(@RequestHeader("Authorization") String token,
                                                 @RequestParam String uuid, @RequestParam String name,
                                                 @RequestParam String description) {
        return deviceMicroserviceClient.updateMetadata(token, uuid, name, description);
    }

    @DeleteMapping
    @Operation(summary = "Видалити метадані пристрою")
    public ResponseEntity<String> deleteMetadata(@RequestHeader("Authorization") String token,
                                                 @RequestParam String uuid) {
        return deviceMicroserviceClient.deleteMetadata(token, uuid);
    }

    @GetMapping("/types")
    ResponseEntity<DeviceType[]> getDeviceTypesList(@RequestHeader("Authorization") String token) {
        return deviceMicroserviceClient.getDeviceTypesList(token);
    }

    @PutMapping("/unlink")
    ResponseEntity<String> unlinkDevice(@RequestHeader("Authorization") String token,
                                        @RequestParam String uuid) {
        return deviceMicroserviceClient.unlinkDevice(token, uuid);
    }

    @PutMapping("/link")
    ResponseEntity<String> linkDevice(@RequestHeader("Authorization") String token,
                                      @RequestParam String uuid, @RequestParam Long userId) {
        return deviceMicroserviceClient.linkDevice(token, uuid, userId);
    }
}
