package de.lustin.flc;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import de.lustin.flc.domain.Game;
import de.lustin.flc.service.GameService;

@ManagedBean(name = "gamesBean")
@RequestScoped
public class GamesBean {
	
	private Game createdGame = new Game();

	@Inject
	private GameService gameService;

	public List<Game> getGames() {
		return gameService.getAllGames();

	}

	public String createGame() {
		createdGame.setPlayed(new Date());
		gameService.save(createdGame);
		return "games";
	}

	public Game getCreatedGame() {
		return createdGame;
	}

	public void setCreatedGame(Game createdGame) {
		this.createdGame = createdGame;
	}
}
