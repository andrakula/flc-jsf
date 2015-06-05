package de.lustin.flc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PageController {
	
	public String createTeam(){
	    return "createTeam"; 
	}

}
