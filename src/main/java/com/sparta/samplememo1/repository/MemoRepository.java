package com.sparta.samplememo1.repository;

import com.sparta.samplememo1.model.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    //24시간 후 삭제 없애기
     List<Memo> findAllByOrderByModifiedAt();
     List<Memo> findByNameLike(String name);

}
