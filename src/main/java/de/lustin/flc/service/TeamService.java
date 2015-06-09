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

	public List<Team> getAllTeams() {
		return teamsStore.all();
	}

	public void save(Team t) {
		teamsStore.save(t);
	}

}
