package pillsproject.dao;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import pillsproject.userclass.AddUser;
import pillsproject.userclass.DependentProfile;
import pillsproject.userclass.MedHistory;

public class DaoUser {

	static HashMap<String, AddUser> Users;
	static DependentProfile empty = new DependentProfile();
	static DependentProfile user = new DependentProfile();
	static MedHistory mhist1 = new MedHistory("user@gmail.com", "user", "Dr. Bhansali", "Blood Pressure", "Pencilin",
			"2020-08-30", "2020-09-10", "2", "1", "14:00", "YES");
	static MedHistory mhist2 = new MedHistory("user@gmail.com", "user", "Dr. Kohli", "Sugar", "Paramol", "2020-09-02",
			"2020-09-15", "1", "2", "16:00", "YES");
	static MedHistory mhist3 = new MedHistory("user@gmail.com", "user", "Dr. Bhalla", "Blood Pressure", "Pencilin",
			"2020-09-02", "2020-09-12", "2", "1", "10:00", "YES");
	static MedHistory mhist4 = new MedHistory("user@gmail.com", "user", "Dr. Khan", "Sugar", "Paramol", "2020-09-03",
			"2020-09-09", "1", "2", "19:00", "YES");
	static MedHistory mhist5 = new MedHistory("user@gmail.com", "user", "Dr. Bansal", "Blood Pressure", "Pencilin",
			"2020-09-04", "2020-09-18", "2", "1", "08:00", "YES");

	static {
		Users = new HashMap<>();

		AddUser ui1 = new AddUser("Abhinav", "abhinav@gmail.com", "India", "abhinav", "1998-07-03", 9472546900L);
		AddUser ui2 = new AddUser("Anushree", "anushree@gmail.com", "India", "anushree", "1999-12-09", 9472454900L);
		AddUser ui3 = new AddUser("Devesh", "devesh@gmail.com", "India", "devesh", "1998-11-12", 944567900L);
		AddUser ui4 = new AddUser("Prayansh", "prayansh@gmail.com", "India", "prayansh", "1997-05-10", 9472546900L);
		AddUser ui5 = new AddUser("Ramachandran", "rama@gmail.com", "India", "rama", "1997-05-12", 9472546900L);

		Users.put("abhinav@gmail.com", ui1);
		Users.put("anushree@gmail.com", ui2);
		Users.put("devesh@gmail.com", ui3);
		Users.put("prayansh@gmail.com", ui4);
		Users.put("rama@gmail.com", ui5);
	}

	public AddUser daoadd(AddUser user) { // register new user

		AddUser status = Users.putIfAbsent(user.getEmail(), user);

		try (FileOutputStream fos = new FileOutputStream("Users.data");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(Users);
		} catch (Exception e) {
		}

		return status;
	}

	public boolean Change(String email, String npwd) { // change password
		AddUser modify = Users.get(email);
		if (Users.containsKey(email)) {
			modify.setPwd(npwd);
			return true;
		} else
			return false;
	}

	public String verifyUser(String email, String pwd) { // login user
		AddUser verifyemail = Users.get(email);

		if ((Users.containsKey(email)) && verifyemail.getPwd().equals(pwd)) {
			HashMap<String, DependentProfile> dependents = verifyemail.getDependents();
			dependents.putIfAbsent("self", user);
			DependentProfile dep = dependents.get("self");
			ArrayList<MedHistory> mself=dep.getMedicalHistory();
			if(mself.isEmpty()) {
			ArrayList<MedHistory> medhistory = new ArrayList<>();
			medhistory.add(mhist1);
			medhistory.add(mhist2);
			medhistory.add(mhist3);
			medhistory.add(mhist4);
			medhistory.add(mhist5);
			dep.setMedicalHistory(medhistory);
			}
			return verifyemail.getName();
		} else
			return "Incorrect";
	}

	public AddUser getDaoUser(String emailid) { // edit user
		return Users.get(emailid);
	}

	public boolean updateDaoUser(AddUser profile) { // update user profile
		AddUser user = Users.get(profile.getEmail());
		user.setName(profile.getName());
		user.setContact(profile.getContact());
		user.setDob(profile.getDob());
		user.setBloodgroup(profile.getBloodgroup());
		user.setHeight(profile.getHeight());
		user.setWeight(profile.getWeight());

		return true;
	}

	public DependentProfile addDependent(DependentProfile profile) { // add dependent
		AddUser user = Users.get(profile.getUemail());

		HashMap<String, DependentProfile> dependent = user.getDependents();
		DependentProfile status = dependent.putIfAbsent(profile.getName(), profile);

		if (status != null) {
			return status;
		}
		return empty;
	}

	public DependentProfile getDaodependent(String emailid, String dependent) { // display dependent
		AddUser user = Users.get(emailid);

		HashMap<String, DependentProfile> dependents = user.getDependents();

		DependentProfile status = dependents.get(dependent);
		if (status != null) {
			return status;
		}
		return empty;
	}

	public HashMap<String, DependentProfile> loaddropdown(String emailid) { // load drop down
		AddUser user = Users.get(emailid);
		return user.getDependents();
	}

	public ArrayList<MedHistory> getAllhist(String useremail, String name) { // display medical history

		AddUser user = Users.get(useremail);
		HashMap<String, DependentProfile> depd = user.getDependents();
		DependentProfile dependent = depd.get(name);

		return dependent.getMedicalHistory();

	}

	public boolean saveMedData(MedHistory medrecord) { // save medical history

		String useremail = medrecord.getUserEmail();
		AddUser user = Users.get(useremail);
		
		HashMap<String, DependentProfile> depd = user.getDependents();
		String patient = medrecord.getdname();
		DependentProfile dependent = depd.get(patient);
		
		ArrayList<MedHistory> dependentMedHistory = dependent.getMedicalHistory();
		dependentMedHistory.add(medrecord);
		dependent.setMedicalHistory(dependentMedHistory);
		
		return true;

	}

	public boolean removeMedRecord(String useremail, String name, int index) { // delete medical history

		AddUser user = Users.get(useremail);
		HashMap<String, DependentProfile> depd = user.getDependents();

		DependentProfile dependent = depd.get(name);
		ArrayList<MedHistory> dependentMedtHistory = dependent.getMedicalHistory();

		if(dependentMedtHistory.size()>index) {
		dependentMedtHistory.remove(index);
		dependent.setMedicalHistory(dependentMedtHistory);
		return true;
		}
		return false;

	}

}
