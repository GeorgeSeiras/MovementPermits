package group15.intranet.entity;

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
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private int deptID;

	@OneToMany(mappedBy = "dept")
	private List<User> users;

	@Column(name = "dept_name")
	private String deptName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "super_id")
	private User supervisor;

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public User getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(User supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", users=" + users + ", deptName=" + deptName + ", supervisor="
				+ supervisor + "]";
	}

	public Department() {
	}
}
