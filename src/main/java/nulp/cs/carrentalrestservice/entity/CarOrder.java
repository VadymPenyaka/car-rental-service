package nulp.cs.carrentalrestservice.entity;

import jakarta.persistence.*;
import lombok.*;
import nulp.cs.carrentalrestservice.model.Status;

@Entity(name = "car_orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarOrder {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @OneToOne()
    @JoinColumn(name = "order_detail_id", referencedColumnName = "id")
    private OrderDetail orderDetail;
    @ManyToOne
    @JoinColumn(name = "adminId", nullable = false)
    private Admin admin;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    @Column(columnDefinition = "varchar(50)")
    private String adminComment;

//    public void setOrderDetail(OrderDetail orderDetail) {
//        this.orderDetail = orderDetail;
//        orderDetail.setCarOrder(this);
//    }
}

