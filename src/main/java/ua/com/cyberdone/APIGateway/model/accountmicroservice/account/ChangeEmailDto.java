package ua.com.cyberdone.APIGateway.model.accountmicroservice.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangeEmailDto {
    private String oldEmail;
    private String newEmail;
}
