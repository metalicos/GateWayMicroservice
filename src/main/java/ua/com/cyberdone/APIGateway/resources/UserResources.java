package ua.com.cyberdone.APIGateway.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserResources {
    private final RestTemplate restTemplate;


}
