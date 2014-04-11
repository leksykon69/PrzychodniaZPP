package pol.spring.bind.editors;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import pol.entity.DoctorEntity;

public class DoctorSelectEditor extends PropertiesEditor{

	@Override
	public String getAsText() {
		if(getValue() instanceof DoctorEntity )
		return ((DoctorEntity)getValue()).getId().toString();
		return "";
	}
	
	
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text != null && text != ""){
			DoctorEntity entity = new DoctorEntity();
			entity.setId(Integer.valueOf(text));
			
			setValue(entity);
		}else{
			setValue(null);
		}
	}
}
