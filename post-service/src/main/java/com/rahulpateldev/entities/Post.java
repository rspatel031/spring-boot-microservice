package com.rahulpateldev.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private String userId;
}
