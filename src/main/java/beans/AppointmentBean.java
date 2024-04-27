package beans;

public class AppointmentBean {	//javabean类用于封装数据和方法
	private int anum;    //预约编号
	private String pnum;   //病人编号
	private String ddepartment; //医生科室
	private String dnum;        //医生编号
	private String yytime;      //开始预约时间
	private String jztime;		//就诊时间
	private String dcon;		//医生诊室
	private int astate;			//预约状态
	private int atype;			//预约类型
	private String pname;		//病人名字
	private String dname;		//医生名字
	private String dtitle;		//医生头衔
	
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getDdepartment() {
		return ddepartment;
	}
	public void setDdepartment(String ddepartment) {
		this.ddepartment = ddepartment;
	}
	public String getDnum() {
		return dnum;
	}
	public void setDnum(String dnum) {
		this.dnum = dnum;
	}
	public String getYytime() {
		return yytime;
	}
	public void setYytime(String yytime) {
		this.yytime = yytime;
	}
	public String getJztime() {
		return jztime;
	}
	public void setJztime(String jztime) {
		this.jztime = jztime;
	}
	public String getDcon() {
		return dcon;
	}
	public void setDcon(String dcon) {
		this.dcon = dcon;
	}
	public int getAstate() {
		return astate;
	}
	public void setAstate(int astate) {
		this.astate = astate;
	}
	public int getAtype() {
		return atype;
	}
	public void setAtype(int atype) {
		this.atype = atype;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDtitle() {
		return dtitle;
	}
	public void setDtitle(String dtitle) {
		this.dtitle = dtitle;
	}
}
