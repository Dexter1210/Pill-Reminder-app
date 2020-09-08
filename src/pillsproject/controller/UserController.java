package pillsproject.controller;

import java.util.ArrayList;
import java.util.HashMap;

/*import java.util.HashMap;*/

import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pillsproject.service.ServiceUser;
import pillsproject.userclass.AddUser;
import pillsproject.userclass.DependentProfile;
import pillsproject.userclass.MedHistory;
/*import pillsproject.userclass.MedHistory;*/

@Path("user")
public class UserController {

	static ServiceUser service = new ServiceUser();

	@POST
	@Path("newuser")
	public boolean newuser(@BeanParam AddUser user) {                           // new user added

		boolean resultservice = service.serviceadd(user);

		return resultservice;
	}

	@PUT
	@Path("ChangePassword")
	public boolean Change_pwd(@FormParam("email") String email, @FormParam("npwd") String npwd) {         // password change

		return service.changepwd(email, npwd);
	}

	@POST
	@Path("verifyuser")          
	public String verify(@FormParam("email") String email, @FormParam("pwd") String pwd) {                 // login user

		return service.check(email, pwd);
	}

	@GET
	@Path("edituser/{emailid}") // http://localhost:8080/PillsProjectOriginal/demo/user/edituser
	@Produces(MediaType.APPLICATION_JSON)
	public AddUser getUser(@PathParam("emailid") String emailid) {                                         // edit user 
		AddUser profile = service.getServiceUser(emailid);

		return profile;
	}
	
	@GET
	@Path("loaddropdown/{emailid}") // http://localhost:8080/PillsProjectOriginal/demo/user/edituser
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, DependentProfile> loaddropdown(@PathParam("emailid") String emailid) {           // load drop down
		HashMap<String, DependentProfile> dependents = service.loaddropdown(emailid);

		return dependents;
	}

	@PUT
	@Path("updateuser") // http://localhost:8080/PillsProjectOriginal/demo/user/updateuser
	public String updateUser(@BeanParam AddUser profile) {                                                 // update user
		boolean u = service.updateServiceUser(profile);
		if (u == true) {
			return "1";
		}
		return "0";
	}

	@PUT
	@Path("addDependent")
	// http://localhost:8080/PillsProjectOriginal/demo/user/addDependent
	public DependentProfile addDependent(@BeanParam DependentProfile profile) {                         //add dependent 
		
		DependentProfile u = service.addDependent(profile);
		return u;
	}

	@GET
	@Path("viewdependent/{emailid}/{dependent}") // http://localhost:8080/PillsProjectOriginal/demo/user/viewdependent
	@Produces(MediaType.APPLICATION_JSON)                                                                 // display dependent profile
	public DependentProfile getdependent(@PathParam("emailid") String emailid,                     
			@PathParam("dependent") String dependent) {
		DependentProfile profile = service.getServicedependent(emailid, dependent);
		return profile;
	}

	@GET
	@Path("gethistory/{useremail}/{name}")
	@Produces(MediaType.APPLICATION_JSON)          // http://localhost:8080/PillsProjectOriginal/demo/user/gethistory       //display medical history 
	public ArrayList<MedHistory>  getAllhistory(@PathParam("useremail")String useremail,@PathParam("name")String name) {
		
		ArrayList<MedHistory> mh=service.getHistory(useremail,name);
		
		return mh;
	}
	
	@POST
	@Path("saverecord")                            // http://localhost:8080/PillsProjectOriginal/demo/user/saverecord         // add medical history
	public String saveMedicalRecord(@BeanParam MedHistory medrecord) {
		
		boolean result=service.saveMedRecord(medrecord);
		
		if(result)
			return "Medical Record Added";
		
		return null;
	}
	
	@POST
	@Path("deleterecord")                         // http://localhost:8080/PillsProjectOriginal/demo/user/deleterecord        // delete medical histroy
	public String deleteMedicalRecord(@FormParam("useremail")String useremail,@FormParam("name")String name,@FormParam("historyid")int historyid) {

		boolean result=service.deleteMedRecord(useremail,name,historyid);
		
		if(result)
		 return "Medical Record deleted";
		return null;
	}
	
	

}
