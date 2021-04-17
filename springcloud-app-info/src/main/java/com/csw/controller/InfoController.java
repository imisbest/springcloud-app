package com.csw.controller;

import com.csw.dao.IntoDao;
import com.csw.entity.Product_info;
import com.csw.feign.FeignProductTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("info")
@CrossOrigin
public class InfoController {
    @Autowired
    private IntoDao intoDao;
    @Autowired
    private FeignProductTest feignProductTest;

    @RequestMapping("queryall")
    public List<Product_info> queryall() {
        List<Product_info> product_infos = intoDao.selectAll();
        for (Product_info info : product_infos) {
            System.out.println("info]" + info);
        }
        return product_infos;
    }

    @RequestMapping("chuansong")
    public String chuansong(String id) {
        System.out.println("id]" + id);
        return feignProductTest.chuansong(id);
    }

    @RequestMapping("queryProductByID")
    public Product_info queryProductByID(String id) {
        return intoDao.selectByPrimaryKey(id);
    }

    @RequestMapping("sale")
    public String sale(String id, Integer count) {
        System.out.println("id]" + id);
        System.out.println("count]" + count);
        Product_info product = intoDao.selectByPrimaryKey(id);
        System.out.println("products]" + product);
        product.setProduct_stock(product.getProduct_stock() - count);
        product.setSales(product.getSales() + count);
        intoDao.updateByPrimaryKeySelective(product);
        return "success";
    }

}
