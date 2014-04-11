package pol.spring.bind.editors;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import pol.entity.RoomEntity;

public class RoomSelectEditor extends PropertiesEditor{

	@Override
	public String getAsText() {
		if(getValue() instanceof RoomEntity )
		return ((RoomEntity)getValue()).getId().toString();
		return "";
	}
	
	
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text != null && text != ""){
			RoomEntity entity = new RoomEntity();
			entity.setId(Integer.valueOf(text));
			
			setValue(entity);
		}else{
			setValue(null);
		}
	}
}
