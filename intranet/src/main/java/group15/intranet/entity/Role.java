package group15.intranet.entity;

import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@Column(name = "authority")
	private String authority;
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "rolesbyuser", joinColumns = @JoinColumn(name = "authority"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	public String getAuthority() {
		return authority;
	}

	public void setauthority(String authority) {
		this.authority = authority;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [authority=" + authority + ", users=" + users + "]";
	}

	public Role() {

	}

}