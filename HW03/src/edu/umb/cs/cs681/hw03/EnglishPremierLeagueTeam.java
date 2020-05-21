package edu.umb.cs.cs681.hw03;

public class EnglishPremierLeagueTeam {
	private int gamesPlayed, gamesWon, gamesLost, gamesDrawn, goalDifference, totalPoints;
	private String teamName;
	
	public EnglishPremierLeagueTeam(String teamName, int gamesWon, int gamesDrawn, int gamesLost, int goalDifference) {
		this.teamName = teamName;
		this.gamesLost = gamesLost;
		this.gamesWon = gamesWon;
		this.gamesDrawn = gamesDrawn;
		this.goalDifference = goalDifference;
		this.gamesPlayed = gamesLost + gamesWon + gamesDrawn;
		this.totalPoints = (3 * gamesWon) + (1 * gamesDrawn);
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public int getGamesLost() {
		return gamesLost;
	}
	
	public int getGamesDrawn() {
		return gamesDrawn;
	}
	
	public int getGamesWon() {
		return gamesWon;
	}
	
	public int getTotalPoints() {
		return totalPoints;
	}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public int getGoalDifference() {
		return goalDifference;
	}
}
