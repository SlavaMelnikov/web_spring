package by.melnikov.myspringweb.model;

import jakarta.persistence.*;
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

    @Column(name = "building_number")
    private String buildingNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
