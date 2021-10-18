package ua.com.cyberdone.APIGateway.model.accountmicroservice.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangeFullNameDto {
    private String username;
    private String firstName;
    private String lastName;
    private String patronymic;
}
