package harry.eureka.client.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name = "Server-Provider")
public interface IndexFeign {
	@RequestMapping(value = "/info")
    public String info();
}
