package querydslex.querydslex.comment.repository;

import querydslex.querydslex.comment.model.Comment;

import java.util.List;

public interface CommentRepositoryCustom {

    List<Comment> findCommentsByBoardId(Long boardId);

    Long countCommentByBoardId(Long boardId);

    Comment findOneById(Long id);

    void deleteOneById(Long id);
}
