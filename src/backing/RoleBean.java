package backing;

import java.io.Serializable;
import java.util.*;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import dto.RoleDto;

@Named
@ViewScoped
public class RoleBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private WebTarget roleTarget = ClientBuilder.newClient().target("http://localhost:8080/ProjectXWebservice/roleService");
	private RoleDto newRole;
	private List<RoleDto> selectedRoles;
	private String selectedRole;

	public List<RoleDto> getRoles(){
	return roleTarget.request(MediaType.APPLICATION_XML).get(new GenericType<List<RoleDto>>(){});
	}
	
	public RoleDto getNewRole(){
		if(newRole == null){
			newRole = new RoleDto("users");
		}
	return newRole;
	}
	
	public void createNewRole(){
		roleTarget.request(MediaType.APPLICATION_XML).post(Entity.xml(newRole));
		newRole=null;
	}
	
	public void cancelNewRole(){
		newRole=null;
	}
	public void deleteRole(RoleDto Role){
		roleTarget.path("{id}").resolveTemplate("id",Role.getRolename()).request(MediaType.APPLICATION_XML).delete();
		newRole=null;
	}	
	
	public String findRoleByName(String id){
		Response r = roleTarget.path("{id}").resolveTemplate("id", id).request(MediaType.APPLICATION_XML).get();
	String result = r.toString();
		return result;
	}

	public String getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(String selectedRole) {
		this.selectedRole = selectedRole;
	}

	public List<RoleDto> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(List<RoleDto> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}
	
}
