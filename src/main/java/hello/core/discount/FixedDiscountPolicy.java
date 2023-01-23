package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy{

    private int discountFixedAmount = 1000; // 1000원 할인

    /**
     *
     * 고정 할인 금액 (최종 할인된 가격을 반환)
     * VIP 멤버인 경우 discountFixedAmount 가격을 반환, 아닌 경우 0을 반환
     */

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixedAmount;
        }
        else{
            return 0;
        }
    }
}
