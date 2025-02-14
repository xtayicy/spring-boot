package harry.spring.security.child.entity;

import java.time.LocalDateTime;

public class SmsCode {
	private String code;
    private LocalDateTime expireTime;
    
    public boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }
    
	public SmsCode(String code, int expireTime) {
		super();
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
	}


	public SmsCode() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDateTime getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}
	@Override
	public String toString() {
		return "SmsCode [code=" + code + ", expireTime=" + expireTime + "]";
	}
}
