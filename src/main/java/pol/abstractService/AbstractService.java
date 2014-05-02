package pol.abstractService;

import java.util.Collection;
import java.util.List;

public interface AbstractService<T> {
	
	public T find(Integer id);

	public List<T> findAll();

	public void delete(T obj);

	public T save(T obj);

	public List<T> saveAll(Collection<T> obj);
}
