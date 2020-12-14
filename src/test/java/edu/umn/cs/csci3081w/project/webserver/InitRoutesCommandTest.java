package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import edu.umn.cs.csci3081w.project.model.Bus;
import edu.umn.cs.csci3081w.project.model.PassengerFactory;
import edu.umn.cs.csci3081w.project.model.RandomPassengerGenerator;
import edu.umn.cs.csci3081w.project.model.Stop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InitRoutesCommandTest {

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
    ConfigManager cm = mock(ConfigManager.class);
    InitRoutesCommand initRoutesCommand = new InitRoutesCommand(cm);
    assertNotNull(initRoutesCommand);
  }

}
