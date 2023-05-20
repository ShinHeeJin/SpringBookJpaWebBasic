package jpabook.japshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    // Member & Order -> 1:M & M:1 양방향 관계
    // 연관관계의 주인 ( fk와 가까운 있는 엔티티를 주인 )
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private Delivery delivery;

    private LocalDateTime orderDate; // JAVA8에서는 Hibernate Mapping 지원 -> 별도 애너테이션 사용 필요 x

    private OrderStatus orderStatus;

}
