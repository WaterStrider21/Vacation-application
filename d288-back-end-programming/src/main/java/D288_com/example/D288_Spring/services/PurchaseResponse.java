package D288_com.example.D288_Spring.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseResponse {
    private String orderTrackingNumber;

    //order tracking number
    public PurchaseResponse(String orderTrackingNumber) {

        this.orderTrackingNumber = orderTrackingNumber;
    }

}