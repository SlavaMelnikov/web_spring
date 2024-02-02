package by.melnikov.myspringweb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "payment_cards")
public class PaymentCard {

    @Id
    private Integer userId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "card_number", unique = true)
    private String cardNumber;

    @Column(name = "owner")
    private String owner;

    @Column(name = "expired_data")
    private LocalDate expiredDate;

    @Column(name = "bank")
    private String bank;

}
