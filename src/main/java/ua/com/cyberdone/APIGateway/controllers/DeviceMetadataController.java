package ua.com.cyberdone.APIGateway.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.cyberdone.APIGateway.feign.DeviceMicroserviceClient;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.DeviceMetadataDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.DeviceType;

import java.util.List;


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

    @GetMapping("/list")
    public ResponseEntity<List<DeviceMetadataDto>> getMetadataByUser(@RequestHeader("Authorization") String token,
                                                                     @RequestParam Long userId) {
        return deviceMicroserviceClient.getMetadataByUser(token, userId);
    }

    @PostMapping
    @Operation(summary = "Створити метадані для пристрою")
    ResponseEntity<String> createMetadata(@RequestHeader("Authorization") String token,
                                          @RequestBody DeviceMetadataDto metadataDto){
        return deviceMicroserviceClient.createMetadata(token, metadataDto);
    }

    @PatchMapping
    @Operation(summary = "Обновити метадані пристрою")
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
