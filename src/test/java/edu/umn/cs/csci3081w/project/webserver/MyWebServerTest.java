package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import edu.umn.cs.csci3081w.project.model.Bus;
import edu.umn.cs.csci3081w.project.model.BusData;
import edu.umn.cs.csci3081w.project.model.PassengerFactory;
import edu.umn.cs.csci3081w.project.model.Position;
import edu.umn.cs.csci3081w.project.model.RandomPassengerGenerator;
import edu.umn.cs.csci3081w.project.model.RouteData;
import edu.umn.cs.csci3081w.project.model.Stop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyWebServerTest {

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
   * Testing updating bus.
   */
  @Test
  public void testUpdateBus() {
    MyWebServer myWebServer = new MyWebServer();
    Position position = mock(Position.class);
    BusData busData = new BusData("test", position, 0, 30);
    myWebServer.updateBus(busData, false);
    assertEquals(1, myWebServer.busses.size());
    myWebServer.updateBus(busData, false);
    assertEquals(1, myWebServer.busses.size());
    myWebServer.updateBus(busData, true);
    assertEquals(0, myWebServer.busses.size());
  }

  /**
   * Testing updating route.
   */
  @Test
  public void testUpdateRoute() {
    MyWebServer myWebServer = new MyWebServer();
    RouteData routeData = new RouteData();
    myWebServer.updateRoute(routeData, false);
    assertEquals(1, myWebServer.routes.size());
    myWebServer.updateRoute(routeData, false);
    assertEquals(1, myWebServer.routes.size());
    myWebServer.updateRoute(routeData, true);
    assertEquals(0, myWebServer.routes.size());
  }
}