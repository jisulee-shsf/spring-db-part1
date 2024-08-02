package study.springdbpart1.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import study.springdbpart1.domain.Member;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        //save()
        Member member = new Member("memberV0", 10000);
        repository.save(member);

        //findById()
        Member findMember = repository.findById(member.getMemberId());
        assertThat(findMember).isEqualTo(member);

        //update()
        repository.update(member.getMemberId(), 20000);
        Member updateMember = repository.findById(member.getMemberId());
        assertThat(updateMember.getMoney()).isEqualTo(20000);
    }
}
