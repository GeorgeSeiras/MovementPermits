package group15.intranet.entity;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "permits")
public class Permit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "permit_id")
	private int permitID;
	
	@Column(name = "status")
	private String status;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "type")
	private String type;

	@Column(name = "address")
	private String address;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	public int getPermitID() {
		return permitID;
	}

	public void setPermitID(int permitID) {
		this.permitID = permitID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Permit() {

	}

	@Override
	public String toString() {
		return "Permit [permitID=" + permitID + ", status=" + status + ", startDate=" + startDate + ", endDate="
				+ endDate + ", type=" + type + ", address=" + address + ", user=" + user + "]";
	}

	
	

}