package sonegy.sample.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sonegy.sample.model.Member;

/**
 * @author: sonegy@sk.com
 */
@Getter
@Setter
@ToString
public class MemberResult {
    private Long id;
    private String name;

    public static MemberResult of(Member member) {
        if (member == null)
            return null;
        MemberResult result = new MemberResult();
        result.id = member.getId();
        result.name = member.getName();
        return result;
    }
}
