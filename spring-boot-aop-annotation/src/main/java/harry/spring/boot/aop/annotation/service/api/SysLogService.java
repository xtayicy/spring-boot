package harry.spring.boot.aop.annotation.service.api;

import harry.spring.boot.aop.annotation.entity.SysLog;

public interface SysLogService {
	public void recordUserOperation(SysLog sysLog);
}
