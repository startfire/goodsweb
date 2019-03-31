package com.ssm.controller;


import com.ssm.model.Product;
import com.ssm.model.User;
import com.ssm.service.TrxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TrxController {

    @Resource
    private TrxService trxService;

    //账务页
    @RequestMapping("/account")
    public String getAccount(@SessionAttribute(name = "user", required = false) User user,
                             Model model) {
        if (user == null || user.getUserType() == 1){
            return "redirect:/";
        }
        List<Product> buyList = trxService.getBuyList(user.getId());
        model.addAttribute("buyList", buyList);
        return "account";
    }

    //购物车
    @RequestMapping("/settleAccount")
    public String settleAccount(@SessionAttribute(name = "user") User user){
        if (user == null || user.getUserType() == 1){
            return "redirect:/";
        }
        return "settleAccount";
    }
}
