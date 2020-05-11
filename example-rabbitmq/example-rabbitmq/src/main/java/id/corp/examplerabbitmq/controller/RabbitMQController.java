package id.corp.examplerabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.corp.examplerabbitmq.model.Employee;
import id.corp.examplerabbitmq.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/send")
public class RabbitMQController {

	@Autowired
	private RabbitMQSender sender;
	
	@GetMapping
	public String producers(@RequestParam("empName")String empName, 
			@RequestParam("empId")String empId) {
		
		Employee employee = new Employee();
		employee.setEmpName(empName);
		employee.setEmpId(empId);
		sender.send(employee);
		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}
}
