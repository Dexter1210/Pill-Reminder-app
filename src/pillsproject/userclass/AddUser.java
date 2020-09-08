package pillsproject.userclass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddUser extends DependentProfile implements Serializable{
	
	private static final long serialVersionUID = -7526660797642769995L;
	@FormParam("name")
	private String name;
	@FormParam("email")
	private String email;
	@FormParam("country")
	private String country;
	@FormParam("pwd")
	private String pwd;
	@FormParam("dob")
	private String dob;
	@FormParam("contact")
	private long contact;
	@FormParam("bloodgroup")
	private String bloodgroup = "not set";
	@FormParam("weight")
	private long weight;
	@FormParam("height")
	private long height;
	static HashMap<String,DependentProfile> dependents=new HashMap<>();

	public HashMap<String, DependentProfile> getDependents() {
		return dependents;
	}

	public AddUser() {
		
	}

	public AddUser(String name, String email, String country, String pwd, String dob, long contact) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
		this.pwd = pwd;
		this.dob = dob;
		this.contact = contact;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "AddUser [name=" + name + ", email=" + email + ", country=" + country + ", pwd=" + pwd + ", dob=" + dob
				+ ", contact=" + contact + ", bloodgroup=" + bloodgroup + ", weight=" + weight + ", height=" + height
				+ "]";
	}

}
