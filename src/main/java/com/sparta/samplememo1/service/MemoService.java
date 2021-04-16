package com.sparta.samplememo1.service;


import com.sparta.samplememo1.model.Memo;
import com.sparta.samplememo1.repository.MemoRepository;
import com.sparta.samplememo1.dto.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional// 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다")
        );
        memo.update(requestDto);
        return memo.getId();
    }

}
