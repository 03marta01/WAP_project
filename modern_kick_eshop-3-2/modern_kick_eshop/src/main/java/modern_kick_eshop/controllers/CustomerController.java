package modern_kick_eshop.controllers;

import modern_kick_eshop.entities.dao.Customer;
import modern_kick_eshop.entities.dao.Login;
import modern_kick_eshop.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "index";
    }

    @PostMapping("/loginUser")
    public String login(@ModelAttribute("login") Login login) {
        return customerService.loginCustomer(login);
    }
}