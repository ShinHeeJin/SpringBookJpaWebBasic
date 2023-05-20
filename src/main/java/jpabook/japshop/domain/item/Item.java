package jpabook.japshop.domain.item;

import jpabook.japshop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {
    // 구현체를 만들것이기 때문에 추상클래스

    // 상속관계 매핑 전략

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items") // 실무에서는 ManyToMany를 거의 사용하지 않는다. 관계 테이블에 추가 컬럼이 항상 들어가기 때문.
    private List<Category> categories = new ArrayList<>();

}
