package rentcar.vo;

public class MemberVO {
	private int no;
	private String id;
	private String pw;
	private String email;
	private String tel;
	private String hobby;
	private String job;
	private String age;
	private String info;
	private String oFileName;
	private String sFileName;
	
	public MemberVO() {
	}
	
	
	public MemberVO(String id, String pw, String email, String tel, String hobby, String job, String age, String info,
			String oFileName, String sFileName) {
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.tel = tel;
		this.hobby = hobby;
		this.job = job;
		this.age = age;
		this.info = info;
		this.oFileName = oFileName;
		this.sFileName = sFileName;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getoFileName() {
		return oFileName;
	}
	public void setoFileName(String oFileName) {
		this.oFileName = oFileName;
	}
	public String getsFileName() {
		return sFileName;
	}
	public void setsFileName(String sFileName) {
		this.sFileName = sFileName;
	}
	@Override
	public String toString() {
		return "memberVO [no=" + no + ", id=" + id + ", pw=" + pw + ", email=" + email + ", tel=" + tel + ", hobby="
				+ hobby + ", job=" + job + ", age=" + age + ", info=" + info + "]";
	}
}
