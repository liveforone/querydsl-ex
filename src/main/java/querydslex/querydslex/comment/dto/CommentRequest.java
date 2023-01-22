package querydslex.querydslex.comment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import querydslex.querydslex.board.model.Board;

@Data
@NoArgsConstructor
public class CommentRequest {

    private Long id;
    private String content;
    private String writer;
    private Board board;
}
