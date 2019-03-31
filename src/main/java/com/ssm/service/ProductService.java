package com.ssm.service;



import com.ssm.model.Product;
import com.ssm.model.User;

import java.util.List;

public interface ProductService {
    List<Product> getProductList(User user, String type);

    Product getProduct(User user, Integer productId);

    void publicProduct(Product product);

    int getCount();

    boolean updateProduct(Product product);

    boolean deleteProdct(Integer id);
}
