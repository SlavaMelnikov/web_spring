package by.melnikov.myspringweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "parking_points")
public class ParkingPoint {
    enum Status {
        OPEN, CLOSED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_point_id")
    private Integer parkingPointId;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
