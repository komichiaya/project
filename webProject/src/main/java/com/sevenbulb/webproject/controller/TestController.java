package com.sevenbulb.webproject.controller;

import com.sevenbulb.webproject.entity.SaleGoods;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @RequestMapping("/typeConversionTest")
    public void typeConversionTest(String goodsName, float weight, int type, boolean onSale) {
        System.out.println("goodsName:" + goodsName);
        System.out.println("weight:" + weight);
        System.out.println("type:" + type);
        System.out.println("onSale:" + onSale);
    }

    @RequestMapping(value = "/httpMessageConverterTest", method = RequestMethod.POST)
    public SaleGoods httpMessageConverterTest(@RequestBody SaleGoods saleGoods) {
        System.out.println(saleGoods.toString());
        saleGoods.setType(saleGoods.getType() + 1);
        saleGoods.setGoodsName("商品名:" + saleGoods.getGoodsName());
        return saleGoods;
    }

    @RequestMapping("/test/type/conversion")
    public void typeConversion(String goodsName, float weight, int type, Boolean onSale) {
        System.out.println("goodsName:" + goodsName);
        System.out.println("weight:" + weight);
        System.out.println("type:" + type);
        System.out.println("onSale:" + onSale);
    }

}

