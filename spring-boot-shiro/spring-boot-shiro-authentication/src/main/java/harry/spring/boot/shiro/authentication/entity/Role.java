package harry.spring.boot.shiro.authentication.entity;

public class Role {
	private Long id;
    private String name;
    private String memo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", memo=" + memo + "]";
	}
}
