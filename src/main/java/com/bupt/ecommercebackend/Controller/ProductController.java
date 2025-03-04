package com.bupt.ecommercebackend.Controller;

import com.bupt.ecommercebackend.Service.ProductService;
import com.bupt.ecommercebackend.Service.UserService;
import com.bupt.ecommercebackend.Utils.JwtUtil;
import com.bupt.ecommercebackend.Utils.UserContext;
import com.bupt.ecommercebackend.pojo.Merchant;
import com.bupt.ecommercebackend.pojo.Product;
import com.bupt.ecommercebackend.pojo.Result;
import com.bupt.ecommercebackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    // 商家添加商品
    @PostMapping("/add")
    public Result addProduct(@RequestHeader("Authorization") String token,
                             @RequestParam String name,
                             @RequestParam String description,
                             @RequestParam BigDecimal price,
                             @RequestParam Integer stockQuantity,
                             @RequestParam String category,
                             @RequestParam(required = false) String keyWord,
                             @RequestParam(required = false) BigDecimal discount) {

        //从token里解析用户名
        User u = UserContext.getUserFromToken(token);

        if(u.getType() != 1){
            return Result.error("只有商家可以添加商品");
        }

        // 创建一个新的 Product 对象
        Product product = new Product(u.getId(), name, description, price, stockQuantity, category);
//        Product product = new Product();
//        product.setMerchantUserId(u.getId());
//        product.setName(name);
//        product.setDescription(description);
//        product.setPrice(price);
//        product.setStockQuantity(stockQuantity);
//        product.setCategory(category);
        if(discount != null){
            product.setDiscount(discount);
        }else{
            product.setDiscount(BigDecimal.ONE);
        }

        System.out.println("接收的商品" + product);

        Result r = productService.addProduct(product, keyWord);
        return r;
    }

    @PostMapping("/delete")
    public Result deleteProduct(@RequestHeader(name = "Authorization") String token,
                                    @RequestParam Long productId) {
        Result r = productService.deleteProduct(token, productId);
        return r;
    }

}
