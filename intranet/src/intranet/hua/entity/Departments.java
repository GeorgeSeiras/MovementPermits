package intranet.hua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Departments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private int deptID;

	@OneToMany(mappedBy = "department", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Users> users;

	@Column(name = "dept_name")
	private String deptName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "super_id")
	private Users supervisor;

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Users getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Users supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		return "Departments [deptID=" + deptID + ", users=" + users + ", deptName=" + deptName + ", supervisor="
				+ supervisor + "]";
	}

	public Departments() {
	}
}
