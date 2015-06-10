package de.lustin.flc.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "allGames", query = "SELECT g FROM Game g")
public class Game {

	/**
     */
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date played;

	/**
     */
	@NotNull
	@ManyToOne
	private Team team1;

	/**
     */
	@NotNull
	@ManyToOne
	private Team team2;

	/**
     */
	@NotNull
	private Integer goals1;

	/**
     */
	@NotNull
	private Integer goals2;

	public Date getPlayed() {
		return this.played;
	}

	public void setPlayed(Date played) {
		this.played = played;
	}

	public Team getTeam1() {
		return this.team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return this.team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Integer getGoals1() {
		return this.goals1;
	}

	public void setGoals1(Integer goals1) {
		this.goals1 = goals1;
	}

	public Integer getGoals2() {
		return this.goals2;
	}

	public void setGoals2(Integer goals2) {
		this.goals2 = goals2;
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
