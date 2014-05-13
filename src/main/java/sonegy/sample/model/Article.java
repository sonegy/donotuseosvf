package sonegy.sample.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: sonegy@sk.com
 */
@Entity
@Getter
@Setter(AccessLevel.PACKAGE)
@ToString
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Board board;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member createdBy;
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member modifiedBy;
    private Date modifiedDate;

    Article() {
        createdDate = new Date();
    }

    public Article(Board board, Member createdBy) {
        this();
        setCreatedBy(createdBy);
        setBoard(board);
    }

    public Article modify(String title, String content, Member modifiedBy) {
        this.title = title;
        this.content = content;
        this.modifiedDate = new Date();
        this.modifiedBy = modifiedBy;
        return this;
    }
}
