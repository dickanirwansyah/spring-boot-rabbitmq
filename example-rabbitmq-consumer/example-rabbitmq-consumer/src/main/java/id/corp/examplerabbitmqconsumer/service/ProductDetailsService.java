package id.corp.examplerabbitmqconsumer.service;

import id.corp.examplerabbitmqconsumer.model.Category;
import id.corp.examplerabbitmqconsumer.model.ProductDetails;
import id.corp.examplerabbitmqconsumer.model.Products;
import id.corp.examplerabbitmqconsumer.repository.ProductRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDetailsService {

    @Autowired
    private ProductRepository productRepository;
    private List<Category> categoryList = new ArrayList<>();
    private Category category = new Category();

    //@PostConstruct
    public List<ProductDetails> getProductDetails(){
        List<Products> products = productRepository.findAll();
        List<ProductDetails> productDetails = new ArrayList<>();

        for (int i=0; i < products.size(); i++){
            ProductDetails pd = new ProductDetails();
            pd.setProductId(products.get(i).getId());
            pd.setProductName(products.get(i).getName());
            pd.setCategoryId(products.get(i).getCategoryId());
            for (int ii=0; ii < categoryList.size(); ii++){
                if (categoryList.get(ii).getId().equals(products.get(i).getCategoryId())){
                    pd.setCategoryName(categoryList.get(ii).getName());
                }
            }
            productDetails.add(pd);
        }
        //System.out.println("DATA PRODUCT DETAILS : "+productDetails);
        //System.out.println("FROM CATEGORY BRO : "+categoryList);
        //listenerMessageCategory();
        return productDetails;
    }

    @RabbitListener(queues = "${category.rabbitmq.queue}")
    public void listenerCategoryQueue(String message) {
        System.out.println("CATEGORY : "+message);
        final JSONObject jsonObject = new JSONObject(message);
        final JSONArray jsonArrayData = jsonObject.getJSONArray("data");
        final int n = jsonArrayData.length();
        for (int i=0; i<n; i++){
            final JSONObject objectCategory = jsonArrayData.getJSONObject(i);
            category = new Category();
            category.setId(objectCategory.getString("id"));
            category.setName(objectCategory.getString("name"));
            categoryList.add(category);
            System.out.println(category);
        }
    }
}
