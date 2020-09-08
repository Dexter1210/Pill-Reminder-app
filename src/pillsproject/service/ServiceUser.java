package pillsproject.service;

import java.util.ArrayList;
import java.util.HashMap;

import pillsproject.dao.DaoUser;
import pillsproject.userclass.AddUser;
import pillsproject.userclass.DependentProfile;
import pillsproject.userclass.MedHistory;

public class ServiceUser {                                          
	static DaoUser dao = new DaoUser();

	public boolean serviceadd(AddUser user) {               // add new user        

		AddUser resultdao = dao.daoadd(user);
		if (resultdao == null)
			return true;
		return false;
	}

	public boolean changepwd(String email, String npwd) {             // change password
		return dao.Change(email, npwd);
	}

	public String check(String email, String pwd) {                   // login user

		return dao.verifyUser(email, pwd);
	}

	public AddUser getServiceUser(String emailid) {                     // edit user
		AddUser profile = dao.getDaoUser(emailid);
		return profile;
	}

	public boolean updateServiceUser(AddUser profile) {                   //upadte user 
		boolean uprofile = dao.updateDaoUser(profile);
		return uprofile;
	}

	public DependentProfile addDependent(DependentProfile profile) {                  // add dependent profile
		DependentProfile uprofile = dao.addDependent(profile);
		return uprofile;
	}

	public DependentProfile getServicedependent(String emailid, String dependent) {        // display dependent profile
		
		DependentProfile profile = dao.getDaodependent(emailid, dependent);
		return profile;

	}

	public HashMap<String, DependentProfile> loaddropdown(String emailid) {                // load drop down menu
		HashMap<String, DependentProfile> dependents = dao.loaddropdown(emailid);
		return dependents;
	}

     public ArrayList<MedHistory> getHistory(String useremail, String name) {                // get medical history
		ArrayList<MedHistory> depm=dao.getAllhist(useremail,name);
		
		return depm;
	}

	public boolean saveMedRecord(MedHistory medrecord) {                                   // save medical history      
        boolean check=dao.saveMedData(medrecord);
		
         if(check)
        	return true;
        
		return false;
	}

	public boolean deleteMedRecord(String useremail, String name, int index) {                  // delete medical history	
		boolean check=dao.removeMedRecord(useremail,name,index);
	
		if(check)
			return true;
		
		return false;
	}
	
}
