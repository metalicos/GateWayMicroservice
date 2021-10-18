package ua.com.cyberdone.APIGateway.model.devicemicroservice.hydroponic;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HydroponicTimeDto {
    private LocalDateTime microcontrollerTime;
    private String microcontrollerTimeZone = "Europe/Kiev";
    private String uuid;
}
