package com.ikpb.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ikpb.domain.SuperHuman;

@Component
public class SuperHumanDaoImpl implements SuperHumanDAO {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSf(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<SuperHuman> getAllSuperHumans() {
		Session sess = sessionFactory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<SuperHuman> cq = cb.createQuery(SuperHuman.class);
		Root<SuperHuman> rootEntry = cq.from(SuperHuman.class);
		CriteriaQuery<SuperHuman> all = cq.select(rootEntry);
		TypedQuery<SuperHuman> allQuery = sess.createQuery(all);
		return allQuery.getResultList();
	}

	@Override
	public SuperHuman getSuperHumanByName(String name) {
		Session sess = sessionFactory.openSession();
		return sess.get(SuperHuman.class, name);
	}

	@Override
	public void updateSuperHuman(SuperHuman superHuman) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		SuperHuman oldSuperH = sess.byId(SuperHuman.class).load(superHuman.getId());
		oldSuperH.setSuperHumanName(superHuman.getSuperHumanName());
		oldSuperH.setSuperPower(superHuman.getSuperPower());
		oldSuperH.setWeakness(superHuman.getWeakness());
		oldSuperH.setAlias(superHuman.getAlias());
		oldSuperH.setAlignmentNumber(superHuman.getAlignmentNumber());
		sess.flush();
		tx.commit();
		

	}

	@Override
	public void deleteSuperHuman(int id) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		SuperHuman superH = sess.byId(SuperHuman.class).load(id);
		sess.delete(superH);
		tx.commit();
	}

	@Override
	public void saveSuperHuman(SuperHuman superHuman) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(superHuman);
		tx.commit();

	}

	@Override
	public SuperHuman getSuperHumanById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
