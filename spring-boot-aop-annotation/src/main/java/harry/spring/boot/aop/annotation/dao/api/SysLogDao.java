package harry.spring.boot.aop.annotation.dao.api;

import harry.spring.boot.aop.annotation.entity.SysLog;

public interface SysLogDao {
	void saveSysLog(SysLog syslog);
}
