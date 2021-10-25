package ua.com.cyberdone.APIGateway.controllers.hydroponic;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cyberdone.APIGateway.feign.DeviceMicroserviceClient;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicSettingsDto;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/hydroponic/settings")
@Tag(name = "Hydroponic Settings API", description = "Інтерфейс для CRUD операцій із налаштуваннями гідропоніки")
public class HydroponicSettingsController {
    private final DeviceMicroserviceClient deviceMicroserviceClient;

    @GetMapping("/last")
    @Operation(summary = "Отримати останні налаштування гідропоніки (з пагінацією)")
    public ResponseEntity<List<HydroponicSettingsDto>> getLastSettingsInDeviceWithUUID(
            @RequestHeader("Authorization") String token,
            @RequestParam String uuid,
            @RequestParam Integer page,
            @RequestParam Integer limit) {
        return deviceMicroserviceClient.getLastSettingsInDeviceWithUUID(token, uuid, page, limit);
    }
}
