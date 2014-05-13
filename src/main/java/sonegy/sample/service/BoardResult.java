package sonegy.sample.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sonegy.sample.model.Board;

/**
 * @author: sonegy@sk.com
 */
@Getter
@Setter
@ToString
public class BoardResult {
    private Long id;
    private String title;

    public static BoardResult of(Board board) {
        BoardResult result = new BoardResult();
        result.id = board.getId();
        result.title = board.getTitle();
        return result;
    }
}
