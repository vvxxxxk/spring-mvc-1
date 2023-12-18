package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositroyTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("hello", 20);

        Member saveMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(saveMember.getId());

        assertThat(saveMember).isEqualTo(findMember);
    }

    @Test
    void findAll() {
        Member member1 = new Member("userA", 10);
        Member member2 = new Member("userB", 20);
        Member member3 = new Member("userC", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        List<Member> result =  memberRepository.findAll();

        assertThat(result.size()).isEqualTo(3);
        assertThat(result).contains(member1, member2);


    }
}
