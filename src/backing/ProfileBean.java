package backing;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import javax.annotation.security.DeclareRoles;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import org.primefaces.event.RowEditEvent;

import dto.ProfileDto;
import dto.RoleDto;

@Named
@ViewScoped
@DeclareRoles(value = { "users", "admin" })
public class ProfileBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private WebTarget profileTarget = ClientBuilder.newClient()
			.target("http://localhost:8080/ProjectXWebservice/profiles");
	private ProfileDto newProfile;
	private List<ProfileDto> profiles;

	public List<ProfileDto> getProfiles() {
		if (profiles == null) {
			profiles = profileTarget.request(MediaType.APPLICATION_XML).get(new GenericType<List<ProfileDto>>() {});
		}
		return profiles;
	}

	public ProfileDto getNewProfile() {
		if (newProfile == null) {
		
			newProfile = new ProfileDto();
		}
		return newProfile;
	}

	public void createNewProfile() {
		profileTarget.request(MediaType.APPLICATION_XML).post(Entity.xml(newProfile));
		newProfile = null;
		profiles = null;
	}

	public void cancelNewProfile() {
		newProfile = null;
	}

	public void deleteProfile(ProfileDto pro) {
		profileTarget.path("{id}").resolveTemplate("id", pro.getEmails()).request(MediaType.APPLICATION_XML).delete();
		profiles = null;
	}

	public void editProfile(ProfileDto pro) {
	
		profileTarget.path("{id}").resolveTemplate("id", pro.getEmails()).request(MediaType.APPLICATION_XML).put(Entity.xml(pro));
		profiles = null;
		
	}
	
	
	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		try {
			context.getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Profile Edited", ((ProfileDto) event.getObject()).getEmails());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((ProfileDto) event.getObject()).getEmails());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
