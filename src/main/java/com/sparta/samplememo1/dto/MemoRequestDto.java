package com.sparta.samplememo1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Getter
@NoArgsConstructor
public class MemoRequestDto {

    private Long id;
    private String title;
    private String content;
    private String name;

//    public void requestDto(JSONObject requestDto) {
//        this.id= requestDto.getLong("id");
//        this.title = requestDto.getString("title");
//        this.content = requestDto.getString("content");
//        this.name = requestDto.getString("name");
//
//    }

}
