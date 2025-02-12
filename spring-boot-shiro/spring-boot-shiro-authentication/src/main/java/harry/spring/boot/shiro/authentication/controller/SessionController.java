package harry.spring.boot.shiro.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import harry.spring.boot.shiro.authentication.entity.ResponseBo;
import harry.spring.boot.shiro.authentication.entity.UserOnline;
import harry.spring.boot.shiro.authentication.service.api.SessionService;

@Controller
@RequestMapping("/online")
public class SessionController {
	@Autowired
    SessionService sessionService;
	
	@RequestMapping("/index")
    public String online() {
        return "online";
    }
	
	@ResponseBody
    @RequestMapping("list")
    public List<UserOnline> list() {
        return sessionService.list();
    }
	
	@ResponseBody
    @RequestMapping("forceLogout")
    public ResponseBo forceLogout(String id) {
        try {
            sessionService.forceLogout(id);
            return ResponseBo.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("踢出用户失败");
        }
    }
}
