package sonegy.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sonegy.sample.model.Article;

/**
 * @author: sonegy@sk.com
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
