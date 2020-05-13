package id.corp.examplerabbitmqconsumer.consumer;

import java.io.StringReader;

//import org.json.JSONObject;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import id.corp.examplerabbitmqconsumer.model.Employee;

@Component
public class Consumer {



//	@RabbitListener(queues = "${jsa.rabbitmq.queue}")
//	public void receivedMessage(String message) {
//		System.out.println("Received Message : "+message);
//	}
	
//	@RabbitListener(queues = "${example.rabbitmq.queue}")
//	public void listenerExampleQueue(String message) throws Exception{
//		//System.out.println(message);
//		Employee employee = new Employee();
//		final JSONObject jsonObject = new JSONObject(message);
//		//System.out.println("employee name : " + jsonObject.getString("empName"));
//		//System.out.println("employee id " + jsonObject.getString("empId"));
//		employee.setEmpId(jsonObject.getString("empId"));
//		employee.setEmpName(jsonObject.getString("empName"));
//		System.out.println(employee);
//	}
}
