package edu.umn.cs.csci3081w.project.webserver;

import java.io.FileWriter;
import java.io.IOException;

public final class CsvWriterSingleton {
  private static CsvWriterSingleton instance;
  private FileWriter csvWriter;

  private CsvWriterSingleton() {
    try {
      csvWriter = new FileWriter("simulationData.csv");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets the unique instance of the csv writer.
   * If an instance does not already exist, a new one is constructed.
   *
   * @return the unique instance of the csv writer.
   */
  public static CsvWriterSingleton getInstance() {
    if (instance == null) {
      instance = new CsvWriterSingleton();
    }
    return instance;
  }

  /**
   * This method writes formatted data to the csv file.
   *
   * @param data Formatted string of data to be written to the csv.
   */
  public void writeToFile(String data) {
    try {
      csvWriter.write(data);
      csvWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method closes the current csv file and resets the instance to null.
   */
  public void closeFile() {
    try {
      csvWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    instance = null;
  }
}
