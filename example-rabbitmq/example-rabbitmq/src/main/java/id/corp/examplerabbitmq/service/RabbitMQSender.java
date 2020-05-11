package id.corp.examplerabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import id.corp.examplerabbitmq.model.Employee;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${example.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${example.rabbitmq.routingkey}")
	private String routingKey;
	
	public void send(Employee employee) {
		rabbitTemplate.convertAndSend(exchange, routingKey, employee);
		System.out.println("SEND MESSAGE : " + employee);
	}
}
