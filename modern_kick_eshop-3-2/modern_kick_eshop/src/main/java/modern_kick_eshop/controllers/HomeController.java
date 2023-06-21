package modern_kick_eshop.controllers;

import modern_kick_eshop.entities.dao.Customer;
import modern_kick_eshop.entities.dao.Login;
import modern_kick_eshop.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private ShoppingCartRepository repo;

    @GetMapping("/")
    public String showHome(Model model) {
        repo.truncateTable();
        return "index";
    }

    @GetMapping("/shop")
    public String showShop() {
        return "shop";
    }

    @GetMapping("/faq")
    public String showFaq() {
        return "faq";
    }

    @GetMapping("/team")
    public String showOurTeam() {
        return "team";
    }

    @GetMapping("/blog")
    public String showBlog() {
        return "blog";
    }

    @GetMapping("/newDrops")
    public String showNewDrops() {
        return "newDrops";
    }

    @GetMapping("/register")
    public String createCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "register";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        Login login = new Login();
        model.addAttribute("login", login);
        return "login";
    }

    @GetMapping("/authenticationError")
    public String showAuthenticationError(Model model){
        Login login = new Login();
        model.addAttribute("login", login);
        return "authenticationError";
    }

}
