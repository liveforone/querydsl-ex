package querydslex.querydslex.comment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import querydslex.querydslex.comment.model.Comment;

public interface CommentRepositoryCustom {

    Page<Comment> findCommentsByBoardId(Long boardId, Pageable pageable);
}
