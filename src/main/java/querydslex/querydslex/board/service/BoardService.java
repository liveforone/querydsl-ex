package querydslex.querydslex.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import querydslex.querydslex.board.dto.BoardRequest;
import querydslex.querydslex.board.dto.BoardResponse;
import querydslex.querydslex.board.repository.BoardRepository;
import querydslex.querydslex.board.util.BoardMapper;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<BoardResponse> findAll(Pageable pageable) {
        return BoardMapper.entityToDtoPage(
                boardRepository.findBoards(pageable)
        );
    }

    @Transactional
    public void saveBoard(BoardRequest boardRequest) {
        boardRepository.save(
                BoardMapper.dtoToEntity(boardRequest)
        );
    }

    @Transactional
    public void editBoard(String content, Long id) {
        boardRepository.editContent(content, id);
    }
}
