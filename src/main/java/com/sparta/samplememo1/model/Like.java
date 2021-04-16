package com.sparta.samplememo1.model;

import com.sparta.samplememo1.Timestamped;
import com.sparta.samplememo1.dto.LikeRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Like extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long contentId;

    public Like(LikeRequestDto requestDto){
        this.userId = requestDto.getUserId();
        this.contentId = requestDto.getContentId();
    }

    public void update(LikeRequestDto requestDto){
        this.userId = requestDto.getUserId();
        this.contentId = requestDto.getContentId();
    }
}
