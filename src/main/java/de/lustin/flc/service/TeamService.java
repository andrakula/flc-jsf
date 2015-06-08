package de.lustin.flc.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.lustin.flc.domain.Team;
import de.lustin.flc.store.TeamsStore;

@Stateless
public class TeamService {

	@Inject
	private TeamsStore teamsStore;

	public Team createTeam(Team createdTeam) {
		createdTeam.setPoints(0);
		createdTeam.setGames(0);

		return createdTeam;
	}

	public List<Team> getAllTeams() {
		return teamsStore.all();
	}

	public void save(Team t) {
		teamsStore.save(t);
	}

}
