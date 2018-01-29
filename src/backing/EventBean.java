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

import dto.EventDto;

@Named
@ViewScoped
public class EventBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private WebTarget eventTarget = ClientBuilder.newClient()
			.target("http://localhost:8080/ProjectXWebservice/events");
	private EventDto newEvent;

	public List<EventDto> getEvents() {
		return eventTarget.request(MediaType.APPLICATION_XML).get(new GenericType<List<EventDto>>() {
		});
	}

	public EventDto getNewEvent() {
		if (newEvent == null) {
			newEvent = new EventDto(0, "event", "Catagorys", "Date", "något till väster", 0);
		}
		return newEvent;
	}

	public void createNewEvent() {
		eventTarget.request(MediaType.APPLICATION_XML).post(Entity.xml(newEvent));
		newEvent = null;
	}

	public void cancelNewEvent() {
		newEvent = null;
	}

	public void deleteEvent(EventDto eve) {
		eventTarget.path("{id}").resolveTemplate("id", eve.getEventid()).request(MediaType.APPLICATION_XML).delete();

	}
	
	public void editEvent(EventDto eve){
		eventTarget.path("{id}").resolveTemplate("id", eve.getEventid()).request(MediaType.APPLICATION_XML).put(Entity.xml(eve));
	}
}
