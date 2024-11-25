package D288_com.example.D288_Spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
//annotations
@Entity
@Table(name = "divisions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Division {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id", nullable = false)
    private Long id;
    //column names
    //private Long country_id;

    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;


    //Join column / table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;
    //hashset
    @OneToMany(cascade =CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customer = new HashSet<>();

   @Column(name= "Country_ID")
    private long country_id;





        public Division(String url) {
            String division_id = url.substring(url.lastIndexOf('/') + 1);
            this.id = Long.parseLong(division_id);
        }


    }


