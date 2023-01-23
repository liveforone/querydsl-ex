package querydslex.querydslex.comment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import querydslex.querydslex.comment.dto.CommentRequest;
import querydslex.querydslex.comment.dto.CommentResponse;
import querydslex.querydslex.comment.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/{boardId}")
    public ResponseEntity<?> getCommentsBelongToBoard(
            @PathVariable("boardId") Long boardId
    ) {
        List<CommentResponse> comments = commentService.getCommentsByBoardId(boardId);

        return ResponseEntity.ok(comments);
    }

    @GetMapping("/comment/detail/{id}")
    public ResponseEntity<?> commentDetail(@PathVariable("id") Long id) {
        CommentResponse comment = commentService.getCommentById(id);

        return ResponseEntity.ok(comment);
    }

    @GetMapping("/comment/count/{boardId}")
    public ResponseEntity<?> getCountCommentBelongToBoard(
            @PathVariable("boardId") Long boardId
    ) {
        Long countComment = commentService.getCountByBoardId(boardId);

        return ResponseEntity.ok(countComment);
    }

    @PostMapping("/comment/post/{boardId}")
    public ResponseEntity<?> postComment(
            @PathVariable("boardId") Long boardId,
            @RequestBody CommentRequest commentRequest
    ) {
        commentService.saveComment(commentRequest, boardId);
        log.info("댓글 포스팅 성공");

        return ResponseEntity.ok("댓글 등록 성공");
    }

    @DeleteMapping("/comment/delete/{id}")
    public ResponseEntity<?> postComment(
            @PathVariable("id") Long id
    ) {
        commentService.deleteComment(id);
        log.info("댓글 삭제 성공");

        return ResponseEntity.ok("댓글 id : " + id + " 삭제 성공");
    }
}
