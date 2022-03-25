package com.lara.blog.domain.facade;

import com.lara.blog.domain.Post;
import com.lara.blog.domain.enums.PostStatus;
import com.lara.blog.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PostFacade {

    private final PostRepository repository;

    /**
     * Retrieves post paged
     *
     * @param status
     * @param pageable
     *
     * @return Page<Post>
     **/
    @Transactional(readOnly = true)
    public Page<Post> selectPostsPaged(PostStatus status, Pageable pageable) {
        return repository.findAllAllByStatus(status, pageable);
    }

}
