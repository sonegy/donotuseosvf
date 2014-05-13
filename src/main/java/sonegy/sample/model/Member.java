package sonegy.sample.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author: sonegy@sk.com
 */
@Entity
@Getter
@Setter(AccessLevel.PACKAGE)
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public static Member of(String name) {
        Member member = new Member();
        member.setName(name);
        return member;
    }
}
