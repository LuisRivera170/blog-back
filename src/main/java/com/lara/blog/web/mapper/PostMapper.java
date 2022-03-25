package com.lara.blog.web.mapper;

import com.lara.blog.domain.Post;
import com.lara.blog.web.model.PostSummaryDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static List<PostSummaryDTO> toListOfPostSummaryDTO(List<Post> posts) {
        return posts
                .stream()
                .map(PostMapper::toPostSummaryDTO)
                .collect(Collectors.toList());
    }

    public static PostSummaryDTO toPostSummaryDTO(Post post) {
        return PostSummaryDTO
                .builder()
                .id(post.getId())
                .title(post.getTitle())
                .summary(post.getSummary())
                .minutesToRead(post.getMinutesToRead())
                .publishedAt(post.getPublishedAt())
                .build();
    }

}
