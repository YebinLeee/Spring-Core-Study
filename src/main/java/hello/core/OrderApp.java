package hello.core;

<<<<<<< HEAD
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.discount.RatedDiscountPolicy;
import hello.core.member.*;
=======
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
>>>>>>> 9622a20e94c04855d4687fffcbcd8ad5478992b9
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
<<<<<<< HEAD
        MemberRepository memberRepository = new MemoryMemberRepository();
        DiscountPolicy discountPolicy = new RatedDiscountPolicy();
        MemberService memberService = new MemberServiceImpl(memberRepository);
        OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);
=======
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
>>>>>>> 9622a20e94c04855d4687fffcbcd8ad5478992b9

        // 회원 등록
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // 주문 생성
        Order order = orderService.createOrder(memberId, "item!", 1000);

        System.out.println("order = " + order);
        System.out.println("calculatedPrice = " + order.calculatePrice());

   }
}
