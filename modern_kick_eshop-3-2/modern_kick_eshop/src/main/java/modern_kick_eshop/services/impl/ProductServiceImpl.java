package modern_kick_eshop.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import modern_kick_eshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import modern_kick_eshop.entities.dao.Product;
import modern_kick_eshop.services.ProductService;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public Product getProductById(long productId) {
        List<Product> all = repository.findAll();
        Product productById = new Product();
        for(Product product : all){
            if(product.getProduct_id().equals(productId)){
              productById = product;
            };
        }
        return productById;
    }

    @Override
    public List<Product> getProductsByCategory(String category){
        List<Product> all = repository.findAll();
        List<Product> categoryList = new ArrayList<>();
        for(Product product : all){
            if(product.getCategory().equals(category)){
                categoryList.add(product);
            };
        }
        return categoryList;
    }
}
