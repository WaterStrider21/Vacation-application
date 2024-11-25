package D288_com.example.D288_Spring.services;

import D288_com.example.D288_Spring.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

//annotations
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    //cart and set of cart items
    private Customer customer;
    private Cart cart;
    private StatusType status;
    private Set<CartItem> cartItems;

}
