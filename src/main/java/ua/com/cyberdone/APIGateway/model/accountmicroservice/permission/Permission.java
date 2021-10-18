package ua.com.cyberdone.APIGateway.model.accountmicroservice.permission;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.BasicEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Permission extends BasicEntity {
    private String name;
    private String value;
}
