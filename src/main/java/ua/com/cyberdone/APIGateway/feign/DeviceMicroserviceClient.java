package ua.com.cyberdone.APIGateway.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.DeviceMetadataDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.DeviceType;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.RegularScheduleDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.RegularScheduleUpdateDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicCalibrationDataDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicDataDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicSettingsDto;
import ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic.HydroponicTimeDto;

import java.util.List;


@FeignClient(value = "cyber-done-device-microservice")
public interface DeviceMicroserviceClient {

    @GetMapping("/hydroponic/calibration-data/last")
    ResponseEntity<List<HydroponicCalibrationDataDto>> getLastCalibrationDataInDeviceWithUUID(
            @RequestHeader("Authorization") String token,
            @RequestParam String uuid,
            @RequestParam Integer page,
            @RequestParam Integer limit);

    @DeleteMapping("/hydroponic/calibration-data")
    ResponseEntity<Void> deleteCalibrationDataInDeviceWithUUID(@RequestHeader("Authorization") String token,
                                                               @RequestParam Long id);

    @GetMapping("/hydroponic/data/last")
    ResponseEntity<List<HydroponicDataDto>> getLastDataInDeviceWithUUID(
            @RequestHeader("Authorization") String token,
            @RequestParam String uuid,
            @RequestParam Integer page,
            @RequestParam Integer limit);

    @DeleteMapping("/hydroponic/data")
    ResponseEntity<Void> deleteAllDataInDeviceWithUUID(@RequestHeader("Authorization") String token,
                                                       @RequestParam Long id);

    @GetMapping("/hydroponic/settings/last")
    ResponseEntity<List<HydroponicSettingsDto>> getLastSettingsInDeviceWithUUID(
            @RequestHeader("Authorization") String token,
            @RequestParam String uuid,
            @RequestParam Integer page,
            @RequestParam Integer limit);

    @PostMapping("/update/time")
    ResponseEntity<String> updateTime(@RequestHeader("Authorization") String token,
                                      @RequestBody HydroponicTimeDto dto);

