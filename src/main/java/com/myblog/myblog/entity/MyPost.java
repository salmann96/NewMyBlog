package com.myblog.myblog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="myposts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class MyPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "description" , nullable = false)
    private String description;

    @Column(name = "content" , nullable = false)
    private String content;

}
