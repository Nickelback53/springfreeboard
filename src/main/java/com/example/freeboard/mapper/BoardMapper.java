package com.example.freeboard.mapper;

import com.example.freeboard.domain.Board;
import com.example.freeboard.domain.Pagination;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {

    List<Pagination> boardCount(); // 곧 생성할 BoardMapper.xml 첫번째 sql 문의 id 와 같음.

    List<Board> getList(Pagination pagination);

    Board getBoard(Long boardId);

    void uploadBoard(Board board);

    Object updateBoard(Board board);

    void deleteBoard(Long boardId);

    void viewCount(Long boardId);

    void changePage(Long curPage);
}