package harry.spring.boot.shiro.authentication.service.api;

import java.util.List;

import harry.spring.boot.shiro.authentication.entity.UserOnline;

public interface SessionService {
	List<UserOnline> list();
    boolean forceLogout(String sessionId);
}
