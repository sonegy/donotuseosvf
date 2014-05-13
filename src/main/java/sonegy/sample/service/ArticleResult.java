package sonegy.sample.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sonegy.sample.model.Article;

import java.util.Date;

/**
 * @author: sonegy@sk.com
 */
@Getter
@Setter
@ToString
public class ArticleResult {

    private Long id;
    private BoardResult board;
    private String title;
    private String content;
    private MemberResult createdBy;
    private Date createdDate;
    private MemberResult modifiedBy;
    private Date modifiedDate;

    static ArticleResult of(Article article) {
        ArticleResult result = new ArticleResult();
        result.id = article.getId();
        result.board = BoardResult.of(article.getBoard());
        result.title = article.getTitle();
        result.createdBy = MemberResult.of(article.getCreatedBy());
        result.createdDate = article.getCreatedDate();
        result.modifiedBy = MemberResult.of(article.getModifiedBy());
        result.modifiedDate = article.getModifiedDate();
        return result;
    }
}
