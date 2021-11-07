package ua.com.cyberdone.APIGateway.controllers.hydroponic;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

    public ResponseEntity<String> updateTime(@RequestBody HydroponicTimeDto dto,
                                             @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateTime(token, dto);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/zone")
    @Operation(summary = "Оновити часову зону на пристрої гідропоніки")

    public ResponseEntity<String> updateZone(@RequestParam String uuid, @RequestParam String value,
                                             @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateZone(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/autotime")
    @Operation(summary = "Оновити автосинхронізацію часу із сервером на пристрої гідропоніки")

    public ResponseEntity<String> updateAutoTime(@RequestParam String uuid, @RequestParam String value,
                                                 @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateTime(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/pumps/phUp")
    @Operation(summary = "Керувати насосом PH UP у пристрої гідропоніки")

    public ResponseEntity<String> updatePhUpPumpStatus(@RequestParam String uuid, @RequestParam String value,
                                                       @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updatePhUpPumpStatus(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/pumps/phDown")
    @Operation(summary = "Керувати насосом PH DOWN у пристрої гідропоніки")

    public ResponseEntity<String> updatePhDownPumpStatus(@RequestParam String uuid, @RequestParam String value,
                                                         @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updatePhDownPumpStatus(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/pumps/tds")
    @Operation(summary = "Керувати насосом TDS у пристрої гідропоніки")

    public ResponseEntity<String> updateTdsPumpStatus(@RequestParam String uuid, @RequestParam String value,
                                                      @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateTdsPumpStatus(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/restart")
    @Operation(summary = "Перевантажити пристрій гідропоніки")

    public ResponseEntity<String> restart(@RequestParam String uuid, @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.restart(uuid, token);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/save")
    @Operation(summary = "Зберегти усі налаштування з оперативної пам'яті у флеш пам'ять гідропоніки")

    public ResponseEntity<String> saveAllSettings(@RequestParam String uuid,
                                                  @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.saveAllSettings(uuid, token);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/read")
    @Operation(summary = "Вичитати налаштування із флеш пам'яті в оперативну пам'ять гідропоніки")

    public ResponseEntity<String> readAllSettings(@RequestParam String uuid,
                                                  @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.readAllSettings(uuid, token);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/calibrate/tds")
    @Operation(summary = "Калібрувати TDS сенсор гідропоніки")

    public ResponseEntity<String> calibrateTdsSensor(@RequestParam String uuid, @RequestParam String value,
                                                     @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.calibrateTdsSensor(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/calibrate/tds/clear")
    @Operation(summary = "Очистити калібрування TDS сенсора гідропоніки")

    public ResponseEntity<String> clrCalibrationTdsSensor(@RequestParam String uuid,
                                                          @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.clrCalibrationTdsSensor(uuid, token);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/calibrate/ph/low")
    @Operation(summary = "Калібрувати PH сенсор гідропоніки по нижній межі")

    public ResponseEntity<String> calibratePhLow(@RequestParam String uuid, @RequestParam String value,
                                                 @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.calibratePhLow(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/calibrate/ph/high")
    @Operation(summary = "Калібрувати PH сенсор гідропоніки по верхній межі")

    public ResponseEntity<String> calibratePhHigh(@RequestParam String uuid, @RequestParam String value,
                                                  @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.calibratePhHigh(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/calibrate/ph/clear")
    @Operation(summary = "Очистити калібрування PH сенсора гідропоніки")

    public ResponseEntity<String> clrCalibrationPhSensor(@RequestParam String uuid,
                                                         @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.clrCalibrationPhSensor(uuid, token);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/setup/ph")
    @Operation(summary = "Оновити значення регулювання PH")

    public ResponseEntity<String> updateSetupPhValue(@RequestParam String uuid, @RequestParam String value,
                                                     @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateSetupPhValue(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/setup/tds")
    @Operation(summary = "Оновити значення регулювання TDS")

    public ResponseEntity<String> updateSetupTdsValue(@RequestParam String uuid, @RequestParam String value,
                                                      @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateSetupTdsValue(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/dispensers/recheck-time")
    @Operation(summary = "Оновити значення часу повторного регулювання")

    public ResponseEntity<String> updateRecheckDispensersAfterTime(@RequestParam String uuid,
                                                                   @RequestParam String value,
                                                                   @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateRecheckDispensersAfterTime(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/dose/ph/up")
    @Operation(summary = "Оновити дозу регулювання PH UP насосом")

    public ResponseEntity<String> updatePhUpDose(@RequestParam String uuid, @RequestParam String value,
                                                 @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updatePhUpDose(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/dose/ph/down")
    @Operation(summary = "Оновити дозу регулювання PH DOWN насосом")

    public ResponseEntity<String> updatePhDownDose(@RequestParam String uuid, @RequestParam String value,
                                                   @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updatePhDownDose(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/dose/tds")
    @Operation(summary = "Оновити дозу регулювання TDS насосом")

    public ResponseEntity<String> updateFertilizerDose(@RequestParam String uuid, @RequestParam String value,
                                                       @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateFertilizerDose(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/regulator/error/ph")
    @Operation(summary = "Оновити коридор похибки регулювання PH (значення в діапазоні коридору вважається досягнутим)")

    public ResponseEntity<String> updateRegulatePhError(@RequestParam String uuid, @RequestParam String value,
                                                        @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateRegulatePhError(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/regulator/error/tds")
    @Operation(summary = "Оновити коридор похибки регулювання TDS (значення в діапазоні коридору вважається досягнутим)")

    public ResponseEntity<String> updateRegulateTdsError(@RequestParam String uuid, @RequestParam String value,
                                                         @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateRegulateTdsError(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/pump/speed")
    @Operation(summary = "Оновити швидкість подачі рідини насосами)")

    public ResponseEntity<String> updatePumpSpeed(@RequestParam String uuid, @RequestParam String value,
                                                  @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updatePumpSpeed(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/wifi/ssid")
    @Operation(summary = "Оновити назву точки доступу")

    public ResponseEntity<String> updateWifiSsid(@RequestParam String uuid, @RequestParam String value,
                                                 @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateWifiSsid(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/wifi/pass")
    @Operation(summary = "Оновити пароль точки доступу")

    public ResponseEntity<String> updateWifiPassword(@RequestParam String uuid, @RequestParam String value,
                                                     @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateWifiPassword(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/enable/sensors")
    @Operation(summary = "Дозволити зчитування даних та роботу сенсорів")

    public ResponseEntity<String> updateSensorsEnable(@RequestParam String uuid, @RequestParam String value,
                                                      @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateSensorsEnable(token, uuid, value);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/enable/dispensers")
    @Operation(summary = "Дозволити регулювання насосів")

    public ResponseEntity<String> updateDispensersEnable(@RequestParam String uuid, @RequestParam String value,
                                                         @RequestHeader("Authorization") String token) {
        deviceMicroserviceClient.updateDispensersEnable(token, uuid, value);
        return ResponseEntity.ok("OK");
    }
}
