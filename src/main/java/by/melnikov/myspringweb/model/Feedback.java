package by.melnikov.myspringweb.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "feedbacks")
public class Feedback {
    enum Stars {
        ONE, TWO, THREE, FOUR, FIVE
    }

    @Id
    private Integer orderId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(name = "stars")
    private Stars stars;

    @Column(name = "review", length = 1000)
    private String review;

}
