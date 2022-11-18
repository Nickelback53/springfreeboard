package com.example.freeboard.service;

import com.example.freeboard.domain.Board;
import com.example.freeboard.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // 서비스 역할을 하는 것임을 명시
@RequiredArgsConstructor // Mapper 생성자를 사용할 수 있게 함
@Transactional(readOnly = true)
public class BoardService {
    private final BoardMapper boardMapper;

    public int boardCount() {
        return boardMapper.boardCount(); // 게시글 수 반환
    }

    public List<Board> boardList() {
        return boardMapper.getList(); // 게시글 리스트 반환
    }
}