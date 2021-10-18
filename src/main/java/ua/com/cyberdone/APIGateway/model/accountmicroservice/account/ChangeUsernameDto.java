package ua.com.cyberdone.APIGateway.model.accountmicroservice.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangeUsernameDto {
    private String oldUsername;
    private String newUsername;
}
