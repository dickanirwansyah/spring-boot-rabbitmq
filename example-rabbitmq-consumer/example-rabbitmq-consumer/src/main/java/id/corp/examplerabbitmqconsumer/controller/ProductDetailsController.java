package id.corp.examplerabbitmqconsumer.controller;

import id.corp.examplerabbitmqconsumer.model.ProductDetails;
import id.corp.examplerabbitmqconsumer.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product-details")
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsService;

    @GetMapping
    public List<ProductDetails> getProductDetails(){
        List<ProductDetails> productDetailsList = productDetailsService.getProductDetails();
        return productDetailsList;
    }
}
