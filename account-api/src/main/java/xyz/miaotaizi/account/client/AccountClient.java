package xyz.miaotaizi.account.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import xyz.miaotaizi.account.AccountConstant;
import xyz.miaotaizi.account.dto.GenericAccountResponse;

@FeignClient(name = AccountConstant.SERVICE_NAME, path = "/v1/accounts", url = "${blog.account-svc-endpoint}")
public interface AccountClient {

    @GetMapping("")
    GenericAccountResponse getAccount();
}
