package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;

import backing.RoleBean;
import dto.RoleDto;

@FacesConverter(forClass = RoleDto.class, value = "roleConverter")
public class RoleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		String id;
		try {
			id = value;

		} catch (Exception e) {
			return "";
		}
		RoleDto role = new RoleDto(id);
		return role;
		

	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
		if (!(value instanceof RoleDto)) {
			return "";
		}
		
	
		return ((RoleDto) value).getRolename();
	}

}
