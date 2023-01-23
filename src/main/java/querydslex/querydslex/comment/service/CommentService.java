package querydslex.querydslex.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import querydslex.querydslex.board.model.Board;
import querydslex.querydslex.board.repository.BoardRepository;
import querydslex.querydslex.comment.dto.CommentRequest;
import querydslex.querydslex.comment.dto.CommentResponse;
import querydslex.querydslex.comment.repository.CommentRepository;
import querydslex.querydslex.comment.util.CommentMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public List<CommentResponse> getCommentsByBoardId(Long boardId) {
        return CommentMapper.entityToDtoList(
                commentRepository.findCommentsByBoardId(boardId)
        );
    }

    public CommentResponse getCommentById(Long id) {
        return CommentMapper.entityToDtoDetail(
                commentRepository.findOneById(id)
        );
    }

    public Long getCountByBoardId(Long boardId) {
        return commentRepository.countCommentByBoardId(boardId);
    }

    @Transactional
    public void saveComment(CommentRequest commentRequest, Long boardId) {
        Board board = boardRepository.findOneById(boardId);
        commentRequest.setBoard(board);
        commentRepository.save(
                CommentMapper.dtoToEntity(commentRequest)
        );
    }

    @Transactional
    public void deleteComment(Long id) {
        commentRepository.deleteOneById(id);
    }
}
