package de.lustin.flc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "allTeams", query = "SELECT t FROM Team t ORDER BY t.points DESC"),
		@NamedQuery(name = "findTeamById", query = "SELECT t FROM Team t WHERE t.id = :id") })
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
