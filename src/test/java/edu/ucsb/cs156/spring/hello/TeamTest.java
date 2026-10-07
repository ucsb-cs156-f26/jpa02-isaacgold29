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
    public void equals_correct_for_same_object() {
        assertEquals(team.equals(team), true);
    }

    @Test 
    public void equals_correct_for_different_class() {
        assertEquals(team.equals(team.name), false);
    }

    @Test
    public void equals_correct_for_equivalent_instance() {
        Team team2 = new Team("test-team");
        Team team3 = new Team("test-team-different-name");
        Team team4 = new Team("test-team-");
        team4.addMember("test-member");
        assertEquals(team.equals(team2), true);
        assertEquals(team.equals(team3), false);
        assertEquals(team.equals(team4), false);
    }

    @Test 
    public void hashCode_behaves_properly() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test 
    public void hashCode_returns_expected() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
