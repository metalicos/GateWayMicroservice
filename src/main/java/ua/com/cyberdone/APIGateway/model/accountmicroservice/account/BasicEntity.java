package ua.com.cyberdone.APIGateway.model.accountmicroservice.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class BasicEntity implements Serializable {
    private Long id;
    private LocalDateTime createdTimestamp;
}
