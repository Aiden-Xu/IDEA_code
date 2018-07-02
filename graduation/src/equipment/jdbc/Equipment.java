package equipment.jdbc;

public class Equipment {
	 private String id;
	 private String name;
	 private String status;
	 private String loantime;
	 private String returntime;
	 private String loanclass;
	 private String loanstudent;
	 private String loanstudentid;
	 private String inout;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLoantime() {
		return loantime;
	}
	public void setLoantime(String loantime) {
		this.loantime = loantime;
	}
	public String getReturntime() {
		return returntime;
	}
	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}
	public String getLoanclass() {
		return loanclass;
	}
	public void setLoanclass(String loanclass) {
		this.loanclass = loanclass;
	}
	public String getLoanstudent() {
		return loanstudent;
	}
	public void setLoanstudent(String loanstudent) {
		this.loanstudent = loanstudent;
	}
	public String getLoanstudentid() {
		return loanstudentid;
	}
	public void setLoanstudentid(String loanstudentid) {
		this.loanstudentid = loanstudentid;
	}
	public String getInout() {
		return inout;
	}
	public void setInout(String inout) {
		this.inout = inout;
	}
	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", status=" + status
				+ ", loantime=" + loantime + ", returntime=" + returntime
				+ ", loanclass=" + loanclass + ", loanstudent=" + loanstudent
				+ ", loanstudentid=" + loanstudentid + ", inout=" + inout + "]";
	}
	
	 
	 
	 
}
