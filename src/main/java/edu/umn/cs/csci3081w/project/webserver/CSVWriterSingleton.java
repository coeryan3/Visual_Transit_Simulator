package edu.umn.cs.csci3081w.project.webserver;

import java.io.FileWriter;
import java.io.IOException;

public final class CSVWriterSingleton {
  private static CSVWriterSingleton instance;
  private FileWriter csvWriter;

  private CSVWriterSingleton() {
    try {
      csvWriter = new FileWriter("simulationData.csv");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static CSVWriterSingleton getInstance() {
    if (instance == null) {
      instance = new CSVWriterSingleton();
    }
    return instance;
  }

  public void writeToFile(String data) {
    try {
      csvWriter.write(data);
      csvWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void closeFile() {
    try {
      csvWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    instance = null;
  }
}
