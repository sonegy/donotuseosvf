package sonegy.sample.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author: sonegy@sk.com
 */
@Entity
@Getter
@Setter(AccessLevel.PACKAGE)
@ToString
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    public static Board of(String title) {
        Board board = new Board();
        board.setTitle(title);
        return board;
    }

    public Article writeArticle(String title, String content, Member createdBy) {
        Article article = new Article(this, createdBy);
        article.setTitle(title);
        article.setContent(content);
        return article;
    }
}
