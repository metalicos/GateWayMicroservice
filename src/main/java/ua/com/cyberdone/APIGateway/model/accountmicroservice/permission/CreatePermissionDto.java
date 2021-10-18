package ua.com.cyberdone.APIGateway.model.accountmicroservice.permission;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatePermissionDto {
    private String name;
    private String value;
}
