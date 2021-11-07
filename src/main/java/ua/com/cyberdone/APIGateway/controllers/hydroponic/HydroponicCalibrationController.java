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
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicCalibrationDataDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hydroponic/calibration-data")
@Tag(name = "Hydroponic Calibration API", description = "Інтерфейс для CRUD операцій із даними калібрування сенсорів гідропоніки")
public class HydroponicCalibrationController {
    private final DeviceMicroserviceClient deviceMicroserviceClient;

    @GetMapping("/last")
    @Operation(summary = "Отримати останні дані калібрування гідропоніки (з пагінацією)")
    public ResponseEntity<List<HydroponicCalibrationDataDto>> getLastCalibrationDataInDeviceWithUUID(
            @RequestHeader("Authorization") String token,
            @RequestParam String uuid,
            @RequestParam Integer page,
            @RequestParam Integer limit) {
        return deviceMicroserviceClient.getLastCalibrationDataInDeviceWithUUID(token, uuid, page, limit);
    }

    @DeleteMapping
    @Operation(summary = "Видалити дані калібрування гідропоніки за ідентифікатором")
    public ResponseEntity<Void> deleteCalibrationDataInDeviceWithUUID(@RequestHeader("Authorization") String token,
                                                                      @RequestParam Long id) {
        deviceMicroserviceClient.deleteCalibrationDataInDeviceWithId(token, id);
        return ResponseEntity.ok().build();
    }
}
