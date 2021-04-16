package com.sparta.samplememo1.model;

import com.sparta.samplememo1.dto.MemoRequestDto;
import com.sparta.samplememo1.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Memo extends Timestamped {
    //ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String name;

    //양방향 인스턴스 가져오기 위해
    @JoinColumn(nullable = false)
    @OneToMany
    private List<Comment> comment = new ArrayList<>();

    //글 생성시 이용
    public Memo(MemoRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.name = requestDto.getName();
    }

    //글 업데이트
    public void update(MemoRequestDto requestDto){
        //id XXXXXXXXXXXXXXXXXXXx
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.content = requestDto.getContent();
    }

}
