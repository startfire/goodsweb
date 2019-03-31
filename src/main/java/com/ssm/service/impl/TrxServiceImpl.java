package com.ssm.service.impl;


import com.ssm.dao.ProductMapper;
import com.ssm.dao.TrxMapper;
import com.ssm.model.Product;
import com.ssm.model.User;
import com.ssm.service.TrxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrxServiceImpl implements TrxService {

    @Resource
    private TrxMapper trxMapper;
    @Resource
    private ProductMapper productMapper;

    //获取已购买的商品列表
    @Override
    public List<Product> getBuyList(Integer userId) {
        List<Product> productList = trxMapper.getBuyList(userId);
        return productList;
    }

    //购买购物车里的商品,(待设置事务回滚)
    @Override
    public boolean buy(User user, List<Product> productList, Long buyTime) {
        boolean isBuy = false;

        for (Product product: productList) {
            int buyNum = product.getBuyNum();
            product = productMapper.getProduct(product.getId());

            String buyPrice = product.getPrice();
            product.setBuyNum(buyNum);
            product.setBuyPrice(buyPrice);
            isBuy = trxMapper.buy(user.getId(), product, buyTime);
            if (!isBuy) {
                throw new RuntimeException();
            }
        }
        return isBuy;
    }
}
