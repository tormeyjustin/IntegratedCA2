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
public class TXTWriter {

    private String filePath;

    public TXTWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeLines(String text) throws IOException {
        try ( FileWriter writer = new FileWriter(filePath)) {
            writer.write(text);
        } catch (IOException e) {
            throw e;
        }
    }
}
