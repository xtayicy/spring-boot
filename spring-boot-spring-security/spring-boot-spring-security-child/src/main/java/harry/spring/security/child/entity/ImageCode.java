package harry.spring.security.child.entity;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode {
	private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;
    
	public ImageCode(BufferedImage image, String code, int expireTime) {
		super();
		this.image = image;
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
	}

	public ImageCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
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
		return "ImageCode [code=" + code + ", expireTime=" + expireTime + "]";
	}
}
