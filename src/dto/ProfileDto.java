package dto;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfileDto {

	@XmlElement(name ="emails")
	private String emails;
	@XmlElement
	private String password;
	@XmlElement
	private String name;
	@XmlElement
	private String bio;
//	@XmlElement
//	private String photo;
//	@XmlElement
//	private double profileRating;

	@XmlElementWrapper(name = "roles")
	@XmlElement(name = "role")
	private List<RoleDto> roleResult;

	@XmlElementWrapper(name = "eventResult")
	@XmlElement(name = "event")
	private List<EventDto> eventResult;

	public ProfileDto(){}

	public ProfileDto(String emails, String password, String name, String bio, List<RoleDto> roles) {
		this.emails = emails;
		this.password = password;
		this.name = name;
		this.bio = bio;
		this.roleResult=roles;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

//	public String getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(String photo) {
//		this.photo = photo;
//	}
//
//	public double getProfileRating() {
//		return profileRating;
//	}
//
//	public void setProfileRating(double rating) {
//		this.profileRating = rating;
//	}

	public List<EventDto> getEventResult() {
		return eventResult;
	}

	public void setEventResult(List<EventDto> eventResult) {
		this.eventResult = eventResult;
	}

	public List<RoleDto> getRoleResult() {
		return roleResult;
	}

	public void setRoleResult(List<RoleDto> roles) {
		this.roleResult = roles;
	}

}
