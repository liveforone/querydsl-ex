package querydslex.querydslex.board.util;

import org.springframework.data.domain.Page;
import querydslex.querydslex.board.model.Board;
import querydslex.querydslex.board.dto.BoardRequest;
import querydslex.querydslex.board.dto.BoardResponse;

public class BoardMapper {

    public static Board dtoToEntity(BoardRequest boardRequest) {
        return Board.builder()
                .id(boardRequest.getId())
                .title(boardRequest.getTitle())
                .content(boardRequest.getContent())
                .build();
    }

    private static BoardResponse dtoBuilder(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }

    public static Page<BoardResponse> entityToDtoPage(Page<Board> boards) {
        return boards.map(BoardMapper::dtoBuilder);
    }
}
