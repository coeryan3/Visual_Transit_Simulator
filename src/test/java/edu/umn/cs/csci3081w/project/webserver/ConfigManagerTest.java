package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.umn.cs.csci3081w.project.model.Bus;
import edu.umn.cs.csci3081w.project.model.PassengerFactory;
import edu.umn.cs.csci3081w.project.model.RandomPassengerGenerator;
import edu.umn.cs.csci3081w.project.model.Route;
import edu.umn.cs.csci3081w.project.model.Stop;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConfigManagerTest {

  /**
   * Setup deterministic operations before each test runs.
   */
  @BeforeEach
  public void setUp() {
    PassengerFactory.DETERMINISTIC = true;
    PassengerFactory.DETERMINISTIC_NAMES_COUNT = 0;
    PassengerFactory.DETERMINISTIC_DESTINATION_COUNT = 0;
    RandomPassengerGenerator.DETERMINISTIC = true;
  }

  /**
   * Testing constructor.
   */
  @Test
  public void testConstructorNormal() {
    ConfigManager configManager = new ConfigManager();
    List<Route> routes = configManager.getRoutes();
    assertEquals(0, routes.size());
  }

  /**
   * Testing readConfig function.
   */
  @Test
  public void testReadConfig() {
    ConfigManager configManager = new ConfigManager();
    configManager.readConfig(getClass().getClassLoader().getResource("config.txt").getFile());
    List<Route> routes = configManager.getRoutes();
    assertEquals(4, routes.size());
    Route eastBound = routes.get(0);
    Stop stop0 = eastBound.getStops().get(0);
    assertEquals(-93.243774, stop0.getLatitude());
    assertEquals(44.972392, stop0.getLongitude());
  }
}
