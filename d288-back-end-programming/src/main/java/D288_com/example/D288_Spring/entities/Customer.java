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
@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    //annotations

    //id
    public Customer(Division division, String address, String lastName, String firstName,
                    String phone, String postal_code){
        this.division = division;
        this.address = address;
        this.lastName = lastName;
        this.firstName= firstName;
        this.phone = phone;
        this.postal_code = postal_code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private long id;
    //column names
    @Column(name = "address")
    private String address;

    @Column(name = "customer_first_name")
    private String firstName;

    @Column(name = "customer_last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "postal_code")
    private String postal_code;


    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    //Join column / table
    @ManyToOne
    @JoinColumn(name ="division_id", nullable = false)
    private Division division;
    //hashset


    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Cart> carts;


    public void add(Cart cart) {

        if (cart != null) {
            if (carts == null) {
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }

    }

}


