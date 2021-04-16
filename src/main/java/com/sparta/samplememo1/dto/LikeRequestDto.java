package com.sparta.samplememo1.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeRequestDto {
    private Long userId;
    private Long contentId;
}
