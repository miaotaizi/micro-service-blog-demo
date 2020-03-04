package xyz.miaotaizi.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.miaotaizi.account.client.AccountClient;
import xyz.miaotaizi.account.dto.GenericAccountResponse;
import xyz.miaotaizi.page.dto.PostPageDto;
import xyz.miaotaizi.post.client.PostClient;
import xyz.miaotaizi.post.dto.GenericPostResponse;

@RestController
@RequestMapping("/pages/post")
public class PostPageController {

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private PostClient postClient;

    @GetMapping("")
    public PostPageDto getPage() {
        GenericAccountResponse accountResponse = accountClient.getAccount();
        GenericPostResponse postResponse = postClient.getPost();
        return PostPageDto
                .builder()
                .account(accountResponse.getData())
                .post(postResponse.getData())
                .build();
    }

    @GetMapping("foo")
    public String foo(){
        return "post.foo";
    }
}
