package de.lustin.flc.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.lustin.flc.domain.Game;
import de.lustin.flc.domain.Team;
import de.lustin.flc.store.GamesStore;
import de.lustin.flc.store.TeamsStore;

@Stateless
public class GameService {

	@Inject
	private GamesStore gamesStore;

	@Inject
	private TeamsStore teamsStore;

	public List<Game> getAllGames() {
		return gamesStore.all();
	}

	public void save(Game g) {
		calculateGame(g);

		gamesStore.save(g);
		teamsStore.save(g.getTeam1());
		teamsStore.save(g.getTeam2());
	}

	public void calculateGame(Game game) {
		Team home = game.getTeam1();
		Team visitor = game.getTeam2();

		if (game.getGoals1() > game.getGoals2()) {
			home.setPoints(home.getPoints() + 3);
			home.setWons(home.getWons() + 1);
			visitor.setLosts(visitor.getLosts() + 1);
		} else if (game.getGoals1() < game.getGoals2()) {
			visitor.setPoints(visitor.getPoints() + 3);
			visitor.setWons(visitor.getWons() + 1);
			home.setLosts(home.getLosts() + 1);
		} else {
			home.setPoints(home.getPoints() + 1);
			visitor.setPoints(visitor.getPoints() + 1);
			home.setDrawns(home.getDrawns() + 1);
			visitor.setDrawns(visitor.getDrawns() + 1);
		}

		home.setGoalsFor(home.getGoalsFor() + game.getGoals1());
		visitor.setGoalsFor(visitor.getGoalsFor() + game.getGoals2());

		home.setGoalsAgainst(home.getGoalsAgainst() + game.getGoals2());
		visitor.setGoalsAgainst(visitor.getGoalsAgainst() + game.getGoals1());

		home.setGoalsDifference(home.getGoalsFor() - home.getGoalsAgainst());
		visitor.setGoalsDifference(visitor.getGoalsFor() - visitor.getGoalsAgainst());

		home.setGames(home.getGames() + 1);
		visitor.setGames(visitor.getGames() + 1);

	}

}
