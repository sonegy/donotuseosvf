package sonegy.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sonegy.sample.model.Board;
import sonegy.sample.model.Member;

/**
 * @author: sonegy@sk.com
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
}
