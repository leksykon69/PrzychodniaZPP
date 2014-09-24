package pol.abstractService;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pol.abstractDao.AbstractDao;

public abstract class AbstractServiceImpl<T> implements AbstractService<T> {

	protected abstract AbstractDao<T> getDao();

	public T find(Integer id) {
		return getDao().find(id);
	}

	public List<T> findAll() {
		return getDao().findAll();
	}

	public void delete(T obj) {
		getDao().delete(obj);
	}

	public T save(T obj) {
		return getDao().saveOrUpdate(obj);
	}

	public List<T> saveAll(Collection<T> obj) {
		List<T> result = new LinkedList<T>();
		for (T entity : obj) {
			result.add(save(entity));
		}
		return result;
	}

	public Long getCount() {
		return getDao().getCount();
	}

	public Map<String,String> getEntityComboOptions(boolean showEmptyOption, Collection<T> obj, final String fullNameMethodName){
		final String keyMethodName = "getId";
		try{
			Map<String, String> result = new LinkedHashMap<String, String>();
			if (showEmptyOption) {
				result.put("", "");
			}
			
			Method keyMethod = null;
			Method valueMethod = null;
			
			
			for(T entity: obj){
				if(keyMethod==null){
					keyMethod=entity.getClass().getMethod(keyMethodName, new Class[0]);
				}
				if(valueMethod==null){
					valueMethod=entity.getClass().getMethod(fullNameMethodName, new Class[0]);
				}
				result.put(keyMethod.invoke(entity, new Object[0]).toString(), valueMethod.invoke(entity, new Object[0]).toString());
			}
			
			return result;
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		
	}

}
