# Spring 기반 회원-주문-할인 서비스 프로젝트

## 프로젝트의 목적 및 목표
- 스프링의 기본 원리, 핵심 컨셉인 `객체 지향 언어인 Java` 가 가진 강력한 특징을 잘 살려 `좋은 객체 지향 설계`를 기반으로 한 서비스 백엔드 개발

<br>

### 좋은 객체 지향 프로그램을 설계한다는 것은?
- 프로그램을 **유연** 하고 **변경이 용이** 하게 만든다는 특징을 지닌 객체 지향
- 즉 세상의 모든 것을 객체로 표현할 때, 객체를 역할(인터페이스)과 구현(클래스)으로 구분함으로써 기존 코드의 변경을 최소화하며 새로운 기능을 추가를 용이하게 하는, `다형성(polymorphism)`의 원리를 기반으로 설계를 하는 것을 말한다.
- 역할과 구현을 분리하여 섥계를 하는 것이 핵심이다. 역할과 구현으로 구분을 하면, 프로그램이 단순해지고, 유연해지며, 변경도 편리해진다.
  - 클라이언트는 대상의 역할(인터페이스)만 알면 된다.
  - 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
  - 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.
  - 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.

- 결론적으로, **인터페이스를 안정적으로 잘 설게하는 것**이 최종 목표이다.

<br>

## 좋은 객체 지향 설계의 5가지 원칙, SOLID
- SOLID 는 Clean Code의 저자로 유명한 로버트 마틴이 좋은 객체 지향 설계의 5가지 원칙을 정리하여, 5가지 단어들의 앞 글자를 따 만든 단어이다.

### 1. SRP 단일 책임 원칙 (Single Responsibility Principle)
- 하나의 클래스는 하나의 책임만 가져야 한다.
- 여기서 책임이란 단어가 매우 애매모호한데, 중요한 기준은 변경이다.
- 변경이 있을 때, 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것이라 할 수 있다.

### 2.OCP 개방-폐쇄 원칙 (Open/Closed Principle)
- 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
- 역할과 구현을 분리해놓으면, 인터페이스를 구현하는 새로운 클래스를 추가해 나갈 수 있다.
- 즉 기존 코드를 변경하지 않고(인터페이스), 구현체(클래스)만 변경함으로써 소프트웨어를 확장해나갈 수 있다.
- 스프링은 DI를 통해 OCP를 지원한다.

### 3. LSP 리스코프 치환 원칙 (Liskov substitution principle)
- 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
- 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 하며, 다형성을 지원해야 한다는 것,인터페이스를 구현한 구현체는 인터페이스의 규약을 신뢰하고 사용하기 위해서 필요한 원칙이다.
- 예를 들어, 자동차 인터페이스의 엑셀은 기본 전제가 앞으로 가는 기능을 수행한다. 이를 뒤로 가게 구현하는 것은 LSP 위반이다. 느리더라도 앞으로 가야 한다.

### ISP 인터페이스 분리 원칙 (Interface Segregation Principle)
- 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
- 인터페이스도 잘 분리하면 서로에게 영향을 주지 않으며, 인터페이스가 명확해지고 대체 가능성이 높아진다.

### 5. DIP 의존 관계 역전 원칙 (Dependency Inversion Principle)
- 프로그래머는 "추상화에 의존하고, 구체화에 의존하면 안 된다." 의존성 주입은 이 원칙을 따르는 방법 중 하나이다.
- 즉, 구현 클래스에 의존하지 말고, 인터페이스(역할, Role)에 의존해야 유연하게 구현체를 변경할 수 있다.

<br>


---

## Spring Boot 개발 환경 정보

- Project: Gradle: Groovy
- Language: Java
- Spring Boot Version: 3.0.1 
- Packaging: Jar
- Java SDK: 17
- DB: H2 In-memory

## 비즈니스 요구 사항
- 회원
  - [x] 회원을 가입하고 조회할 수 있다.
  - [x] 회원에는 일반, VIP 두 등급이 있다.
  - [x] 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)
- 주문과 할인 정책
  - [x] 회원은 상품을 주문할 수 있다.
  - [x] 회원 등급에 따라 할인 정책을 적용할 수 있다.
  - [x] 할인 정책은 모든 VIP에게는 1,000원을 할인해주는 고정 금액 할인을 적용한다. (나중에 변경 가능성 O)
  - [x] 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루는 상황이다. 최악의 경우 할인을 적용하지 않을 수도 있다.

<br>

---


## 블로그 정리

| 순서  | 제목                                                                                                                                               |
|:---:|:-------------------------------------------------------------------------------------------------------------------------------------------------|
|  1  | [스프링의 핵심 컨셉: 객체 지향과 다형성, SOLID 원칙과 DI 컨테이너에 대한 이해](https://dream-and-develop.tistory.com/396)                                                    |
|  2  | [Spring Boot란?](https://dream-and-develop.tistory.com/398)                                                                                       |
|  3  | [새로운 할인 정책 추가에 따른 객체 지향적인 확장 설계, 관심사의 분리와 제어의 역전, 의존 관계 주입 (AppConfig를 통한 DIP, OCP, SRP 적용, IoC, DI)](https://dream-and-develop.tistory.com/405) |
|  4  | [스프링 컨테이너와 스프링 빈 등록 과정 (@ApplicationContext, @Configuration, @Bean)](https://dream-and-develop.tistory.com/412)                                  |
|  5  | [스프링 싱글톤 컨테이너란? (싱글톤 패턴의 필요성과 문제점, 주의점)](https://dream-and-develop.tistory.com/419)                                                              |
|  6  | [컴포넌트 스캔 (@ComponentScan) 과 의존 관계 자동 주입(@Autowired)](https://dream-and-develop.tistory.com/428)                                                  |
|  7  | [의존 관계 자동 주입의 4가지 방법, 생성자 주입을 사용하기](https://dream-and-develop.tistory.com/433)                                                                   |
|  8  | [조회 빈이 2개 이상인 경우 문제 해결하기 (필드명/파라미터명, @Qualifier, @Primary)](https://dream-and-develop.tistory.com/448)                                           |
|  9  | [전략 패턴을 활용한 할인 정책 서비스 구현(List, Map을 이용해 동일한 타입 내 모든 스프링 빈 조회)](https://dream-and-develop.tistory.com/451)            |