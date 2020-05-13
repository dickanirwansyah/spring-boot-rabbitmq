package id.corp.examplerabbitmq.service;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import id.corp.examplerabbitmq.model.Category;
import id.corp.examplerabbitmq.model.ResponseApi;
import id.corp.examplerabbitmq.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private AmqpTemplate rabbitMQTemplate;
	
	@Value("${category.rabbitmq.exchange}")
	private String exchangeCategory;
	
	@Value("${category.rabbitmq.queue}")
	private String queueCategory;
	
	@Value("${category.rabbitmq.routingkey}")
	private String routingkeyCategory;
	
	public List<Category> listCategory(){
		List<Category> listCategory = categoryRepository.findAll();
		//Gson gson = new Gson();
		//String jsonArray = gson.toJson(new ResponseApi(new Date(), listCategory));
		sendMsgCategory(new ResponseApi(new Date(), listCategory));
//		Gson gson = new Gson();
//		sendMsgCategory(gson.toJson(new ResponseApi(new Date(), listCategory)));
		return listCategory;
	}
	
	private void sendMsgCategory(Object msg) {
		rabbitMQTemplate.convertAndSend(exchangeCategory, routingkeyCategory, msg);
		System.out.println("SENDING MESSAGE CATEGORY : "+msg);
	}
}
