/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Justin
 * 
 */

public class TXTWriter {
    private String filePath;

    public TXTWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeLines(List<String> lines) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String line : lines) {
                writer.write(line);
                writer.write("\n"); // Append a newline after each line
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
