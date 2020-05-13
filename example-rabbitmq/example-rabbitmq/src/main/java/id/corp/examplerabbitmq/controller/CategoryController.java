package id.corp.examplerabbitmq.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.corp.examplerabbitmq.model.Category;
import id.corp.examplerabbitmq.model.ResponseApi;
import id.corp.examplerabbitmq.service.CategoryService;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/list-category")
	public ResponseEntity<ResponseApi> listCategory(){
		List<Category> listCategory = categoryService.listCategory();
		ResponseApi api = new ResponseApi();
		api.setData(listCategory);
		api.setTimestamp(new Date());
		return new ResponseEntity<ResponseApi>(api, HttpStatus.OK);
	}
}
