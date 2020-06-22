package thinking.study.server.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
//注意 DiscoveryClient所在的包
import org.springframework.cloud.client.discovery.DiscoveryClient; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServerBController {
	// 这里使用默认的restTemplate，仅作为demo。实际生产环境中要进行详细配置
	private RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/info")
	public String info() {
		List<ServiceInstance> instances = discoveryClient.getInstances("server-A");
		ServiceInstance serviceInstance = instances.get(0);
		String host = serviceInstance.getHost();
		int port = serviceInstance.getPort();
		String result = restTemplate.getForObject("http://"+host+":"+port+"/info", String.class);
		return "server b --> a result: "+ result;
	}
}
