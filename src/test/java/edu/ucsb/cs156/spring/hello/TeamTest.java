package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_sameObj_returnsT() {
        boolean result = team.equals(team);
        assertEquals(true, result);
    }
    @Test
    public void equals_diffClass_returnsF() {
        Object notATeam = "I am not a team";
        boolean areEqual = team.equals(notATeam);
        assertEquals(false, areEqual);
    }
    @Test
    public void equals_sameNameDiffMem_returnsF() {
        Team otherTeam = new Team("test-team");
        otherTeam.addMember("Alice");
        boolean result = team.equals(otherTeam);
        assertEquals(false, result);
    }
    @Test
    public void equals_diffNameSameMem_returnsF() {
        Team otherTeam = new Team("different-team");
        team.addMember("Alice");
        otherTeam.addMember("Alice");
        assertEquals(false, team.equals(otherTeam));
    }
    @Test
    public void equals_sameNameAndMembers_returnsT() {
        Team copy = new Team("test-team");
        team.addMember("Alice");
        copy.addMember("Alice");
        boolean areEqual = team.equals(copy);
        assertEquals(true, areEqual);
    }
    @Test
    public void hashCode_sameContent_sameHashCode() {
        Team team1 = new Team("foo");
        Team team2 = new Team("foo");
        team1.addMember("bar");
        team2.addMember("bar");
        int hash1 = team1.hashCode();
        int hash2 = team2.hashCode();
        assertEquals(hash1, hash2);
    }
    @Test
    public void hashCode_diffContent_diffHashCode() {
        Team team1 = new Team("foo");
        Team team2 = new Team("fol");
        team1.addMember("bar");
        team2.addMember("baa");
        int hash1 = team1.hashCode();
        int hash2 = team2.hashCode();
        assertEquals(false, hash1 == hash2);
    }
    @Test
    public void hashCode_returnsExpected() {
        Team testTeam = new Team("foo");
        java.util.ArrayList<String> memberList = new java.util.ArrayList<String>();
        memberList.add("bar");
        testTeam.setMembers(memberList);
        int calculatedHash = "foo".hashCode() | memberList.hashCode();
        
        assertEquals(calculatedHash, testTeam.hashCode());
    }
}
