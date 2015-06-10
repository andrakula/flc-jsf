package de.lustin.flc.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.lustin.flc.domain.Team;

@Stateless
public class TeamsStore {

	@PersistenceContext(unitName = "flc")
	private EntityManager em;

	public void save(Team t) {
		em.merge(t);
	}

	public List<Team> all() {
		return em.createNamedQuery("allTeams", Team.class).getResultList();
	}
}
