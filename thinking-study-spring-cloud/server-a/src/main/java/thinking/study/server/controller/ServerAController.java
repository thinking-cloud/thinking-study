package thinking.study.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerAController {
	
	@RequestMapping("/info")
	public String info() {
		return "server A";
	}
}
