package pol.abstractDao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		em.remove(em.contains(obj) ? obj : em.merge(obj));
		em.flush();
	}

	@Transactional
	public T saveOrUpdate(T obj) {
		if (obj.getId()==null) {
			em.persist(obj);
		} else {
			em.merge(obj);
		}
		em.flush();
		return obj;
	}

	@Transactional
	public List<T> findAll() {
		return em.createQuery("from " + type.getSimpleName(), type).getResultList();
	}

	@Transactional
	public Long getCount(){
		return (Long) em.createQuery(
				"select count(*) from " + type.getSimpleName())
				.getSingleResult();
	}

	@Transactional
	public List<T> findByNamedQueryAndParams(String query, Map<String, Object> params) {
		TypedQuery<T> namedQuery = getEntityManager().createNamedQuery(query, type);
		params.forEach((k, v) -> namedQuery.setParameter(k, v));
		return namedQuery.getResultList();
	}
}