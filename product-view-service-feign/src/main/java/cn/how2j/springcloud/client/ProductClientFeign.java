package cn.how2j.springcloud.client;

import cn.how2j.springcloud.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 功能说明
 *Feign 客户端， 通过 注解方式 访问 访问PRODUCT-DATA-SERVICE服务的 products路径， product-data-service 既不是域名也不是ip地址，而是 数据服务在 eureka 注册中心的名称。
 * Feign 是对 Ribbon 的封装，而且也是主要方式
 * 注意，这里只是指定了要访问的 微服务名称（注册到Eureka中的名称），但是并没有指定端口号到底是 8001, 还是 8002.
 * @author heyueyue
 * @date 2019-11-09 16:37:12
 */
@FeignClient(value="PRODUCT-DATA-SERVICE")//相当于eureka中的注册的ip
public interface ProductClientFeign {
    //以get方式去处理请求
    @GetMapping("/products")
    public List<Product> listProdcuts();
}
