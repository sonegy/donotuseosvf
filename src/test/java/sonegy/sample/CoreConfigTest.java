package sonegy.sample;

import org.hibernate.LazyInitializationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import sonegy.sample.model.Article;
import sonegy.sample.model.Board;
import sonegy.sample.model.Member;
import sonegy.sample.repository.ArticleRepository;
import sonegy.sample.repository.BoardRepository;
import sonegy.sample.repository.MemberRepository;
import sonegy.sample.service.ArticleResult;
import sonegy.sample.service.ArticleService;
import sonegy.sample.service.MemberResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertNotNull;

/**
 * @author: sonegy@sk.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class})
@TransactionConfiguration(defaultRollback = true)
public class CoreConfigTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;

    Board board;
    Member member;

    @Before
    @Transactional
    public void setUp() throws Exception {
        board = boardRepository.save(Board.of("board"));
        member = memberRepository.save(Member.of("member"));
    }

    @Test
    @Transactional
    public void testCreate() throws Exception {
        Article save = articleRepository.save(board.writeArticle("Title", "Content", member));
        System.out.println("save = " + save);
    }

    @Test
    @Transactional
    public void testUpdate() throws Exception {
        Article save = articleRepository.save(board.writeArticle("Title", "Content", member));
        save = articleRepository.save(save.modify("update", "update", save.getCreatedBy()));
        Member createdBy = save.getCreatedBy();
        assertNotNull(createdBy);

    }

    @Test(expected = LazyInitializationException.class)
    public void testLazyInitializationException() throws Exception {
        Long write = articleService.write(board.getId(), "title", "content", member.getId());
        Article article = articleService.find(write);
        Member createdBy = article.getCreatedBy();
        assertNotNull(createdBy.getName());
    }

    @Test
    public void testFindResultAndCreatedByName() throws Exception {
        Long write = articleService.write(board.getId(), "title", "content", member.getId());
        ArticleResult article = articleService.findResult(write);
        MemberResult createdBy = article.getCreatedBy();
        assertNotNull(createdBy.getName());
    }
}
