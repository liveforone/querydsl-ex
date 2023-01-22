package querydslex.querydslex.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import querydslex.querydslex.board.dto.BoardRequest;
import querydslex.querydslex.board.dto.BoardResponse;
import querydslex.querydslex.board.service.BoardService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<?> allBoards(
            @PageableDefault(page = 0, size = 10)
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "id")
            }) Pageable pageable
    ) {
        Page<BoardResponse> boards = boardService.findAll(pageable);

        return ResponseEntity.ok(boards);
    }

    @PostMapping("/board/post")
    public ResponseEntity<?> postBoard(@RequestBody BoardRequest boardRequest) {
        boardService.saveBoard(boardRequest);
        log.info("포스팅 성공");

        return ResponseEntity.ok("포스팅 성공");
    }

    @PutMapping("/board/edit/{id}")
    public ResponseEntity<?> editBoard(
            @PathVariable("id") Long id,
            @RequestBody String content
    ) {
        boardService.editBoard(content, id);
        log.info("수정 성공");

        return ResponseEntity.ok("게시글 수정 성공");
    }
}
