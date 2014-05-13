package sonegy.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sonegy.sample.model.Board;

/**
 * @author: sonegy@sk.com
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
}
