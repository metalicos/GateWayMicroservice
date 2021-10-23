package ua.com.cyberdone.APIGateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.AccountDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.AccountsDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.ChangeEmailDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.ChangeFullNameDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.ChangePasswordDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.LoginDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.LogoutDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.RegistrationDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.permission.CreatePermissionDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.permission.PermissionDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.permission.PermissionsDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.token.TokenDto;

@FeignClient(value = "cyber-done-account-microservice")
public interface AccountMicroserviceClient {

    @GetMapping("/accounts")
    ResponseEntity<Object> readAccounts(@RequestHeader("Authorization") String token,
                                        @RequestParam(value = "username", required = false) String username);

    @DeleteMapping("/accounts")
    ResponseEntity<String> deleteAccounts(@RequestHeader("Authorization") String token,
                                          @RequestParam(value = "username", required = false) String username);

    @PostMapping("/accounts/registration")
    ResponseEntity<AccountDto> createAccount(@RequestBody RegistrationDto registrationDto);

    @GetMapping("/accounts/page/{page}/size/{size}/sort-by/{sort-by}/direction/{direction}")
    ResponseEntity<AccountsDto> readAccounts(@RequestHeader("Authorization") String token,
                                             @PathVariable("page") Integer page,
                                             @PathVariable("size") Integer size,
                                             @PathVariable("sort-by") String sortBy,
                                             @PathVariable("direction") String direction);

    @PutMapping("/accounts/change/password")
    ResponseEntity<String> changePassword(@RequestBody ChangePasswordDto changePasswordDto);

    @PutMapping("/accounts/change/fullname")
    ResponseEntity<String> changeFullName(@RequestHeader("Authorization") String token,
                                          @RequestBody ChangeFullNameDto changeFullNameDto);

    @PutMapping("/accounts/change/username")
    ResponseEntity<String> changeUsername(@RequestHeader("Authorization") String token,
                                          @RequestBody ChangeEmailDto changeEmailDto);

    @PostMapping("/accounts/authentication/login")
    ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto);

    @PostMapping("/accounts/authentication/logout")
    ResponseEntity<TokenDto> logout(@RequestHeader("Authorization") String token, @RequestBody LogoutDto logoutDto);

    @GetMapping("/permissions")
    ResponseEntity<Object> readPermissions(@RequestHeader("Authorization") String token,
                                           @RequestParam(value = "name", required = false) String name);

    @DeleteMapping("/permissions")
    ResponseEntity<String> deletePermissions(@RequestHeader("Authorization") String token,
                                             @RequestParam(value = "name", required = false) String name);

    @PostMapping("/permissions")
    ResponseEntity<PermissionDto> createPermission(@RequestHeader("Authorization") String token,
                                                   @RequestBody CreatePermissionDto dto);

    @GetMapping("/permissions/page/{page}/size/{size}/sort-by/{sort-by}/direction/{direction}")
    ResponseEntity<PermissionsDto> readPermissions(@RequestHeader("Authorization") String token,
                                                   @PathVariable("page") Integer page,
                                                   @PathVariable("size") Integer size,
                                                   @PathVariable("sort-by") String sortBy,
                                                   @PathVariable("direction") String direction);
}
