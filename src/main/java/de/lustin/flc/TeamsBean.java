package de.lustin.flc;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.lustin.flc.domain.Team;

@ManagedBean(name = "teamsBean")
@SessionScoped
public class TeamsBean {

	List<Team> teams = new ArrayList<Team>();
	Team createdTeam = new Team(); 

	public List<Team> getTeams() {

//		teams.add(createTeam("Düsseldorf"));
//		teams.add(createTeam("Köln"));
//		teams.add(createTeam("Aachen"));

		return teams;

	}

//	private Team createTeam(String name) {
//		Team t = new Team();
//		t.setName(name);
//		t.setPoints(0);
//		t.setGames(0);
//		return t;
//	}

	public Team getNewTeam() {
		return new Team();
	}
	
	public String Submit() {
		createdTeam.setPoints(0);
		createdTeam.setGames(0);
		teams.add(createdTeam);
		return "teams";
	}

	public Team getCreatedTeam() {
		return createdTeam;
	}

	public void setCreatedTeam(Team createdTeam) {
		this.createdTeam = createdTeam;
	}
	
	public String createTeam() {
		createdTeam = new Team();
		return "createTeam"; 
	}

}
