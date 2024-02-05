package by.melnikov.myspringweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
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
    @PrimaryKeyJoinColumn(name = "user_id")
    private User user;

    @Column(name = "card_number", unique = true)
    private String cardNumber;

    @Column(name = "owner")
    private String owner;

    @Column(name = "expired_data")
    private LocalDate expiredDate;

}
