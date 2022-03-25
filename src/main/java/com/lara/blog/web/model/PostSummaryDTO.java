package com.lara.blog.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

@Setter
@Getter
@Builder
@JsonInclude(NON_NULL)
public class PostSummaryDTO {

    private Long id;
    private String title;
    private String summary;
    private Integer minutesToRead;
    private LocalDateTime publishedAt;

}
