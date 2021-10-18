package ua.com.cyberdone.APIGateway.model.accountmicroservice.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.security.Permission;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role extends BasicEntity {

    private String role;
    private Set<Permission> permissions;
}
