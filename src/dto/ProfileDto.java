package dto;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfileDto {

	@XmlElement(name="profileid")
	private int id;
	@XmlElement
	private String email;
	@XmlElement
	private String password;
	@XmlElement
	private String name;
	@XmlElement
	private String bio;
	@XmlElement
	private String photo;
	@XmlElement
	private double profileRating;

	@XmlElementWrapper(name = "eventResult")
	@XmlElement(name = "event")
	private List<EventDto> eventResult;

	public ProfileDto(){}
	
	public ProfileDto(int id, String email, String password, String name, String bio, double rating) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.bio = bio;
		this.profileRating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getProfileRating() {
		return profileRating;
	}

	public void setProfileRating(double rating) {
		this.profileRating = rating;
	}

	public List<EventDto> getEventResult() {
		return eventResult;
	}

	public void setEventResult(List<EventDto> eventResult) {
		this.eventResult = eventResult;
	}

}
