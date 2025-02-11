package harry.spring.boot.aop.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import harry.spring.boot.aop.annotation.dao.api.SysLogDao;
import harry.spring.boot.aop.annotation.entity.SysLog;
import harry.spring.boot.aop.annotation.service.api.SysLogService;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao;

	@Override
	public void recordUserOperation(SysLog sysLog) {
		sysLogDao.saveSysLog(sysLog);
	}

}
