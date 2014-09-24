package pol.abstractService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface AbstractService<T> {
	
	public T find(Integer id);

	public List<T> findAll();

	public void delete(T obj);

	public T save(T obj);

	public List<T> saveAll(Collection<T> obj);

	public Long getCount();
	
	public Map<String,String> getEntityComboOptions(boolean showEmptyOption, Collection<T> obj, final String fullNameMethodName);
}
