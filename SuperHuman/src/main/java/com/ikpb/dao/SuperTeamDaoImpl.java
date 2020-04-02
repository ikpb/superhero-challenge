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

import com.ikpb.domain.SuperTeam;
@Component
public class SuperTeamDaoImpl implements SuperTeamDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSf(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<SuperTeam> getAllSuperTeams() {
		Session sess = sessionFactory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<SuperTeam> cq = cb.createQuery(SuperTeam.class);
		Root<SuperTeam> rootEntry = cq.from(SuperTeam.class);
		CriteriaQuery<SuperTeam> all = cq.select(rootEntry);
		TypedQuery<SuperTeam> allQuery = sess.createQuery(all);
		return allQuery.getResultList();
	}

	@Override
	public SuperTeam getSuperTeamByName(String name) {
		Session sess = sessionFactory.openSession();
		return sess.get(SuperTeam.class, name);
	}

	@Override
	public void updateSuperTeam(SuperTeam team) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		SuperTeam oldSuperT = sess.byId(SuperTeam.class).load(team.getTeamName());
		oldSuperT.setAlignment(team.getAlignment());
		sess.flush();
		tx.commit();
	}

	@Override
	public void deleteSuperTeam(String name) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		SuperTeam superT = sess.byId(SuperTeam.class).load(name);
		sess.delete(superT);
		tx.commit();

	}

	@Override
	public void saveSuperTeam(SuperTeam superTeam) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(superTeam);
		tx.commit();

	}

}
