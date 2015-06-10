package de.lustin.flc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "allTeams", query = "SELECT t FROM Team t")
public class Team {

	private String name;

	private Integer points;

	private Integer games;

	public Team() {
	}

	public Team(String name, Integer points, Integer games) {
		super();
		this.name = name;
		this.points = points;
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

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
}
