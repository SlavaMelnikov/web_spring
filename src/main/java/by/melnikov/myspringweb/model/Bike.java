package by.melnikov.myspringweb.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bikes")
public class Bike {
    enum Type {
        KID, CITY, SPORT, MOUNTAIN
    }

    enum Status {
        AVAILABLE, ORDERED, IN_SERVICE, UTILIZED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bike_id")
    private Integer bikeId;

    @Column(name = "model")
    private String model;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "parking_point_id")
    private ParkingPoint parkingPointId;

}
