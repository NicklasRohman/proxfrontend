package dto;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EventDto {

	@XmlElement(name = "eventid")
	private int eventid;
	@XmlElement
	private String name;
	@XmlElement
	private String catagory;
	@XmlElement
	private String date;
	@XmlElement
	private String location;
	@XmlElement
	private double raiting;

	public EventDto() {
	}

	public EventDto(int eventid, String name, String caregory, String date, String location, double raiting) {
		this.eventid = eventid;
		this.name = name;
		this.catagory = caregory;
		this.date = date;
		this.location = location;
		this.raiting = raiting;

	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getRaiting() {
		return raiting;
	}

	public void setRaiting(double raiting) {
		this.raiting = raiting;
	}

}
