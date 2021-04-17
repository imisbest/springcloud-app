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
@Data
@Accessors(chain = true)
public class Product_category implements Serializable {
    @Id
    private String category_id;   //`category_id` varchar(99) NOT NULL,
    private String category_name;   //  `category_name` varchar(99) DEFAULT NULL COMMENT '类目名称',
    private Integer category_type;  //            `category_type` int(99) DEFAULT NULL COMMENT '类目编号',
    private Date create_time;     //            `create_time` date DEFAULT NULL COMMENT '创建时间',
    private Date update_time;    //            `update_time` date DEFAULT NULL COMMENT '修改时间',
}
