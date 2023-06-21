package modern_kick_eshop.services.impl;

import modern_kick_eshop.entities.dao.Customer;
import modern_kick_eshop.entities.dao.Login;
import modern_kick_eshop.repositories.CustomerRepository;
import modern_kick_eshop.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.util.StringUtils.hasLength;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final CustomerRepository repository;

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return repository.save(customer);
    }

    @Override
    public String loginCustomer(Login login) {
        Optional<Customer> customerOpt = repository.findById(login.getEmail());
        if (!customerOpt.isPresent()){
            return "authenticationError";
        }
        Customer customer = customerOpt.get();
        boolean isPasswordCorrect = passwordEncoder.matches(login.getPassword(), customer.getPassword());
        if (!isPasswordCorrect) {
            return "authenticationError";
        } else {
            return "index";
        }
    }

    private void modifyUpdatedFields(Customer customer, Customer existingCustomer) {
        if (hasLength(customer.getFirst_name())) {
            existingCustomer.setFirst_name(customer.getFirst_name());
        }
        if (hasLength(customer.getLast_name())) {
            existingCustomer.setLast_name(customer.getLast_name());
        }
        if (hasLength(customer.getEmail())) {
            existingCustomer.setEmail(customer.getEmail());
        }
        if (hasLength(customer.getStreet())) {
            existingCustomer.setStreet(customer.getStreet());
        }
        if (hasLength(customer.getStreet_number())) {
            existingCustomer.setStreet(customer.getStreet_number());
        }
        if (hasLength(customer.getCity())) {
            existingCustomer.setCity(customer.getCity());
        }
        if (hasLength(customer.getPostal_code())) {
            existingCustomer.setStreet(customer.getPostal_code());
        }
        if (hasLength(customer.getCountry())) {
            existingCustomer.setCountry(customer.getCountry());
        }
        if (hasLength(customer.getPhone_number())) {
            existingCustomer.setPhone_number(customer.getPhone_number());
        }
        if(hasLength(customer.getPassword())) {
            existingCustomer.setPassword(passwordEncoder.encode(customer.getPassword()));
        }
    }
}
