package D288_com.example.D288_Spring.entities;
//import
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Entity
@Table(name = "countries")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Country {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long id;
    //column names
    @Column(name = "country", nullable = true)
    private String country_name;

    @Column(name = "create_date", nullable = true)
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update", nullable = true)
    @UpdateTimestamp
    private Date last_update;

    }



