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

	@XmlElementWrapper(name = "roles")
	@XmlElement(name = "role")
	private List<RoleDto> roleResult;

	@XmlElementWrapper(name = "eventResult")
	@XmlElement(name = "event")
	private List<EventDto> eventResult;

	public ProfileDto(){}


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
