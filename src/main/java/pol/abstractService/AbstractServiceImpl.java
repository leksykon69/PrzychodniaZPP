package pol.abstractService;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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

}
