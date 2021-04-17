package com.csw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class Product_info implements Serializable {
    @Id
    private String product_id;   //    `product_id` varchar(99) NOT NULL,
    private String prodcut_name; //  `prodcut_name` varchar(99) DEFAULT NULL COMMENT '商品名称',
    private Double product_price;// `product_price` double(99,2) DEFAULT NULL COMMENT '单价',
    private Integer product_stock;    // `product_stock` int(99) DEFAULT NULL COMMENT '库存',
    private String product_description;     //  `product_description` varchar(99) DEFAULT NULL COMMENT '描述',
    private String product_icon;     //  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
    private Integer category_type;    //  `category_type` int(99) DEFAULT NULL COMMENT '类目',
    private Date create_time;   //  `create_time` date DEFAULT NULL,
    private Integer sales;    //  `sales` int(99) DEFAULT NULL,
    private Date update_time;    //  `update_time` date DEFAULT NULL COMMENT '修改时间',
}
