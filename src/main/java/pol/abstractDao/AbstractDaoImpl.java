package pol.abstractDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import pol.baseEntity.IEntity;

public abstract class AbstractDaoImpl<T extends IEntity> implements
		AbstractDao<T> {

	private Class<T> type;

	@PersistenceContext
	private EntityManager em;
	
	public AbstractDaoImpl(final Class<T> type) {
		this.type = type;
	}
	
	protected EntityManager getEntityManager(){
		return em;
	}

	public Class<T> getType() {
		return type;
	}

	@Transactional
	public T find(Integer id) {
		return em.find(type, id);
	}

	@Transactional
	public void delete(T obj) {
		em.remove(obj);
		em.flush();
	}

	@Transactional
	public void saveOrUpdate(T obj) {
		if (obj.getId()==null) {
			em.persist(obj);
		} else {
			em.merge(obj);
		}
		em.flush();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findAll() {
		return em.createQuery("from " + type.getSimpleName()).getResultList();
	}
}