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
public class Order_master implements Serializable {
    @Id
    private String order_id;    //    `order_id` varchar(99) NOT NULL,
    private String buyer_name;  //  `buyer_name` varchar(99) DEFAULT NULL COMMENT '买家姓名',
    private String buyer_iphone;    //            `buyer_iphone` varchar(99) DEFAULT NULL COMMENT '买家电话',
    private String buyer_address;    //            `buyer_address` varchar(128) DEFAULT NULL COMMENT '买家地址',
    private String buyer_open;    //            `buyer_openid` varchar(99) DEFAULT NULL COMMENT '买家微信',
    private Double order_amount;    //            `order_amount` double(99,2) DEFAULT NULL COMMENT '订单总金额',
    private String order_status;     //            `order_status` varchar(99) DEFAULT '0' COMMENT '订单状态，0代表默认新订单',
    private String pay_stayus;     //            `pay_stayus` varchar(99) DEFAULT '0' COMMENT '支付状态 0代表默认值未支付',
    private Date create_time;    //            `create_time` date DEFAULT NULL COMMENT '创建时间',
    private Date update_time;    //            `update_time` date DEFAULT NULL COMMENT '修改时间',
}
