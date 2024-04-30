package nulp.cs.carrentalrestservice.repository;

import nulp.cs.carrentalrestservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
