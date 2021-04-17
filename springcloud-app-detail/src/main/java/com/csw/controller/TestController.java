package com.csw.controller;

import com.csw.dao.ItemDao;
import com.csw.dao.OrderDao;
import com.csw.entity.CartItem;
import com.csw.entity.OrderVO;
import com.csw.entity.Order_detail;
import com.csw.entity.Order_master;
import com.csw.feign.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.ObjectMessage;
import java.util.*;

@RestController
@RequestMapping("detail")
public class TestController {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductFeign productFeign;

    @RequestMapping("createOrder")
    @ResponseBody
    @JmsListener(destination = "SpringbootQUEUE")
    // public Map createOrder(@RequestBody OrderVO orderVO) {
    public Map<String,Object> createOrder(ObjectMessage msg) {
        OrderVO orderVO = (OrderVO) msg;

        System.out.println("成功进入orderVO]" + orderVO);
        System.out.println("name]" + orderVO.getName());
        HashMap<String,Object> hashMap = new HashMap<>();
        String orderId = UUID.randomUUID().toString();
        List<CartItem> cartItems = orderVO.getCartItems();
        double sum = 0.0;
        for (CartItem cartItem : cartItems) {
            sum += cartItem.getProductPrice() * cartItem.getProductQuantity();
        }
        Order_master order_master = new Order_master(orderId, orderVO.getName(), orderVO.getPhone(), orderVO.getAddress(), orderVO.getOpenid(), sum, "1", "1", new Date(), new Date());
        orderDao.insertSelective(order_master);
        for (CartItem cartItem : cartItems) {
            String itemId = UUID.randomUUID().toString();
            Order_detail item = new Order_detail(itemId, orderId, cartItem.getProductId(), cartItem.getProductName(), cartItem.getProductPrice(), cartItem.getProductIcon(), cartItem.getProductQuantity(), new Date(), new Date());
            itemDao.insertSelective(item);
            //String sale = productFeign.sale(cartItem.getProductId(), cartItem.getProductQuantity());
        }
        hashMap.put("msg", "成功");
        hashMap.put("code", "0");
        hashMap.put("orderId", orderId);

        return hashMap;
    }
}
