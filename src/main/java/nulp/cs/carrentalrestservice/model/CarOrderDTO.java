package nulp.cs.carrentalrestservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarOrderDTO {
    private long id;
    private OrderDetailDTO order;
    private CustomerDTO user;
    private AdminDTO admin;
    private Status status;
    private OrderDetailDTO orderDetail;
    private String adminComment;
}
