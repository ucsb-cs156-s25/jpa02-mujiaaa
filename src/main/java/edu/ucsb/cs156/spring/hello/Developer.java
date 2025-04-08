package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Mujia C.";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "mujiaaa";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("s25-02");
        team.addMember("Ayala W.");
        team.addMember("Evania C");
        team.addMember("Mujia C.");
        team.addMember("Roy R.");
        team.addMember("Shiyuan W.");
        team.addMember("Xinyan Z.");
        return team;
    }
}
