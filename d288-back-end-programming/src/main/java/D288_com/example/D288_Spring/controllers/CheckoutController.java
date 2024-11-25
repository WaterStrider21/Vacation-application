package D288_com.example.D288_Spring.controllers;

import D288_com.example.D288_Spring.services.CheckoutService;
import D288_com.example.D288_Spring.services.Purchase;
import D288_com.example.D288_Spring.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }
    @PostMapping("/purchase")
    public PurchaseResponse checkout (@RequestBody Purchase purchase) {
    PurchaseResponse purchaseResponse = checkoutService.checkout(purchase);
    return purchaseResponse;
    }
    }


