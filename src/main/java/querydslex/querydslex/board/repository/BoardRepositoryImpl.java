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

    public Page<Board> findBoards(Pageable pageable) {
        QBoard qBoard = QBoard.board;

        List<Board> content =  queryFactory.selectFrom(qBoard)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(qBoard.id.desc())
                .fetch();

        return new PageImpl<>(content, pageable, content.size());
    }

    public void editContent(String content, Long id) {
        QBoard qBoard = QBoard.board;
        queryFactory.update(qBoard)
                .set(qBoard.content, content)
                .where(qBoard.id.eq(id))
                .execute();
    }
}
