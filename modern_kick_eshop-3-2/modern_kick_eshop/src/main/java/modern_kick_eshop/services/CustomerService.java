package modern_kick_eshop.services;

import modern_kick_eshop.entities.dao.Customer;
import modern_kick_eshop.entities.dao.Login;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    //Customer updateCustomer(Customer customer);

    String loginCustomer(Login login);
}
