package D288_com.example.D288_Spring.BootStrapData;
import D288_com.example.D288_Spring.dao.*;
import D288_com.example.D288_Spring.entities.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

@Getter
@Setter

public class BootStrapData implements CommandLineRunner {@Autowired CartItemRepository cartItemRepository;
                            @Autowired CustomerRepository customerRepository;
                            @Autowired DivisionRepository divisionRepository;
                            @Autowired ExcursionRepository excursionRepository;

    @Override
    public void run(String... args) throws Exception {
    if (customerRepository.count() == 0) {

        Customer customer1 = new Customer();
        customer1.setFirstName("Arnold");
        customer1.setLastName("Blank");
        customer1.setPhone("888-888-8884");
        customer1.setPostal_code("60014");
        customer1.setDivision(divisionRepository.findAll().get(1));
        customerRepository.save(customer1);


        Customer customer2 = new Customer();
        customer2.setFirstName("Evelyn");
        customer2.setLastName("Blank");
        customer2.setPhone("888-777-8888");
        customer2.setPostal_code("60015");
        customer2.setDivision(divisionRepository.findAll().get(2));
        customerRepository.save(customer2);

        Customer customer3= new Customer();
        customer3.setFirstName("Mitchell");
        customer3.setLastName("Blank");
        customer3.setPhone("888-666-8888");
        customer3.setPostal_code("60016");
        customer3.setDivision(divisionRepository.findAll().get(3));
        customerRepository.save(customer3);


        Customer customer4= new Customer();
        customer4.setFirstName("Jackie");
        customer4.setLastName("Blank");
        customer4.setPhone("888-888-1878");
        customer4.setPostal_code("60017");
        customer4.setDivision(divisionRepository.findAll().get(4));
        customerRepository.save(customer4);

        Customer customer5= new Customer();
        customer5.setFirstName("Shantell");
        customer5.setLastName("Williams");
        customer5.setPhone("888-888-9999");
        customer5.setPostal_code("60018");
        customer5.setDivision(divisionRepository.findAll().get(5));
        customerRepository.save(customer5);

        System.out.println("Sample customers added!");
    }
    else {
        System.out.println("Sample customers already exist!");
    }

}



}
