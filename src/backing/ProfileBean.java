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
import dto.ProfileDto;

@Named
@ViewScoped
public class ProfileBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private WebTarget profileTarget = ClientBuilder.newClient()
			.target("http://localhost:8080/ProjectXWebservice/profiles");
	private ProfileDto newProfile;

	public List<ProfileDto> getProfiles() {
		return profileTarget.request(MediaType.APPLICATION_XML).get(new GenericType<List<ProfileDto>>() {
		});
	}

	public ProfileDto getNewProfile() {
		if (newProfile == null) {
			newProfile = new ProfileDto(0, "email@email.com", "password", "name", "bio", 0);
		}
		return newProfile;
	}

	public void createNewProfile() {
		profileTarget.request(MediaType.APPLICATION_XML).post(Entity.xml(newProfile));
		newProfile = null;
	}

	public void cancelNewProfile() {
		newProfile = null;
	}

	public void deleteProfile(ProfileDto pro) {
		profileTarget.path("{id}").resolveTemplate("id", pro.getId()).request(MediaType.APPLICATION_XML).delete();
	}

	public void getYourEevents(){
		
	}
	
	
	
	
}
