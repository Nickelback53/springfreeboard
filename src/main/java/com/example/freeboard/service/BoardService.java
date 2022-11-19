package com.example.freeboard.service;

import com.example.freeboard.domain.Board;
import com.example.freeboard.domain.Pagination;
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

    public List<Pagination> boardCount() {
        return boardMapper.boardCount(); // 게시글 수 반환
    }

    public List<Board> boardList(Pagination pagination) {
        return boardMapper.getList(pagination); // 게시글 리스트 반환
    }

    public Board getBoard(Long boardId) {
        return boardMapper.getBoard(boardId);
    }

    @Transactional
    public void uploadBoard(Board board) {
        boardMapper.uploadBoard(board);
    }

    @Transactional
    public Object updateBoard(Board board) {
        //boardMapper.updateBoard(board);
        return boardMapper.updateBoard(board);
    }




    @Transactional
    public void deleteBoard(Long boardId) {
        boardMapper.deleteBoard(boardId);
    }

    @Transactional
    public void viewCount(Long boardId) {
        boardMapper.viewCount(boardId);
    }

    @Transactional
    public void changePage(Long curPage) { boardMapper.changePage(curPage);}
}