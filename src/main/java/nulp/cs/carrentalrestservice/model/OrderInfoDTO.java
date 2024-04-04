package nulp.cs.carrentalrestservice.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class OrderInfoDTO {
    private  long id;
    private CarDTO car;
    private int numberOfDays;
    private LocalDate pickUpDate;
    private LocalDate dropOffDate;
    private String pickUpLocation;
    private String dropOffLocation;
    private double totalPrice;
}