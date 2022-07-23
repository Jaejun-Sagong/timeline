package com.sparta.week03.service;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor //final로 선언한 변수가 있으면 꼭 생성해달라는 것
@Service
public class MemoService {


    private final MemoRepository memoRepository; // [2번]update메소드 작성 전에 id에 맞는 값을 찾으려면 find를 써야하는데 find를 쓰기위해서는 Repository가 있어야한다.

    @Transactional //업데이트 할 때 이게 DB에 꼭 반영돼야 한다고 해주는 녀석
    public Long update(Long id, MemoRequestDto requestDto){ //[1번]업데이트 메소드를 선언하고 id와 변경시킬 내용을 담은 녀석이 필요    [6번] return을 보고 반환타입 Long
        Memo memo = memoRepository.findById(id).orElseThrow( //[3번]  수정할 id에 해당하는 데이터를 repo에서 찾고 해당id를 갖는 memo를 호출한다.
                () -> new NullPointerException("아이디가 존재하지 않습니다")
        );
        memo.update(requestDto);    //[4번] 해당id를 갖는 memo를 requestDto로 수정한다.
        return id;   //[5번] 어떤 녀석이 업데이트 됐는지 알려주기위해
    }
}
