package de.lustin.flc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import de.lustin.flc.domain.Game;
import de.lustin.flc.domain.Team;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

	@InjectMocks
	private GameService gs;

	@Test
	public void testCalculateGameHomeWon() {
		int gaHome = 3;
		int gfHome = 2;
		int gaVisitor = 7;
		int gfVisitor = 4;
		Team home = new Team("home", 5, gfHome, gaHome, gfHome - gaHome, 3, 2,
				1, 6);
		Team visitor = new Team("visitor", 7, gfVisitor, gaVisitor, gfVisitor
				- gfHome, 4, 2, 3, 9);

		Game g = new Game();
		g.setTeam1(home);
		g.setTeam2(visitor);
		g.setGoals1(2);
		g.setGoals2(1);

		gs.calculateGame(g);

		Assert.assertEquals(new Integer(8), home.getPoints());
		Assert.assertEquals(new Integer(7), visitor.getPoints());

		Assert.assertEquals(new Integer(gfHome + g.getGoals1()),
				home.getGoalsFor());
		Assert.assertEquals(new Integer(gaVisitor + g.getGoals1()),
				visitor.getGoalsAgainst());

		Assert.assertEquals(new Integer(gfVisitor + g.getGoals2()),
				visitor.getGoalsFor());
		Assert.assertEquals(new Integer(gaHome + g.getGoals2()),
				home.getGoalsAgainst());

		Assert.assertEquals(
				new Integer(gfHome + g.getGoals1() - gaHome - g.getGoals2()),
				home.getGoalsDifference());
		Assert.assertEquals(new Integer(gfVisitor + g.getGoals2() - gaVisitor
				- g.getGoals1()), visitor.getGoalsDifference());

		Assert.assertEquals(new Integer(3 + 1), home.getWons());
		Assert.assertEquals(new Integer(2 + 0), home.getDrawns());
		Assert.assertEquals(new Integer(1 + 0), home.getLosts());

		Assert.assertEquals(new Integer(6 + 1), home.getGames());
		Assert.assertEquals(new Integer(9 + 1), visitor.getGames());

		Assert.assertEquals(new Integer(4 + 0), visitor.getWons());
		Assert.assertEquals(new Integer(2 + 0), visitor.getDrawns());
		Assert.assertEquals(new Integer(3 + 1), visitor.getLosts());
	}

	@Test
	public void testCalculateGameHomeLost() {
		int gaHome = 3;
		int gfHome = 2;
		int gaVisitor = 7;
		int gfVisitor = 4;
		Team home = new Team("home", 5, gfHome, gaHome, gfHome - gaHome, 3, 2,
				1, 6);
		Team visitor = new Team("visitor", 7, gfVisitor, gaVisitor, gfVisitor
				- gfHome, 4, 2, 3, 9);

		Game g = new Game();
		g.setTeam1(home);
		g.setTeam2(visitor);
		g.setGoals1(2);
		g.setGoals2(4);

		gs.calculateGame(g);

		Assert.assertEquals(new Integer(5), home.getPoints());
		Assert.assertEquals(new Integer(10), visitor.getPoints());

		Assert.assertEquals(new Integer(gfHome + g.getGoals1()),
				home.getGoalsFor());
		Assert.assertEquals(new Integer(gaVisitor + g.getGoals1()),
				visitor.getGoalsAgainst());

		Assert.assertEquals(new Integer(gfVisitor + g.getGoals2()),
				visitor.getGoalsFor());
		Assert.assertEquals(new Integer(gaHome + g.getGoals2()),
				home.getGoalsAgainst());

		Assert.assertEquals(
				new Integer(gfHome + g.getGoals1() - gaHome - g.getGoals2()),
				home.getGoalsDifference());
		Assert.assertEquals(new Integer(gfVisitor + g.getGoals2() - gaVisitor
				- g.getGoals1()), visitor.getGoalsDifference());

		Assert.assertEquals(new Integer(3 + 0), home.getWons());
		Assert.assertEquals(new Integer(2 + 0), home.getDrawns());
		Assert.assertEquals(new Integer(1 + 1), home.getLosts());

		Assert.assertEquals(new Integer(6 + 1), home.getGames());
		Assert.assertEquals(new Integer(9 + 1), visitor.getGames());

		Assert.assertEquals(new Integer(4 + 1), visitor.getWons());
		Assert.assertEquals(new Integer(2 + 0), visitor.getDrawns());
		Assert.assertEquals(new Integer(3 + 0), visitor.getLosts());
	}

	@Test
	public void testCalculateGameDrawn() {
		int gaHome = 3;
		int gfHome = 2;
		int gaVisitor = 7;
		int gfVisitor = 4;
		Team home = new Team("home", 5, gfHome, gaHome, gfHome - gaHome, 3, 2,
				1, 6);
		Team visitor = new Team("visitor", 7, gfVisitor, gaVisitor, gfVisitor
				- gfHome, 4, 2, 3, 9);

		Game g = new Game();
		g.setTeam1(home);
		g.setTeam2(visitor);
		g.setGoals1(0);
		g.setGoals2(0);

		gs.calculateGame(g);

		Assert.assertEquals(new Integer(6), home.getPoints());
		Assert.assertEquals(new Integer(8), visitor.getPoints());

		Assert.assertEquals(new Integer(gfHome + g.getGoals1()),
				home.getGoalsFor());
		Assert.assertEquals(new Integer(gaVisitor + g.getGoals1()),
				visitor.getGoalsAgainst());

		Assert.assertEquals(new Integer(gfVisitor + g.getGoals2()),
				visitor.getGoalsFor());
		Assert.assertEquals(new Integer(gaHome + g.getGoals2()),
				home.getGoalsAgainst());

		Assert.assertEquals(
				new Integer(gfHome + g.getGoals1() - gaHome - g.getGoals2()),
				home.getGoalsDifference());
		Assert.assertEquals(new Integer(gfVisitor + g.getGoals2() - gaVisitor
				- g.getGoals1()), visitor.getGoalsDifference());

		Assert.assertEquals(new Integer(3 + 0), home.getWons());
		Assert.assertEquals(new Integer(2 + 1), home.getDrawns());
		Assert.assertEquals(new Integer(1 + 0), home.getLosts());

		Assert.assertEquals(new Integer(6 + 1), home.getGames());
		Assert.assertEquals(new Integer(9 + 1), visitor.getGames());

		Assert.assertEquals(new Integer(4 + 0), visitor.getWons());
		Assert.assertEquals(new Integer(2 + 1), visitor.getDrawns());
		Assert.assertEquals(new Integer(3 + 0), visitor.getLosts());
	}
}
