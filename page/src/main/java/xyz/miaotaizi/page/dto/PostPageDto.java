package xyz.miaotaizi.page.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.miaotaizi.account.dto.AccountDto;
import xyz.miaotaizi.post.dto.PostDto;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PostPageDto {
    private AccountDto account;
    private PostDto post;
}
