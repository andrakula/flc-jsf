package de.lustin.flc.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.lustin.flc.domain.Game;

@Stateless
public class GamesStore {

	@PersistenceContext(unitName = "flc")
	private EntityManager em;

	public void save(Game g) {
		em.merge(g);
	}

	public List<Game> all() {
		return em.createNamedQuery("allGames", Game.class).getResultList();
	}
}
