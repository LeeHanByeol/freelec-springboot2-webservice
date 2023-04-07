package org.example.practice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.practice.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor      //기본생성자 public Posts(){} 자동 추가
@Entity     //테이블과 링크될 클래스임
public class Posts extends BaseTimeEntity {

    @Id         //해당 테이블의 primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //primary key의 생성규칙; GenerationType.IDENTITY -> auto-increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
