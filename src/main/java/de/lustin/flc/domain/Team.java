package de.lustin.flc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "allTeams", query = "SELECT t FROM Team t ORDER BY t.points DESC, t.goalsDifference DESC, t.wons DESC"),
		@NamedQuery(name = "findTeamById", query = "SELECT t FROM Team t WHERE t.id = :id") })
public class Team {

	private String name;

	private Integer points = 0;
	
	private Integer goalsFor= 0;
	
	private Integer goalsAgainst= 0;
	
	private Integer goalsDifference= 0;
	
	private Integer wons= 0;
	
	private Integer drawns= 0;
	
	private Integer losts= 0;

	private Integer games= 0;

	public Team() {
	}	

	public Team(String name) {
		super();
		this.name = name;
	}

	public Team(String name, Integer points, Integer goalsFor,
			Integer goalsAgainst, Integer goalsDifference, Integer wons, Integer drawns, Integer losts,
			Integer games) {
		super();
		this.name = name;
		this.points = points;
		this.goalsFor = goalsFor;
		this.goalsAgainst = goalsAgainst;
		this.goalsDifference = goalsDifference;
		this.wons = wons;
		this.drawns = drawns;
		this.losts = losts;
		this.games = games;
	}



	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getGames() {
		return this.games;
	}

	public void setGames(Integer games) {
		this.games = games;
	}	

	public Integer getGoalsFor() {
		return goalsFor;
	}

	public void setGoalsFor(Integer goalsFor) {
		this.goalsFor = goalsFor;
	}

	public Integer getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(Integer goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public Integer getWons() {
		return wons;
	}

	public void setWons(Integer wons) {
		this.wons = wons;
	}

	public Integer getDrawns() {
		return drawns;
	}

	public void setDrawns(Integer drawns) {
		this.drawns = drawns;
	}

	public Integer getLosts() {
		return losts;
	}

	public void setLosts(Integer losts) {
		this.losts = losts;
	}

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "de.lustin.flc.domain.Team[ id=" + id + " ]";
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}	

	public Integer getGoalsDifference() {
		return goalsDifference;
	}

	public void setGoalsDifference(Integer goalsDifference) {
		this.goalsDifference = goalsDifference;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Team)) {
			return false;
		}
		Team other = (Team) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
}
