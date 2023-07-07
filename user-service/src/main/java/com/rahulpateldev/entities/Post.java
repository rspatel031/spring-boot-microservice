package com.rahulpateldev.entities;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    private String id;
    private String name;
    private String description;
    private LocalDateTime localDateTime;
}
