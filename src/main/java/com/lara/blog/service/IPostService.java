package com.lara.blog.service;

import com.lara.blog.web.model.PostSummaryDTO;
import org.springframework.data.domain.PageImpl;

public interface IPostService {

    PageImpl<PostSummaryDTO> getAllPostsSummaryPaged(Integer page, Integer pageSize);

}
