package com.sparta.samplememo1.controller;

import com.sparta.samplememo1.dto.MemoRequestDto;
import com.sparta.samplememo1.Timestamped;
import com.sparta.samplememo1.model.Memo;
import com.sparta.samplememo1.repository.MemoRepository;
import com.sparta.samplememo1.service.Const;
import com.sparta.samplememo1.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*")
@CrossOrigin(origins = Const.ClientServerHost)
@RestController
@RequiredArgsConstructor
public class MemoController extends Timestamped {

    private final MemoRepository memoRepository;
    private final MemoService memoService;


    @ResponseBody
    @GetMapping(value = "/api/memo", produces = "application/json")
    public List<Memo> getMemo() {

        return memoRepository.findAllByOrderByModifiedAt();
    }

    //글 등록
    @ResponseBody
    @PostMapping(value = "/api/memo", produces = "application/json")
    public Memo creatMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    //글 수정
    @ResponseBody
    @PutMapping(value = "/api/memo/{id}", produces = "application/json")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.update(id, requestDto);
    }

    //아이디에 따른 내용 조회
    @GetMapping(value = "/api/memoOne/{id}", produces = "application/json")
    public Memo findMemo(@PathVariable Long id) {
        return memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다")
        );
    }

//    @ResponseBody
//    @RequestMapping(value = "/memoOne/{id}", method = RequestMethod.GET)
//    public ModelAndView memoOne(@PathVariable Long id){
//        return new ModelAndView(String.valueOf(id));
//    }

//    @ResponseBody
//    @RequestMapping(value = "/memoOne/{id}", method = RequestMethod.GET)
//    public String project(){
//        return new ModelAndView(String.valueOf(id));
//    }

    //삭제
    @ResponseBody
    @DeleteMapping(value = "/api/memo/{id}", produces = "application/json")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    @ResponseBody
    @GetMapping(value = "/api/memoOneName/{name}", produces = "application/json")
    public List<Memo> findMemo(@PathVariable String name) {
        System.out.println("name="+name);
        return memoRepository.findByNameLike(name);
        //String비교 할 때  like 꼭 쓰자 다희야...
    }

//    ////검색 내용에 따른 글 가져오기
//    @ResponseBody
//    @GetMapping(value = "/api/search", produces = "application/json")
//    public List<ListDto> getMemos(@RequestParam String query) {
//        String resultString = ListSearch.search(query);
//        return ListSearch.fromJSONtoList(resultString);
//    }


}
