package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonObject;
import edu.umn.cs.csci3081w.project.model.Bus;
import edu.umn.cs.csci3081w.project.model.PassengerFactory;
import edu.umn.cs.csci3081w.project.model.RandomPassengerGenerator;
import edu.umn.cs.csci3081w.project.model.Stop;
import javax.websocket.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListenStopCommandTest {

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
    VisualizationSimulator visualizationSimulator = mock(VisualizationSimulator.class);
    ListenStopCommand listenStopCommand = new ListenStopCommand(visualizationSimulator);
    assertNotNull(listenStopCommand);
  }

  /**
   * Testing execute.
   */
  @Test
  public void testExecute() {
    MyWebServerSession myWebServerSessionSpy = spy(MyWebServerSession.class);
    doNothing().when(myWebServerSessionSpy).sendJson(Mockito.isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    myWebServerSessionSpy.onOpen(sessionDummy);
    JsonObject commandFromClient = new JsonObject();
    commandFromClient.addProperty("command", "listenStop");
    commandFromClient.addProperty("id", 0);
    myWebServerSessionSpy.onMessage(commandFromClient.toString());
    verify(myWebServerSessionSpy).onMessage("{\"command\":\"listenStop\",\"id\":0}");
  }
}
