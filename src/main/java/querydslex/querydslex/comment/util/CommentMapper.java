package querydslex.querydslex.comment.util;

import querydslex.querydslex.comment.dto.CommentRequest;
import querydslex.querydslex.comment.dto.CommentResponse;
import querydslex.querydslex.comment.model.Comment;

import java.util.List;
import java.util.stream.Collectors;

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

    public static CommentResponse entityToDtoDetail(Comment comment) {
        return dtoBuilder(comment);
    }

    public static List<CommentResponse> entityToDtoList(List<Comment> comments) {
        return comments
                .stream()
                .map(CommentMapper::dtoBuilder)
                .collect(Collectors.toList());
    }
}
