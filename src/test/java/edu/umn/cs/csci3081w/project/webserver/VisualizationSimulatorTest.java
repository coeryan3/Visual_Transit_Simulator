package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import edu.umn.cs.csci3081w.project.model.Bus;
import edu.umn.cs.csci3081w.project.model.PassengerFactory;
import edu.umn.cs.csci3081w.project.model.RandomPassengerGenerator;
import edu.umn.cs.csci3081w.project.model.Stop;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisualizationSimulatorTest {

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
    MyWebServer webI = mock(MyWebServer.class);
    ConfigManager configM = mock(ConfigManager.class);
    MyWebServerSession session = mock(MyWebServerSession.class);
    VisualizationSimulator visualizationSimulator = new VisualizationSimulator(webI, configM,
        session);
    assertNotNull(visualizationSimulator);
  }

  /**
   * Testing start method.
   */
  @Test
  public void testStart() {
    MyWebServer webI = mock(MyWebServer.class);
    ConfigManager configM = mock(ConfigManager.class);
    MyWebServerSession session = mock(MyWebServerSession.class);
    VisualizationSimulator visualizationSimulator = new VisualizationSimulator(webI, configM,
        session);
    List<Integer> busStartTimingsParam = new ArrayList<Integer>();
    busStartTimingsParam.add(1);
    busStartTimingsParam.add(2);
    busStartTimingsParam.add(3);
    int numTimeStepsParam = 3;
    visualizationSimulator.start(busStartTimingsParam, numTimeStepsParam);
    assertEquals(3, visualizationSimulator.getNumTimeSteps());
  }
}
