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
import dto.TagDto;

@Named
@ViewScoped
public class TagBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private WebTarget tagTarget = ClientBuilder.newClient().target("http://localhost:8080/ProjectXWebservice/tags");
	private TagDto newTag;
	
	public List<TagDto> getTags(){
	return tagTarget.request(MediaType.APPLICATION_XML).get(new GenericType<List<TagDto>>(){});
	}
	
	public TagDto getNewTag(){
		if(newTag == null){
			newTag = new TagDto(0,"Tag");
		}
	return newTag;
	}
	
	public void createNewTag(){
		tagTarget.request(MediaType.APPLICATION_XML).post(Entity.xml(newTag));
		newTag=null;
	}
	
	public void cancelNewTag(){
		newTag=null;
	}
	public void deleteTag(TagDto tag){
		tagTarget.path("{id}").resolveTemplate("id",tag.getId()).request(MediaType.APPLICATION_XML).delete();
		newTag=null;
	}	
}
