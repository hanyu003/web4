package com.curry.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
@Data
public class Shop {
    private Integer id;
    private String name;
    private String type;
    private String brand;
    private BigDecimal price;
    private Integer is_del;
}
