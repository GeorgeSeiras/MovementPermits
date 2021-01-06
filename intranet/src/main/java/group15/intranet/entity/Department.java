package group15.intranet.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "departments")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Department  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private int deptID;
	

	@Column(name = "dept_name")
	private String deptName;

	
	@Column(name = "super_id")
	private int supervisor;

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}


	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", users=" + ", deptName=" + deptName + ", supervisor="
				+ supervisor + "]";
	}

	public Department() {
	}
}
