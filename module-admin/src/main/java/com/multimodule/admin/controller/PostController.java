package com.multimodule.admin.controller;


import com.multimodule.admin.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostRepository postRepository;

    @PostMapping("/ban")
    public String getPostList(@RequestParam long id) {
        postRepository.banPostById(id);
        return "POST HAS BEEN BANNED";
    }

}
