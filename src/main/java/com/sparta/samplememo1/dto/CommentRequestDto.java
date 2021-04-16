package com.sparta.samplememo1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private String title;
    private String content;

//    public CommentRequestDto(JSONObject listJson) {
//        this.title = listJson.getString("title");
//        this.content = listJson.getString("content");
//    }
}
