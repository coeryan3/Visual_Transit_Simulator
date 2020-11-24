package edu.umn.cs.csci3081w.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    Bus.TESTING = true;
    Stop.TESTING = true;
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
    ConcreteBusSubject concreteBusSubject = new ConcreteBusSubject(null);
    SmallBus testSmallBus = TestUtils.createSmallBus();
    concreteBusSubject.registerBusObserver(testSmallBus);
    concreteBusSubject.notifyBusObservers();
    assertTrue(testSmallBus.getTestingOutput() != null);
  }
}
