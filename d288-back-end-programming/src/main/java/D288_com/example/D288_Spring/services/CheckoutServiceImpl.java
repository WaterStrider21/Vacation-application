package D288_com.example.D288_Spring.services;

import D288_com.example.D288_Spring.dao.CartItemRepository;
import D288_com.example.D288_Spring.dao.CartRepository;
import D288_com.example.D288_Spring.dao.CustomerRepository;
import D288_com.example.D288_Spring.entities.Cart;
import D288_com.example.D288_Spring.entities.CartItem;
import D288_com.example.D288_Spring.entities.Customer;
import D288_com.example.D288_Spring.entities.StatusType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@Getter
@Setter
public class CheckoutServiceImpl implements CheckoutService {
    //remove try and catch - add if statements to check there is 1 party and the cart isn't empty
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private CustomerRepository customerRepository;
    //get cart info and customer info
    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository, CustomerRepository customerRepository){
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }
    //generate unique order tracking number

    @Override
    @Transactional

    public PurchaseResponse checkout (Purchase purchase){


            //check cart info and order tracking number
            Cart cart = purchase.getCart();
            Set<CartItem> cartItems = purchase.getCartItems();
        String orderTrackingNumber = createOrderTrackingNumber();
        //print

        if(cartItems.isEmpty()){
            System.out.println("Cart cannot be empty!");
        return new PurchaseResponse("No purchase was made!");
        }
        if(cart.getParty_size() < 1){
            System.out.println("Party size must be at least 1!");
            return new PurchaseResponse("No purchase was made!");

        }

        cartItems.forEach(item -> cart.add(item));
            //set status
            cart.setStatus(StatusType.ordered);
            //get customer
            Customer customer = purchase.getCustomer();
            cart.setCustomer(customer);


            cart.setOrderTrackingNumber(orderTrackingNumber);

            //save cart to database
            cartRepository.save(cart);
            //customer.add(cart);

            //return order tracking number



        return new PurchaseResponse(orderTrackingNumber);

    }
    private String createOrderTrackingNumber(){
        return UUID.randomUUID().toString();

    }

    }

