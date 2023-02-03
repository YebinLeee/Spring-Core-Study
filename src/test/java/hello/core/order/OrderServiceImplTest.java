package hello.core.order;

import hello.core.discount.RatedDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class OrderServiceImplTest {

    // 순수한 자바로 테스트
    @Test
    void createOrder(){
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "bin", Grade.VIP));

        OrderService orderService = new OrderServiceImpl(memberRepository, new RatedDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 1000);

        Assertions.assertThat(order.getItemName()).isEqualTo("itemA");
    }

}