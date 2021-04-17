package com.csw.controller;


import com.alibaba.fastjson.JSON;
import com.csw.entity.CartItem;
import com.csw.entity.OrderVO;
import com.csw.entity.Product_info;
import com.csw.feign.FeignProductTest;
import com.csw.feign.OrderFeign;
import com.csw.utils.Number10;
import com.csw.utils.SerializeUtils;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@RequestMapping("master")
@Controller
public class MasterController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private FeignProductTest feignProductTest;
    @Autowired
    private OrderFeign orderFeign;
    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("master")
    public String chuansong(String id) {
        System.out.println("传过来id}" + id);
        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
        Product_info product = feignProductTest.queryProductByID(id);
        CartItem cartItem0;
        try {
            cartItem0 = (CartItem) SerializeUtils.serializeToObject((String) Objects.requireNonNull(stringObjectObjectHashOperations.get("cart", id)));
            assert cartItem0 != null;
            cartItem0.setProductQuantity(cartItem0.getProductQuantity() + 1);
            stringObjectObjectHashOperations.put("cart", id, Objects.requireNonNull(SerializeUtils.serialize(cartItem0)));
        } catch (Exception e) {
            CartItem cartItem = new CartItem(id, product.getProdcut_name(), product.getProduct_price(), product.getProduct_description(), product.getProduct_icon(), 1);
            stringObjectObjectHashOperations.put("cart", id, Objects.requireNonNull(SerializeUtils.serialize(cartItem)));
        }
        return "cart";
    }

    @RequestMapping("queryAll")
    @ResponseBody
    public List<CartItem> queryAll() {
        List<CartItem> cartItems = new ArrayList<>();
        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
        Map<Object, Object> cart = stringObjectObjectHashOperations.entries("cart");
        for (Object key : cart.keySet()) {
            cartItems.add((CartItem) SerializeUtils.serializeToObject((String) cart.get(key)));
        }
        for (CartItem cartItem : cartItems) {
            System.out.println("cartItem]" + cartItem);
        }
        return cartItems;
    }

    @RequestMapping("createOrder")
    @ResponseBody
    // public Map createOrder() {
    public void createOrder() {
        List<CartItem> cartItems = new ArrayList<>();
        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
        Map<Object, Object> cart = stringObjectObjectHashOperations.entries("cart");
        for (Object key : cart.keySet()) {
            cartItems.add((CartItem) SerializeUtils.serializeToObject((String) cart.get(key)));
        }
        for (CartItem cartItem : cartItems) {
            System.out.println("cartItem]" + cartItem);
        }
        OrderVO orderVO = new OrderVO();
        orderVO.setAddress("洛阳");
        orderVO.setName("Rxx");
        orderVO.setOpenid(UUID.randomUUID().toString());
        orderVO.setPhone(1 + Number10.getNum());

        orderVO.setCartItems(cartItems);
        ActiveMQQueue springbootQueue = new ActiveMQQueue("SpringbootQUEUE");
        jmsTemplate.convertAndSend(springbootQueue, JSON.toJSONString(orderVO));

    }
}
