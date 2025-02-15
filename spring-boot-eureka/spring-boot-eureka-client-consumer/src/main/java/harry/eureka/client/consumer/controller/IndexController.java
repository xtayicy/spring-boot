package harry.eureka.client.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import harry.eureka.client.consumer.feign.IndexFeign;

@RestController
public class IndexController {
	@Autowired
	IndexFeign indexFeign;

    @GetMapping("/info")
    public String getInfo() {
        return indexFeign.info();
    }
}
