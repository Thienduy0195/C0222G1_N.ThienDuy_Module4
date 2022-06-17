package com.products.repository;

import com.products.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "SamSung Galaxy Fold 3", 5000, "Luxury product", "SAMSUNG"));
        productMap.put(2, new Product(2, "Apple Iphone 13 Pro", 6000, "Premium product", "APPLE"));
        productMap.put(3, new Product(3, "SamSung Note 9", 4000, "Good product", "SAMSUNG"));
        productMap.put(4, new Product(4, "Oppo Neo 5", 7500, "Normal product", "OPPO"));
        productMap.put(5, new Product(5, "Apple Iphone Xs", 3300, "Good product", "APPLE"));
        productMap.put(6, new Product(6, "Apple Ipad Air", 10000, "Luxury product", "APPLE"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getProductId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Product item: this.findAll()) {
            if (item.getProductName().toLowerCase().contains(name.toLowerCase())){
                searchList.add(item);
            }
        }
        return searchList;
    }
}
