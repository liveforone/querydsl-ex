package querydslex.querydslex.comment.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import querydslex.querydslex.board.model.QBoard;
import querydslex.querydslex.comment.model.Comment;
import querydslex.querydslex.comment.model.QComment;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public List<Comment> findCommentsByBoardId(Long boardId) {
        QComment comment = QComment.comment;
        QBoard board = QBoard.board;

        return queryFactory.selectFrom(comment)
                .join(comment.board, board).fetchJoin()
                .on(board.id.eq(boardId))
                .orderBy(comment.id.desc())
                .fetch();
    }

    public Comment findOneById(Long id) {
        QComment comment = QComment.comment;
        QBoard board = QBoard.board;

        return queryFactory.selectFrom(comment)
                .join(comment.board, board).fetchJoin()
                .where(comment.id.eq(id))
                .fetchOne();
    }

    public Long countCommentByBoardId(Long boardId) {
        QComment comment = QComment.comment;
        QBoard board = QBoard.board;

        return queryFactory.select(comment.count())
                .from(comment)
                .join(comment.board, board)
                .on(board.id.eq(boardId))
                .fetchOne();
    }

    public void deleteOneById(Long id) {
        QComment comment = QComment.comment;

        queryFactory.delete(comment)
                .where(comment.id.eq(id))
                .execute();
    }
}
