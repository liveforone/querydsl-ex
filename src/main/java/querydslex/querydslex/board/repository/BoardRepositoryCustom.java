package querydslex.querydslex.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import querydslex.querydslex.board.model.Board;

public interface BoardRepositoryCustom {  //query dsl 시그니처작성. 구현체는 ~impl

    Page<Board> findBoards(Pageable pageable);

    void editContent(String content, Long id);
}
