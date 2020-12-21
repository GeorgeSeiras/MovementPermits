package group15.intranet.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permits")
public class Permit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "permit_id")
	private int permitID;

	@Column(name = "status")
	private int status;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "type")
	private String type;

	@Column(name = "address")
	private String address;

	public int getPermitID() {
		return permitID;
	}

	public void setPermitID(int permitID) {
		this.permitID = permitID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	@Override
	public String toString() {
		return "Permits [permitID=" + permitID + ", status=" + status + ", startDate=" + startDate + ", endDate="
				+ endDate + ", type=" + type + ", address=" + address + "]";
	}

	public Permit() {

	}

}