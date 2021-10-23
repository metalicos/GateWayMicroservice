package ua.com.cyberdone.APIGateway.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cyberdone.APIGateway.feign.AccountMicroserviceClient;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.AccountDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.AccountsDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.ChangeEmailDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.ChangeFullNameDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.ChangePasswordDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.LoginDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.LogoutDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.account.RegistrationDto;
import ua.com.cyberdone.APIGateway.model.accountmicroservice.token.TokenDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
@Tag(name = "Accounts API", description = "Інтерфейс для реєстрації, авентифікації та авторизації акаунтів користувача")
public class AccountController {
    private final AccountMicroserviceClient accountMicroserviceClient;

    @GetMapping
    @Operation(summary = "Отримати акаунти / один акаунт (якщо передати його email в параметрах)")
    public ResponseEntity<Object> readAllAccounts(@RequestHeader("Authorization") String token,
                                                  @RequestParam(value = "username", required = false) String username) {
        return accountMicroserviceClient.readAccounts(token, username);
    }

    @DeleteMapping
    @Operation(summary = "Видалити акаунти / один акаунт (якщо передати його email в параметрах)")
    public ResponseEntity<String> deleteAllAccounts(@RequestHeader("Authorization") String token,
                                                    @RequestParam(value = "username", required = false)
                                                            String username) {
        return accountMicroserviceClient.deleteAccounts(token, username);
    }

    @PostMapping
    @Operation(summary = "Створити новий акаунт")
    public ResponseEntity<AccountDto> createAccount(@RequestBody RegistrationDto registrationDto) {
        return accountMicroserviceClient.createAccount(registrationDto);
    }

    @GetMapping("/page/{page}/size/{size}/sort-by/{sort-by}/direction/{direction}")
    @Operation(summary = "Отримати акаунти із пагінацією")
    public ResponseEntity<AccountsDto> readAccounts(@RequestHeader("Authorization") String token,
                                                    @PathVariable("page") Integer page,
                                                    @PathVariable("size") Integer size,
                                                    @PathVariable("sort-by") String sortBy,
                                                    @PathVariable("direction") String direction) {
        return accountMicroserviceClient.readAccounts(token, page, size, sortBy, direction);
    }

    @PutMapping("/change/password")
    @Operation(summary = "Змінити пароль")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        return accountMicroserviceClient.changePassword(changePasswordDto);
    }

    @PutMapping("/change/fullname")
    @Operation(summary = "Змінити ПІБ")
    public ResponseEntity<String> changeFullName(@RequestHeader("Authorization") String token,
                                                 @RequestBody ChangeFullNameDto changeFullNameDto) {
        return accountMicroserviceClient.changeFullName(token, changeFullNameDto);
    }

    @PutMapping("/change/username")
    @Operation(summary = "Змінити email")
    public ResponseEntity<String> changeUsername(@RequestHeader("Authorization") String token,
                                                 @RequestBody ChangeEmailDto changeEmailDto) {
        return accountMicroserviceClient.changeUsername(token, changeEmailDto);
    }

    @PostMapping("/auth/login")
    @Operation(summary = "Вхід у систему")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto) {
        return accountMicroserviceClient.login(loginDto);
    }

    @PostMapping("/auth/logout")
    @Operation(summary = "Вихід із системи")
    public ResponseEntity<TokenDto> logout(@RequestHeader("Authorization") String token,
                                           @RequestBody LogoutDto logoutDto) {
        return accountMicroserviceClient.logout(token, logoutDto);
    }
}
