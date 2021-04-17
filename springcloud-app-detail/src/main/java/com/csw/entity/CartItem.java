package com.csw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by HIAPAD on 2019/12/13.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItem implements Serializable {
    @Id
    private String productId;
    private String productName;
    private Double productPrice;
    private String productDescription;
    private String productIcon;
    private Integer productQuantity;
}
