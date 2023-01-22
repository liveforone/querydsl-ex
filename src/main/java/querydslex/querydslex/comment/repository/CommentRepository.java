package querydslex.querydslex.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import querydslex.querydslex.comment.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
}
