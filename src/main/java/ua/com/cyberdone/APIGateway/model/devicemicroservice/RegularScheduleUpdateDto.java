package ua.com.cyberdone.APIGateway.model.devicemicroservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegularScheduleUpdateDto {
    private Long id;
    private String name;
    private String description;
}
