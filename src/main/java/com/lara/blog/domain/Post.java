package com.lara.blog.domain;

import com.lara.blog.domain.enums.PostStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
@Table(
    name = "posts"
)
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = false)
    private String summary;

    private String body;

    private Integer minutesToRead;

    private LocalDateTime publishedAt;

    private LocalDateTime createdAt;

    @Enumerated(STRING)
    private PostStatus status;

}
