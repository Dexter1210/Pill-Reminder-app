package pillsproject.userclass;

import java.util.ArrayList;

import javax.ws.rs.FormParam;

public class DependentProfile {
	private static final long serialVersionUID = -7526660797642769995L;
	@FormParam("uemail")
	private String uemail;

	public String getUemail() {
		return uemail;
	}

	@FormParam("rname")
	private String name;
	@FormParam("remail")
	private String email;
	@FormParam("country")
	private String country;
	@FormParam("relationship")
	private String relationship;
	@FormParam("rdob")
	private String dob;
	@FormParam("rcontact")
	private long contact;
	@FormParam("rbloodgroup")
	private String bloodgroup;
	@FormParam("rweight")
	private long weight;
	@FormParam("rheight")
	private long height;
	
	private ArrayList<MedHistory> medicalHistory= new ArrayList<>();

	public DependentProfile() {
		// TODO Auto-generated constructor stub
	}

	public DependentProfile(String uemail, String name, String email, String country, String relationship, String dob,
			long contact, String bloodgroup, long weight, long height) {
		super();
		this.uemail = uemail;
		this.name = name;
		this.email = email;
		this.country = country;
		this.relationship = relationship;
		this.dob = dob;
		this.contact = contact;
		this.bloodgroup = bloodgroup;
		this.weight = weight;
		this.height = height;
	}


	@Override
	public String toString() {
		return "DependentProfile [uemail=" + uemail + ", name=" + name + ", email=" + email + ", country=" + country
				+ ", relationship=" + relationship + ", dob=" + dob + ", contact=" + contact + ", bloodgroup="
				+ bloodgroup + ", weight=" + weight + ", height=" + height + ", medicalHistory=" + medicalHistory + "]";
	}

	public ArrayList<MedHistory> getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(ArrayList<MedHistory> medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
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
	

}
