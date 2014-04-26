package pol.spring.bind.editors;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.context.ApplicationContext;

import pol.abstractDao.AbstractDao;
import pol.baseEntity.AbstractEntity;
import pol.spring.bind.ApplicationContextProvider;

public abstract class AbstractEntityEditor<T extends AbstractEntity> extends
		PropertiesEditor {

	protected static ApplicationContext context = ApplicationContextProvider
			.getContext();

	@SuppressWarnings("unchecked")
	@Override
	public String getAsText() {
		if (getClazz().isInstance(getValue()))
			return ((T) getValue()).getId().toString();
		return "";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text != null && text != "") {
			Object entity = getDao().find(Integer.parseInt(text));
			setValue(entity);
		} else {
			setValue(null);
		}
	}

	abstract public AbstractDao<?> getDao();

	abstract public Class<?> getClazz();

}
