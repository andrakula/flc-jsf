package de.lustin.flc;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import de.lustin.flc.domain.Game;
import de.lustin.flc.domain.Team;
import de.lustin.flc.service.TeamService;

@ManagedBean(name = "teamsConverter")
@FacesConverter(forClass = Game.class)
public class TeamsConverter implements Converter, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2672678841598147624L;

	@Inject
	private TeamService teamService;

	public TeamsConverter() {
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.isEmpty()) {
			return null;
		}
		Long id = new Long(value);
		return teamService.findById(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.toString().isEmpty()) {
			return "";
		}
		Team t = (Team) value;
		Long id = t.getId();
		return id.toString();
	}
}