    @PostMapping("/update/zone")
    ResponseEntity<String> updateZone(@RequestHeader("Authorization") String token,
                                      @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/autotime")
    ResponseEntity<String> updateTime(@RequestHeader("Authorization") String token,
                                      @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/pumps/phUp/{direction}")
    ResponseEntity<String> updatePhUpPumpStatus(@RequestHeader("Authorization") String token,
                                                @RequestParam String uuid, @PathVariable String direction);

    @PostMapping("/update/pumps/phDown/{direction}")
    ResponseEntity<String> updatePhDownPumpStatus(@RequestHeader("Authorization") String token,
                                                  @RequestParam String uuid, @PathVariable String direction);

    @PostMapping("/update/pumps/tds/{direction}")
    public ResponseEntity<String> updateTdsPumpStatus(@RequestHeader("Authorization") String token,
                                                      @RequestParam String uuid, @PathVariable String direction);

    @PostMapping("/update/restart")
    ResponseEntity<String> restart(@RequestHeader("Authorization") String token,
                                   @RequestParam String uuid);

    @PostMapping("/update/save")
    ResponseEntity<String> saveAllSettings(@RequestHeader("Authorization") String token,
                                           @RequestParam String uuid);

    @PostMapping("/update/read")
    ResponseEntity<String> readAllSettings(@RequestHeader("Authorization") String token,
                                           @RequestParam String uuid);

    @PostMapping("/update/calibrate/tds")
    ResponseEntity<String> calibrateTdsSensor(@RequestHeader("Authorization") String token,
                                              @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/calibrate/tds/clear")
    ResponseEntity<String> clrCalibrationTdsSensor(@RequestHeader("Authorization") String token,
                                                   @RequestParam String uuid);

    @PostMapping("/update/calibrate/ph/low")
    ResponseEntity<String> calibratePhLow(@RequestHeader("Authorization") String token,
                                          @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/calibrate/ph/high")
    ResponseEntity<String> calibratePhHigh(@RequestHeader("Authorization") String token,
                                           @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/calibrate/ph/clear")
    ResponseEntity<String> clrCalibrationPhSensor(@RequestHeader("Authorization") String token,
                                                  @RequestParam String uuid);

    @PostMapping("/update/setup/ph")
    ResponseEntity<String> updateSetupPhValue(@RequestHeader("Authorization") String token,
                                              @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/setup/tds")
    ResponseEntity<String> updateSetupTdsValue(@RequestHeader("Authorization") String token,
                                               @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/dispensers/recheck-time")
    ResponseEntity<String> updateRecheckDispensersAfterTime(@RequestHeader("Authorization") String token,
                                                            @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/dose/ph/up")
    ResponseEntity<String> updatePhUpDose(@RequestHeader("Authorization") String token,
                                          @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/dose/ph/down")
    ResponseEntity<String> updatePhDownDose(@RequestHeader("Authorization") String token,
                                            @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/dose/tds")
    ResponseEntity<String> updateFertilizerDose(@RequestHeader("Authorization") String token,
                                                @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/regulator/error/ph")
    ResponseEntity<String> updateRegulatePhError(@RequestHeader("Authorization") String token,
                                                 @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/regulator/error/tds")
    ResponseEntity<String> updateRegulateTdsError(@RequestHeader("Authorization") String token,
                                                  @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/pump/speed")
    ResponseEntity<String> updatePumpSpeed(@RequestHeader("Authorization") String token,
                                           @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/wifi/ssid")
    ResponseEntity<String> updateWifiSsid(@RequestHeader("Authorization") String token,
                                          @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/wifi/pass")
    ResponseEntity<String> updateWifiPassword(@RequestHeader("Authorization") String token,
                                              @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/enable/sensors")
    ResponseEntity<String> updateSensorsEnable(@RequestHeader("Authorization") String token,
                                               @RequestParam String uuid, @RequestParam String value);

    @PostMapping("/update/enable/dispensers")
    ResponseEntity<String> updateDispensersEnable(@RequestHeader("Authorization") String token,
                                                  @RequestParam String uuid, @RequestParam String value);

    @GetMapping
    ResponseEntity<DeviceMetadataDto> getMetadataByUuid(@RequestHeader("Authorization") String token,
                                                        @RequestParam String uuid);

    @PostMapping("/metadata")
    ResponseEntity<String> updateMetadata(@RequestHeader("Authorization") String token,
                                          @RequestParam String uuid, @RequestParam String name,
                                          @RequestParam String description);

    @DeleteMapping("/metadata")
    ResponseEntity<String> deleteMetadata(@RequestHeader("Authorization") String token,
                                          @RequestParam String uuid);

    @GetMapping("/metadata/device-types")
    ResponseEntity<DeviceType[]> getDeviceTypesList(@RequestHeader("Authorization") String token);

    @PutMapping("/metadata/unlink")
    ResponseEntity<String> unlinkDevice(@RequestHeader("Authorization") String token,
                                        @RequestParam String uuid);

    @PutMapping("/metadata/link")
    ResponseEntity<String> linkDevice(@RequestHeader("Authorization") String token,
                                      @RequestParam String uuid, @RequestParam Long userId);

    @GetMapping("/schedules/{key}")
    ResponseEntity<List<RegularScheduleDto>> getSchedulesByKey(@RequestHeader("Authorization") String token,
                                                               @RequestParam String uuid, @PathVariable String key);

    @PostMapping("/schedules")
    ResponseEntity<String> createSchedule(@RequestHeader("Authorization") String token,
                                          @RequestBody RegularScheduleDto schedule);

    @PatchMapping("/schedules")
    ResponseEntity<String> updateScheduleMetaInfo(@RequestHeader("Authorization") String token,
                                                  @RequestBody RegularScheduleUpdateDto schedule);

    @DeleteMapping("/schedules/{id}")
    ResponseEntity<String> deleteScheduleById(@RequestHeader("Authorization") String token,
                                              @PathVariable Long id);
}
