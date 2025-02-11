package harry.spring.boot.aop.annotation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import harry.spring.boot.aop.annotation.annotation.Log;

@RestController
public class IndexController {
	@Log("执行方法一")
    @GetMapping("/one")
    public void methodOne(String name) { }
    
    @Log("执行方法二")
    @GetMapping("/two")
    public void methodTwo() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    @Log("执行方法三")
    @GetMapping("/three")
    public void methodThree(String name, String age) { }
}
