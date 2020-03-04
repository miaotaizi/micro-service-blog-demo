package xyz.miaotaizi.post.controller;

import com.github.javafaker.Faker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.miaotaizi.post.dto.GenericPostResponse;
import xyz.miaotaizi.post.dto.PostDto;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    @GetMapping("")
    public GenericPostResponse getPost() {
        Faker faker = new Faker();
        PostDto data = PostDto
                .builder()
                .title(faker.book().title())
                .content(faker.elderScrolls().quote())
                .build();
        return GenericPostResponse.builder()
                .data(data)
                .build();
    }
}
