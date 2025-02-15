package harry.eureka.client.provider.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DiscoveryClient discoveryClient;
    
    @Autowired
    private Environment environment;

    @GetMapping("/info")
    public String info() {
    	String serviceId = environment.getProperty("spring.application.name"); // 服务名称
    	// 获取当前服务的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId); // 替换为你的服务名称
        if (instances.isEmpty()) {
            return "No instances found";
        }

        // 获取第一个实例
        ServiceInstance instance = instances.get(0);
        String info = "host: " + instance.getHost() + ", service_id: " + instance.getServiceId();
        return info;
    }
}
