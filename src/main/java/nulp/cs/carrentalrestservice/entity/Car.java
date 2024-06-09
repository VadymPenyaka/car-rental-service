package nulp.cs.carrentalrestservice.entity;

import jakarta.persistence.*;
import lombok.*;
import nulp.cs.carrentalrestservice.model.CarClass;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "cars")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, columnDefinition = "varchar(50)", length = 50)
    private String brand;
    @Column(nullable = false, length = 50)
    private String model;
    @Column(nullable = false)
    private double pricePerDay;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarClass carClass;
    @Column(nullable = false, length = 5, columnDefinition = "varchar(5)")
    private boolean isAvailable;
    @Column(nullable = false)
    private Integer fuelConsumption;
    @Column(nullable = false)
    private Integer numberOfSeats;

    @OneToOne
    @JoinColumn(name = "carPricingId", referencedColumnName = "id")
    private CarPricing carPricing;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;


    public void removeOrderDetail (OrderDetail orderDetail) {
        this.getOrderDetails().remove(orderDetail);
    }

}
