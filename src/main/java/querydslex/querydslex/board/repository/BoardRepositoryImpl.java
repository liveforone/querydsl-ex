package querydslex.querydslex.board.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import querydslex.querydslex.board.model.Board;
import querydslex.querydslex.board.model.QBoard;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public Board findOneById(Long id) {
        QBoard board = QBoard.board;

        return queryFactory.selectFrom(board)
                .where(board.id.eq(id))
                .fetchOne();
    }

    public Page<Board> findBoards(Pageable pageable) {
        QBoard board = QBoard.board;

        List<Board> content =  queryFactory.selectFrom(board)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(board.id.desc())
                .fetch();

        return new PageImpl<>(content, pageable, content.size());
    }

    public void editContent(String content, Long id) {
        QBoard board = QBoard.board;

        queryFactory.update(board)
                .set(board.content, content)
                .where(board.id.eq(id))
                .execute();
    }

    public Page<Board> searchBoardsByTitle(String title, Pageable pageable) {
        QBoard board = QBoard.board;

        List<Board> content =  queryFactory.selectFrom(board)
                .where(board.title.contains(title))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(board.id.desc())
                .fetch();

        return new PageImpl<>(content, pageable, content.size());
    }
}
