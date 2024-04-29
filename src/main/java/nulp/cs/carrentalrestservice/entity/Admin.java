package nulp.cs.carrentalrestservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 50)
    private String password;
    @OneToMany(mappedBy = "admin", cascade =  CascadeType.ALL)
    private Set<CarOrder> carOrders=new HashSet<>();
    
}
