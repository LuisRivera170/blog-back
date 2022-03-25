package com.lara.blog.domain.repository;

import com.lara.blog.domain.Post;
import com.lara.blog.domain.enums.PostStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllAllByStatus(PostStatus status, Pageable pageable);

}
