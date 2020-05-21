package edu.umb.cs.cs681.hw20;

import java.util.*;
import java.util.stream.Collectors;

public class LeagueTableMain {

    public static void main(String[] args) {

        ArrayList<EnglishPremierLeagueTeam> teams = new ArrayList<EnglishPremierLeagueTeam>();
  
		teams.add(new EnglishPremierLeagueTeam("Arsenal", 9, 13, 6, 4));
		teams.add(new EnglishPremierLeagueTeam("Burnley", 11, 6, 12, -6));
		teams.add(new EnglishPremierLeagueTeam("Brighton & Hove Albion", 6, 11, 12, -8));
		teams.add(new EnglishPremierLeagueTeam("Chelsea", 14, 6, 9, 12));
		teams.add(new EnglishPremierLeagueTeam("Crystal Palace", 10, 9, 10, -6));
		teams.add(new EnglishPremierLeagueTeam("Liverpool", 27, 1, 1, 45));
		teams.add(new EnglishPremierLeagueTeam("Bournemouth", 7, 6, 16, -18));
		teams.add(new EnglishPremierLeagueTeam("Manchester City", 18, 3, 7, 37));
		teams.add(new EnglishPremierLeagueTeam("Norwich City", 5, 6, 18, -27));
		teams.add(new EnglishPremierLeagueTeam("Aston Villa", 7, 4, 17, -22));
		teams.add(new EnglishPremierLeagueTeam("Everton", 10, 7, 12, -9));
		teams.add(new EnglishPremierLeagueTeam("Leicester City", 16, 5, 8, 30));
		teams.add(new EnglishPremierLeagueTeam("Newcastle United", 9, 8, 12, -16));
		teams.add(new EnglishPremierLeagueTeam("Sheffield United", 11, 10, 7, 5));
		teams.add(new EnglishPremierLeagueTeam("Manchester United", 12, 9, 8, 14));
		teams.add(new EnglishPremierLeagueTeam("Tottenham Hotspur", 11, 8, 10, 7));
		teams.add(new EnglishPremierLeagueTeam("Southampton", 10, 4, 15, -17));
		teams.add(new EnglishPremierLeagueTeam("Wolves", 10, 13, 6, 7));
		teams.add(new EnglishPremierLeagueTeam("Watford", 6, 9, 14, -17));
		teams.add(new EnglishPremierLeagueTeam("West Ham United", 7, 6, 16, -15));
					
					
		//Use parallel streaming to find the lowest points in the League.			
		Integer lowestPoints = teams.stream().parallel().
			map((EnglishPremierLeagueTeam team) -> team.getTotalPoints()).
			reduce(0, (result, teamPoints) -> 
				{if (result == 0) 
					return teamPoints; 
				else if (teamPoints < result) 
					return teamPoints; 
				else 
					return result;},
				(finalResult,intermediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " ->\t FinalResult: " + finalResult + "\tIntermediateResult: " + intermediateResult);
					if (finalResult < intermediateResult) {
						return finalResult;
					}
					else {
						return intermediateResult;
					}
					});
					
					
		//Use parallel streaming to find the highest points in the League.			
		Integer highestPoints = teams.stream().parallel().
			map((EnglishPremierLeagueTeam team) -> team.getTotalPoints()).
			reduce(0, (result, teamPoints) -> 
				{if (result == 0) 
					return teamPoints; 
				else if (teamPoints > result) 
					return teamPoints; 
				else 
					return result;}, 
				(finalResult,intermediateResult) -> {
			    	System.out.println(Thread.currentThread().getName() + " ->\t FinalResult: " + finalResult + "\tIntermediateResult: " + intermediateResult);
					if (finalResult > intermediateResult) {
						return finalResult;
					}
					else {
						return intermediateResult;
					}
					});
		
		//Sort League Table by total points, then by goal difference, then by name
		Comparator<EnglishPremierLeagueTeam> byPoints = Comparator.comparing
				((EnglishPremierLeagueTeam team) -> team.getTotalPoints());
		
		Comparator<EnglishPremierLeagueTeam> byGoalDiff = Comparator.comparing
				((EnglishPremierLeagueTeam team) -> team.getGoalDifference());
		
		Comparator<EnglishPremierLeagueTeam> byName = Comparator.comparing
				((EnglishPremierLeagueTeam team) -> team.getTeamName(), Comparator.reverseOrder());
		
		
		//Use the stream API to get the sorted League table
		List<EnglishPremierLeagueTeam> sortedTable = (teams.stream()).sorted
				(byPoints.thenComparing(byGoalDiff).thenComparing(byName)).collect(Collectors.toList());
				
		
		//Reverse the table so to get the arrangement in descending order
		Collections.reverse(sortedTable);
		
		//Print lowest and highest points
		System.out.println("\n\nLowest Points in League Table: " + lowestPoints);
		System.out.println("---------------------------------");
		System.out.println("\n\nHighest Points in League Table: " + highestPoints);
		System.out.println("----------------------------------");
		
		
		//Print the League table
		System.out.println("\n\n*****************************************************"
				+ "**************************************");
		System.out.format("%-22s%15s%7s%7s%7s%20s%10s", "Team", "Games Played", 
				"Won", "Drawn", "Lost", "Goal Difference", "Points");
		System.out.println();
		System.out.println("-----------------------------------------------------"
				+ "--------------------------------------");
		
		for (EnglishPremierLeagueTeam leagueTeam: sortedTable) {
			System.out.format("%-22s%15d%7d%7d%7d%20d%10d", leagueTeam.getTeamName(),
					leagueTeam.getGamesPlayed(),leagueTeam.getGamesWon(),
					leagueTeam.getGamesDrawn(),leagueTeam.getGamesLost(),
					leagueTeam.getGoalDifference(),leagueTeam.getTotalPoints());
			System.out.println();
		}
    }
}