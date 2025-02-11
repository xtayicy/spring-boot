package harry.spring.boot.aop.annotation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import harry.spring.boot.aop.annotation.dao.api.SysLogDao;
import harry.spring.boot.aop.annotation.entity.SysLog;

@Repository("sysLogDao")
public class SysLogDaoImp implements SysLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveSysLog(SysLog syslog) {
		StringBuffer sql = new StringBuffer("insert into sys_log ");
        sql.append("(username,operation,time,method,params,ip,create_time) ");
        sql.append("values(:username,:operation,:time,:method,:params,:ip,:createTime)");
        
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        namedParameterJdbcTemplate.update(sql.toString(), new BeanPropertySqlParameterSource(syslog));
	}

}
