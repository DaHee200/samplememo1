package com.sparta.samplememo1.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.sparta.samplememo1.Timestamped;
import com.sparta.samplememo1.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Comment extends Timestamped {

    //ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    //양방향
    @JoinColumn
    @ManyToOne
    private Memo memo;


    public Comment(CommentRequestDto commentDto){
        this.title = commentDto.getTitle();
        this.content = commentDto.getContent();
    }

    public void updateComment(CommentRequestDto commentDto){
        this.title = commentDto.getTitle();
        this.content = commentDto.getContent();
    }

//    public static List<ListDto> fromJSONtoList(String result) {
//        JSONObject rjson = new JSONObject(result);
//        JSONArray lists = rjson.getJSONArray(("lists"));
//        List<ListDto> ret = new ArrayList<>();
//        for (int i=0; i<lists.length(); i++) {
//            JSONObject listMemo = lists.getJSONObject(i);
//            ListDto listDto = new ListDto(listMemo);
//            ret.add(listDto);
//        }
//        return ret;
//    }
}
