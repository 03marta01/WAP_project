package modern_kick_eshop.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import modern_kick_eshop.entities.dao.ShoppingCart;
import modern_kick_eshop.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import modern_kick_eshop.entities.dao.Product;
import modern_kick_eshop.services.ProductService;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping ("")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    @Autowired
    private final ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/leggings")
    public String getAllLeggings(Model model) {
        List<Product> products = productService.getProductsByCategory("leggings");
        model.addAttribute("products", products);
        return "leggings";
    }

    @GetMapping("/tops")
    public String getAllTops(Model model) {
        List<Product> products = productService.getProductsByCategory("top");
        model.addAttribute("products", products);
        return "tops";
    }

    @GetMapping("/accessories")
    public String getAllAccessories(Model model) {
        List<Product> products = productService.getProductsByCategory("accessories");
        model.addAttribute("products", products);
        return "accesories";
    }

    @GetMapping("/shoppingCart")
    public String getShoppingCart(Model model) {
        HashMap<Long, Integer> itemsId = new HashMap<>();
        List<ShoppingCart> shoppingCartData = shoppingCartService.getAllItemsInShoppingCart();
        for(ShoppingCart item : shoppingCartData){
            itemsId.put(item.getProduct_id(), item.getQuantity());
        }
        List<Product> products = new LinkedList<>();

        HashMap<Long, Double> sumPrice = new HashMap<>();
        for(ShoppingCart item : shoppingCartData){
            sumPrice.put(item.getProduct_id(), item.getQuantity()*productService.getProductById(item.getProduct_id()).getPrice());
        }

        Double priceTotal = (double) 0;
        for(Long key : itemsId.keySet()) {
            products.add(productService.getProductById(key));
            priceTotal += productService.getProductById(key).getPrice()*itemsId.get(key);
        }

        model.addAttribute("items", products);
        model.addAttribute("itemsQty", itemsId);
        model.addAttribute("priceTotal", priceTotal);
        model.addAttribute("price", sumPrice);
        return "shoppingCart";}

    @PostMapping("/addToCart")
    public String addProductToCart(@ModelAttribute("id") Long id, @ModelAttribute("quantity") int qty) {
        Product product = productService.getProductById(id);
        shoppingCartService.addOrderItem(product, qty);
        return "redirect:/shoppingCart";
    }
}
