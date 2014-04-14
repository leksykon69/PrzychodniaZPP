package pol.abstractService;

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

	public void save(T obj) {
		getDao().saveOrUpdate(obj);
	}

}
