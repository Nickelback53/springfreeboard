package com.example.freeboard.Controller;

import com.example.freeboard.domain.Board;
import com.example.freeboard.domain.Pagination;
import com.example.freeboard.domain.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.freeboard.service.BoardService;


@Controller

@RequestMapping("/board/**")
@RequiredArgsConstructor
public class BoardController {

//    private final BoardService service;
    @Autowired
    private BoardService service;

    @GetMapping("/hello")
    public String Hello() {
        return "/boards/hello";
    }


    @GetMapping("/test")
    public String test(Model model, Pagination pagination) {
        model.addAttribute("cnt", service.boardCount(pagination));
        model.addAttribute("test", service.boardList(pagination));

        return "/boards/hello";
    }

    @GetMapping("/main")
    public String main(@ModelAttribute("pagination") Pagination pagination, Model model) {
        PagingResponse<Board> response = service.boardList(pagination);
//        model.addAttribute("cnt", service.boardCount(pagination));
        model.addAttribute("list", response);

        return "/boards/main";
    }

    @GetMapping("/view")
    public String viewBoard(Model model, Long boardId) {
        service.viewCount(boardId);
        model.addAttribute("halo", service.getBoard(boardId));

        return "/boards/view";
    }


    @GetMapping("/upload")
    public String uploadBoardForm() {
        return "/boards/upload";
    }

    @PostMapping("/upload")
    public String uploadBoard(Board board) {
        service.uploadBoard(board);
        return "redirect:/board/main";
    }


    @GetMapping("/update")
    public String updateBoardForm(Model model, Long boardId) {
        model.addAttribute("update", service.getBoard(boardId));

        return "/boards/update";
    }

    @PostMapping("/update")
    public String updateBoard(Board board) {
        service.updateBoard(board);
        return "redirect:/board/main";
    }

    @GetMapping("/delete")
    public String deleteBoard(Long boardId) {
        service.deleteBoard(boardId);
        return "redirect:/board/main";
    }

//    @GetMapping("/pageChange")
//    public String changePage(Long curPage) {
//        service.changePage(curPage);
//        return "/board/main";
//    }


}
