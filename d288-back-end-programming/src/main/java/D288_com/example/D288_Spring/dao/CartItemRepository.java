package D288_com.example.D288_Spring.dao;
//import
import D288_com.example.D288_Spring.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//CrossOrigin & Repository resource
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "cartItems", path = "cartItems")

public interface CartItemRepository extends JpaRepository<CartItem, Long>{
}
