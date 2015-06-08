package de.lustin.flc;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import de.lustin.flc.domain.Team;
import de.lustin.flc.service.TeamService;

@ManagedBean(name = "teamsBean")
@RequestScoped
public class TeamsBean {
	
	private Team createdTeam = new Team("",0,0);

	@Inject
	private TeamService teamService;

	public List<Team> getTeams() {
		return teamService.getAllTeams();

	}

	public String createTeam() {
		createdTeam = teamService.createTeam(createdTeam);
		return "teams";
	}

	public Team getCreatedTeam() {
		return createdTeam;
	}

	public void setCreatedTeam(Team createdTeam) {
		this.createdTeam = createdTeam;
	}
}
