package ua.com.cyberdone.APIGateway.controllers.hydroponic;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
    @Operation(summary = "Отримати дані гідропоніки")
    public ResponseEntity<List<HydroponicDataDto>> getLastDataInDeviceWithUUID(
            @RequestHeader("Authorization") String token,
            @RequestParam String uuid,
            @RequestParam Integer page,
            @RequestParam Integer limit) {
        return deviceMicroserviceClient.getLastDataInDeviceWithUUID(token, uuid, page, limit);
    }

    @DeleteMapping
    @Operation(summary = "Видалити дані гідропоніки")
    public ResponseEntity<Void> deleteAllDataInDeviceWithUUID(@RequestHeader("Authorization") String token,
                                                              @RequestParam Long id) {
        deviceMicroserviceClient.deleteAllDataInDeviceWithUUID(token, id);
        return ResponseEntity.ok().build();
    }
}
