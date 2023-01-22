package querydslex.querydslex.comment.util;

import org.springframework.data.domain.Page;
import querydslex.querydslex.comment.dto.CommentRequest;
import querydslex.querydslex.comment.dto.CommentResponse;
import querydslex.querydslex.comment.model.Comment;

public class CommentMapper {

    public static Comment dtoToEntity(CommentRequest commentRequest) {
        return Comment.builder()
                .id(commentRequest.getId())
                .content(commentRequest.getContent())
                .writer(commentRequest.getWriter())
                .board(commentRequest.getBoard())
                .build();
    }

    private static CommentResponse dtoBuilder(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .writer(comment.getWriter())
                .build();
    }

//    public static Page<CommentResponse>
}
