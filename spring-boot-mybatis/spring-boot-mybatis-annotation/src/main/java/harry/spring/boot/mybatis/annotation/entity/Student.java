package harry.spring.boot.mybatis.annotation.entity;

public class Student {
	private String no;
	private String name;
	private String sex;
	
	public Student(String no, String name, String sex) {
		super();
		this.no = no;
		this.name = name;
		this.sex = sex;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", sex=" + sex + "]";
	}
}
