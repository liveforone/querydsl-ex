package querydslex.querydslex.comment.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import querydslex.querydslex.comment.model.Comment;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    //통계쿼리 +  조인(페치조인)하기 + 조인 페이징, 수정, 삭제 까지
    public Page<Comment> findCommentsByBoardId(Long boardId, Pageable pageable) {

    }
}
