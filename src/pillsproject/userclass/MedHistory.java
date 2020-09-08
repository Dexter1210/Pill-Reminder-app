package pillsproject.userclass;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MedHistory {


	@FormParam("useremail")
	private String useremail;
	@FormParam("dname")
	private String dname;
	@FormParam("doctorname")
	private String doctorname;
	@FormParam("illness")
	private String illness;
	@FormParam("medicine")
	private String medicine;
	@FormParam("startDate")
	private String startDate;
	@FormParam("endDate")
	private String endDate;
	@FormParam("dosage")
	private String dosage;
	@FormParam("dosageFrequency")
	private String dosageFrequency;
	@FormParam("dosageTime")
	private String dosageTime;
	@FormParam("notify")
	private String notify;

	public String getUserEmail() {
		return useremail;
	}

	public void setUserEmail(String useremail) {
		this.useremail = useremail;
	}
	
	
	public String getNotify() {
		return notify;
	}

	public void setNotify(String notify) {
		this.notify = notify;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getDosageFrequency() {
		return dosageFrequency;
	}

	public void setDosageFrequency(String dosageFrequency) {
		this.dosageFrequency = dosageFrequency;
	}

	public String getDosageTime() {
		return dosageTime;
	}

	public void setDosageTime(String dosageTime) {
		this.dosageTime = dosageTime;
	}

	public MedHistory() {

	}

	public MedHistory(String useremail,String dname, String doctorname, String illness, String medicine, String startDate,
			String endDate, String dosage, String dosageFrequency, String dosageTime, String notify) {
		super();
		this.useremail = useremail;
		this.dname = dname;
		this.doctorname = doctorname;
		this.illness = illness;
		this.medicine = medicine;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dosage = dosage;
		this.dosageFrequency = dosageFrequency;
		this.dosageTime = dosageTime;
		this.notify = notify;
	}

	public String getdname() {
		return dname;
	}

	public void setdname(String dname) {
		this.dname = dname;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	@Override
	public String toString() {
		return "MedHistory [useremail=" + useremail + ", dname=" + dname + ", doctorname=" + doctorname + ", illness="
				+ illness + ", medicine=" + medicine + ", startDate=" + startDate + ", endDate=" + endDate + ", dosage="
				+ dosage + ", dosageFrequency=" + dosageFrequency + ", dosageTime=" + dosageTime + ", notify=" + notify
				+ "]";
	}

	
}
