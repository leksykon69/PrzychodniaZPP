package pol.abstractService;

import java.util.Collection;
import java.util.List;

public interface AbstractService<T> {
	
	public T find(Integer id);

	public List<T> findAll();

	public void delete(T obj);

	public void save(T obj);

	public void saveAll(Collection<T> obj);
}
