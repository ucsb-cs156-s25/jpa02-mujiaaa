package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Mujia C.", Developer.getName());
    }

    @Test
    public void getName_returns_correct_githubId() {
        assertEquals("mujiaaa", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-02", t.getName());
        assertTrue(t.getMembers().contains("Ayala W."),"Team should contain Ayala W.");
        assertTrue(t.getMembers().contains("Evania C"),"Team should contain Evania C");
        assertTrue(t.getMembers().contains("Mujia C."),"Team should contain Mujia C.");
        assertTrue(t.getMembers().contains("Roy R."),"Team should contain Roy R.");
        assertTrue(t.getMembers().contains("Shiyuan W."),"Team should contain Shiyuan W.");
        assertTrue(t.getMembers().contains("Xinyan Z."),"Team should contain Xinyan Z.");
    }

}
