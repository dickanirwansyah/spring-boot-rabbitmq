package id.corp.examplerabbitmqproducer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.corp.examplerabbitmqproducer.producer.Producers;

@RestController
public class WebController {

	@Autowired
	private Producers producers;
	
	@GetMapping(value = "/send")
	public String sendMsg(@RequestParam("msg")String msg) {
		producers.produceMsg(msg);
		return "Done";
	}
}
