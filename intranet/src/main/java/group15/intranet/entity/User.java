package group15.intranet.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userID;

	
	@Column(name = "fname")
	private String fname;

	
	@Column(name = "lname")
	private String lname;

	
	@Column(name = "address")
	private String address;

	
	@Column(name = "phone_num")
	private String phoneNum;
	

	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "dep_id")
	private Department dept;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Permit> permits;
	
	
	@Column(name="username")
	private String username;
	
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "username",referencedColumnName="username"), inverseJoinColumns = @JoinColumn(name = "authority",referencedColumnName="authority"))
	private List<Role> authorities= new ArrayList<Role>();
	
	public void addAuthority(Role role) {
		this.authorities.add(role);
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public List<Permit> getPermits() {
		return permits;
	}

	public void setPermits(List<Permit> permits) {
		this.permits = permits;
	}


	public List<Role> getAuthorities() {
		return authorities;
	}
	
	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", fname=" + fname + ", lname=" + lname + ", address=" + address
				+ ", phoneNum=" + phoneNum + ", dept=" + dept + ", permits=" + permits + ", username=" + username
				+ ", password=" + password + ", enabled=" + enabled + ", authorities=" + authorities + "]";
	}

	public User() {
	}

	public void addPermit(Permit permit) {
		if (permits == null) {
			permits = new ArrayList<Permit>();
		}
		permits.add(permit);
	}

	public void addRole(Role role) {
		if (authorities == null) {
			authorities = new ArrayList<Role>();
		}
		authorities.add(role);
	}



}
