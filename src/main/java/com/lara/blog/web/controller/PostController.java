package com.lara.blog.web.controller;

import com.lara.blog.service.IPostService;
import com.lara.blog.web.model.PostSummaryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final IPostService service;

    /**
     * Service for post summarise paged
     *
     * @param page:     Integer
     * @param pageSize: Integer
     *
     * @return PageImpl<PostSummaryDTO>
     **/
    @GetMapping
    public PageImpl<PostSummaryDTO> getAllPostsSummaryPaged(@RequestParam(name = "page",   required = false) Integer page,
                                                            @RequestParam(name = "page_size", required = false) Integer pageSize) {
        return service.getAllPostsSummaryPaged(page, pageSize);
    }

}
