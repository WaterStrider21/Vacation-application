package D288_com.example.D288_Spring.entities;
//import
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


//annotations
@Entity
@Table(name = "cart_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CartItem {
    //annotations

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //column names
       /*@Column( name = "", nullable)
    @annotation --if needed
    private datatype name;
    */
    @Column(name = "cart_item_id", nullable = false)
    private long id;

    @Column(name = "create_date", nullable = true)
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update", nullable = true)
    @UpdateTimestamp
    private Date last_update;


    //Join column / table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name= "vacation_id", nullable = false)
    private Vacation vacation;
    public void setCarts(Cart carts) {}

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
    private Set<Excursion> excursions = new HashSet<>();

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }
}
