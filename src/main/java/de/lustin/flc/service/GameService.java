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
//		gamesStore.save(t);
		saveUndUpdate(g);
	}
	
	public void saveUndUpdate(Game game) {
		Team team1 = game.getTeam1();
		Team team2 = game.getTeam2();
		
		if (game.getGoals1() > game.getGoals2()){
			team1.setPoints(team1.getPoints()+3);
		}else if (game.getGoals1() < game.getGoals2()) {
			team2.setPoints(team2.getPoints()+3);
		}else{
			team1.setPoints(team1.getPoints()+1);
			team2.setPoints(team2.getPoints()+1);
		}
		
		
		team1.setGames(team1.getGames()+1);
		team2.setGames(team2.getGames()+1);
		
		gamesStore.save(game);
		teamsStore.save(team1);
		teamsStore.save(team2);
		
	}

}
