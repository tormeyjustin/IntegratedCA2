/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileOutput;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Justin
 * 
 */

public class CSVWriter {
    private String filePath;

    public CSVWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeCSV(String csvData) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(csvData);
        } catch (IOException e) {
            throw e;
        }
    }
}