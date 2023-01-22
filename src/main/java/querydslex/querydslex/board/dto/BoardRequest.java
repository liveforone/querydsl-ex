package querydslex.querydslex.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardRequest {

    private Long id;
    private String title;
    private String content;
}
