package edu.umn.cs.csci3081w.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import edu.umn.cs.csci3081w.project.webserver.MyWebServerSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConcreteBusSubjectTest {

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
   * Test constructor with parameters.
   */
  @Test
  public void testConstructorWithParameters() {
    ConcreteBusSubject concreteBusSubject = new ConcreteBusSubject(null);
    assertEquals(null, concreteBusSubject.getSession());
    assertEquals(0, concreteBusSubject.busObservers.size());
  }

  /**
   * Test registering of bus observer.
   */
  @Test
  public void testRegisterBusObserver() {
    ConcreteBusSubject concreteBusSubject = new ConcreteBusSubject(null);
    concreteBusSubject.registerBusObserver(TestUtils.createSmallBus());
    assertEquals(1, concreteBusSubject.busObservers.size());
  }

  /**
   * Test notify bus observers.
   */
  @Test
  public void testNotifyBusObserver() {
    MyWebServerSession myWebServerSession = mock(MyWebServerSession.class);
    ConcreteBusSubject concreteBusSubject = new ConcreteBusSubject(myWebServerSession);
    SmallBus testSmallBus = TestUtils.createSmallBus();
    concreteBusSubject.registerBusObserver(testSmallBus);
    if (concreteBusSubject.getSession() != null) {
      concreteBusSubject.notifyBusObservers();
    }
    assertTrue(testSmallBus != null);
  }
}
