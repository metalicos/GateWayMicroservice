package ua.com.cyberdone.APIGateway.model.devicemicroservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceMetadataDto {
    private Long id;
    private String uuid;
    private String name;
    private String description;
    private DeviceType deviceType;
    private Boolean accessEnabled;
    private Long userId;
}
