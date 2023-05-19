package jpabook.japshop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // command와 query를 분리하는 차원에서 id 정도만 반환
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
