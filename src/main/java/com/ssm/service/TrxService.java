package com.ssm.service;



import com.ssm.model.Product;
import com.ssm.model.User;

import java.util.List;

public interface TrxService {

    List<Product> getBuyList(Integer userId);

    boolean buy(User user, List<Product> productList, Long buyTime);
}
