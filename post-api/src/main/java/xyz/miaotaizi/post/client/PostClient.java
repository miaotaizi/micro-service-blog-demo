package xyz.miaotaizi.post.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import xyz.miaotaizi.post.PostConstant;
import xyz.miaotaizi.post.dto.GenericPostResponse;

@FeignClient(name = PostConstant.SERVICE_NAME, path = "/v1/posts", url = "${blog.post-svc-endpoint}")
public interface PostClient {
    @GetMapping("")
    GenericPostResponse getPost();
}
