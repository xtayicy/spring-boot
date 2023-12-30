package harry.spring.boot.mybatis.plus.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "user")
public class User {
	/**
     * 用户编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码（明文）
     *
     * ps：生产环境下，千万不要明文噢
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否删除
     */
    @TableLogic
    private Integer deleted;
    
	public Integer getId() {
		return id;
	}
	public User setId(Integer id) {
		this.id = id;
		
		return this;
	}
	public String getUsername() {
		return username;
	}
	public User setUsername(String username) {
		this.username = username;
		
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		
		return this;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public User setCreateTime(Date createTime) {
		this.createTime = createTime;
		
		return this;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public User setDeleted(Integer deleted) {
		this.deleted = deleted;
		
		return this;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", createTime=" + createTime
				+ ", deleted=" + deleted + "]";
	}
}

