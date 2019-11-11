package cn.how2j.springcloud.service;

import cn.how2j.springcloud.client.ProductClientRibbon;
import cn.how2j.springcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能说明
 *
 * @author heyueyue
 * @date 2019-11-08 14:55:40
 * 服务类，数据从 ProductClientRibbon 中获取
 */
@Service
public class ProductService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public List<Product> listProducts(){
       // System.out.println("测试"+productClientRibbon.listProdcuts());
        return productClientRibbon.listProdcuts();

    }
}
