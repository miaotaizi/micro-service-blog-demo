package xyz.miaotaizi.account.controller;

import com.github.javafaker.Faker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.miaotaizi.account.dto.AccountDto;
import xyz.miaotaizi.account.dto.GenericAccountResponse;

@RequestMapping("/v1/accounts")
@RestController
public class AccountController {

    @GetMapping("")
    public GenericAccountResponse getAccount() {
        Faker faker = new Faker();
        AccountDto data = AccountDto.builder()
                .address(faker.address().fullAddress())
                .name(faker.name().fullName())
                .build();
        return GenericAccountResponse.builder()
                .data(data)
                .build();
    }
}
