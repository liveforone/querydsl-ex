package querydslex.querydslex.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import querydslex.querydslex.board.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
}
