package ua.com.cyberdone.APIGateway.feign;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.DeviceMetadataDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.RegularScheduleDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.RegularScheduleUpdateDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicCalibrationDataDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicDataDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicSettingsDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicTimeDto;

import javax.validation.Valid;
import java.util.List;


@FeignClient(value = "cyber-done-device-microservice")
public interface DeviceMicroserviceClient {

    @GetMapping("/hydroponic/calibration-data/last")
    ResponseEntity<List<HydroponicCalibrationDataDto>> getLastCalibrationDataInDeviceWithUUID(
            @RequestParam String uuid,
            @RequestParam Integer page,
            @RequestParam Integer limit);

    @DeleteMapping("/hydroponic/calibration-data")
    ResponseEntity<Void> deleteCalibrationDataInDeviceWithUUID(@RequestParam Long id);

    @GetMapping("/hydroponic/data/last")
    ResponseEntity<List<HydroponicDataDto>> getLastDataInDeviceWithUUID(
            @RequestParam String uuid,
            @RequestParam Integer page,
            @RequestParam Integer limit);

    @DeleteMapping("/hydroponic/data")
    ResponseEntity<Void> deleteAllDataInDeviceWithUUID(@RequestParam Long id);

    @GetMapping("/hydroponic/settings/last")
    ResponseEntity<List<HydroponicSettingsDto>> getLastSettingsInDeviceWithUUID(
            @RequestParam String uuid,
            @RequestParam Integer page,
            @RequestParam Integer limit);

    @PostMapping("/update/time")
    ResponseEntity<String> updateTime(@Valid @RequestBody HydroponicTimeDto dto);

    @PostMapping("/update/zone")
    ResponseEntity<String> updateZone(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/autotime")
    ResponseEntity<String> updateTime(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/pumps/phUp/{direction}")
    ResponseEntity<String> updatePhUpPumpStatus(@RequestParam String uuid, @PathVariable String direction);

    @PostMapping("/update/pumps/phDown/{direction}")
    ResponseEntity<String> updatePhDownPumpStatus(@RequestParam String uuid, @PathVariable String direction);

    @PostMapping("/update/pumps/tds/{direction}")
    public ResponseEntity<String> updateTdsPumpStatus(@RequestParam String uuid, @PathVariable String direction);

    @PostMapping("/update/restart")
    ResponseEntity<String> restart(@RequestParam String uuid);

    @PostMapping("/update/save")
    ResponseEntity<String> saveAllSettings(@RequestParam String uuid);

    @PostMapping("/update/read")
    ResponseEntity<String> readAllSettings(@RequestParam String uuid);

    @PostMapping("/update/calibrate/tds")
    ResponseEntity<String> calibrateTdsSensor(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/calibrate/tds/clear")
    ResponseEntity<String> clrCalibrationTdsSensor(@RequestParam String uuid);

    @PostMapping("/update/calibrate/ph/low")
    ResponseEntity<String> calibratePhLow(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/calibrate/ph/high")
    ResponseEntity<String> calibratePhHigh(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/calibrate/ph/clear")
    ResponseEntity<String> clrCalibrationPhSensor(@RequestParam String uuid);

    @PostMapping("/update/setup/ph")
    ResponseEntity<String> updateSetupPhValue(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/setup/tds")
    ResponseEntity<String> updateSetupTdsValue(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/dispensers/recheck-time")
    ResponseEntity<String> updateRecheckDispensersAfterTime(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/dose/ph/up")
    ResponseEntity<String> updatePhUpDose(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/dose/ph/down")
    ResponseEntity<String> updatePhDownDose(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/dose/tds")
    ResponseEntity<String> updateFertilizerDose(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/regulator/error/ph")
    ResponseEntity<String> updateRegulatePhError(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/regulator/error/tds")
    ResponseEntity<String> updateRegulateTdsError(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/pump/speed")
    ResponseEntity<String> updatePumpSpeed(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/wifi/ssid")
    ResponseEntity<String> updateWifiSsid(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/wifi/pass")
    ResponseEntity<String> updateWifiPassword(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/enable/sensors")
    ResponseEntity<String> updateSensorsEnable(@RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/enable/dispensers")
    ResponseEntity<String> updateDispensersEnable(@RequestParam String uuid, @RequestParam String value);

    @GetMapping
    ResponseEntity<DeviceMetadataDto> getMetadataByUuid(@RequestParam String uuid);

    @PostMapping("/metadata")
    ResponseEntity<String> updateMetadata(@RequestParam String uuid, @RequestParam String name,
                                          @RequestParam String description);

    @DeleteMapping("/metadata")
    ResponseEntity<String> deleteMetadata(@RequestParam String uuid);

    @GetMapping("/schedules/{key}")
    ResponseEntity<List<RegularScheduleDto>> getSchedulesByKey(@RequestParam String uuid, @PathVariable String key);

    @PostMapping("/schedules")
    ResponseEntity<String> createSchedule(@Valid @RequestBody RegularScheduleDto schedule);

    @PatchMapping("/schedules")
    ResponseEntity<String> updateScheduleMetaInfo(@Valid @RequestBody RegularScheduleUpdateDto schedule);

    @DeleteMapping("/schedules/{id}")
    ResponseEntity<String> deleteScheduleById(@PathVariable Long id);
}
