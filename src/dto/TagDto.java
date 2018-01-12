package dto;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TagDto {

	@XmlElement(name="tagid")
	private int tagid;
	@XmlElement
	private String name;
	@XmlElementWrapper(name = "tagResult")
	@XmlElement(name = "tag")
	private List<EventDto> tagResult;

	public TagDto(){}
	
	public TagDto(int id, String name) {
		this.tagid = id;
		this.name= name;
	}

	public int getId() {
		return tagid;
	}

	public void setId(int id) {
		this.tagid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EventDto> getTagResult() {
		return tagResult;
	}

	public void setTagResult(List<EventDto> tagResult) {
		this.tagResult = tagResult;
	}
	
}
