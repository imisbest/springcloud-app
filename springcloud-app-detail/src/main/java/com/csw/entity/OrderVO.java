package com.csw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by HIAPAD on 2019/12/13.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderVO {
    private String name;
    private String phone;
    private String address;
    private String openid;
    private List<CartItem> cartItems;
}
