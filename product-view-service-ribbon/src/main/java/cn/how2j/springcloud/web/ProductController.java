package cn.how2j.springcloud.web;

import cn.how2j.springcloud.pojo.Product;
import cn.how2j.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 功能说明
 *
 * @author heyueyue
 * @date 2019-11-08 14:56:37
 * 控制器，把数据取出来放在 product.html 中
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object products(Model m) {
        List<Product> ps = productService.listProducts();
        m.addAttribute("ps", ps);
        System.out.println("控制层的ps为："+ps);
        return "products";
    }
}
