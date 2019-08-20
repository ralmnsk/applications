package web4.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="usrtab")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6439408384211862318L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="ID")
	private long id;
	
	
	@Version
	@Column(name = "NAME")
	private String name;
	
	@Version
	@Column(name = "PASS")
	private String password;
	
	@Version
	@Column(name = "ROLE")
	private String role;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	private Date joiningDate;
	
	public User(long id, String name, String password, String role, Date joiningDate) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.joiningDate=joiningDate;
	}
	
	public User() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + ", joiningDate="
				+ joiningDate + "]";
	}
	
}
