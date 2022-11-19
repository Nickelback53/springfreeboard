package com.example.freeboard.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {

    private int cnt;

    private int curPage ; // 현재 페이지 번호

    private int recordSize;       // 페이지당 출력할 데이터 개수

    private int pageSize;         // 화면 하단에 출력할 페이지 사이즈

    private String keyword;       // 검색 키워드

    private String searchType;    // 검색 유형

    private Paging paging;      // 페이지네이션 정보

    private int totalPage;

    public Pagination() {
        this.curPage = 1;
        this.recordSize = 5;
        this.pageSize = 5;
    }

    public int getOffset() {
        return (curPage - 1) * recordSize;
    }


}
