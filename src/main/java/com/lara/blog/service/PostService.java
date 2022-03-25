package com.lara.blog.service;

import com.lara.blog.domain.Post;
import com.lara.blog.domain.enums.PostStatus;
import com.lara.blog.domain.facade.PostFacade;
import com.lara.blog.web.mapper.PostMapper;
import com.lara.blog.web.model.PostSummaryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.lara.blog.util.Constants.PAGE_DEFAULT;
import static com.lara.blog.util.Constants.PAGE_SIZE_DEFAULT;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostFacade facade;

    /**
     * Retrieves post summaries paged
     *
     * @param page
     * @param pageSize
     *
     * @return PageImpl<PostSummaryDTO>
     **/
    @Override
    public PageImpl<PostSummaryDTO> getAllPostsSummaryPaged(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(
                Optional
                    .ofNullable(page)
                    .orElse(PAGE_DEFAULT),
                Optional
                    .ofNullable(pageSize)
                    .orElse(PAGE_SIZE_DEFAULT)
        );

        Page<Post> postPage = facade.selectPostsPaged(PostStatus.ACTIVE, pageable);

        List<PostSummaryDTO> postSummaryDTOList = PostMapper
                .toListOfPostSummaryDTO(postPage.toList());

        return new PageImpl<>(postSummaryDTOList, pageable, postPage.getTotalElements());
    }
}
