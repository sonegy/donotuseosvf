package sonegy.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonegy.sample.model.Article;
import sonegy.sample.model.Board;
import sonegy.sample.model.Member;
import sonegy.sample.repository.ArticleRepository;
import sonegy.sample.repository.BoardRepository;
import sonegy.sample.repository.MemberRepository;

/**
 * @author: sonegy@sk.com
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Article find(Long id) {
        return articleRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public ArticleResult findResult(Long id) {
        return ArticleResult.of(articleRepository.findOne(id));
    }

    @Transactional
    public Long write(Long boardId, String title, String content, Long memberId) {
        Board board = boardRepository.findOne(boardId);
        Member member = memberRepository.findOne(memberId);
        return articleRepository.save(board.writeArticle(title, content, member)).getId();
    }

    @Transactional
    public Long modify(Long articleId, String title, String content, Long memberId) {
        Article article = articleRepository.findOne(articleId);
        Member member = memberRepository.findOne(memberId);
        return articleRepository.save(article.modify(title, content, member)).getId();
    }
}
