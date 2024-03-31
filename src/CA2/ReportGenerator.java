/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Justin
 */
public class ReportGenerator {
    
    public enum OutputFormat {
        TXT,
        CSV,
        CONSOLE
}
    
    public static <T> List<String> generateReportData(ArrayList<T> items) {
        List<String> reportLines = new ArrayList<>();
        
        if (items.isEmpty()) {
            System.out.println("The list is empty.");
            return reportLines; // return an empty list
        }

        // Prepare headers using reflection
        Class<?> clazz = items.get(0).getClass();
        ArrayList<Method> getters = new ArrayList<>();
        StringBuilder headerLine = new StringBuilder();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                getters.add(method);
                String headerName = method.getName().substring(3); // Remove "get"
                headerLine.append(headerName).append(",");
            }
        }

        if (headerLine.length() > 0) {
            headerLine.setLength(headerLine.length() - 1); // Remove the last comma
            reportLines.add(headerLine.toString());
        }

        // Collect data
        for (T item : items) {
            StringBuilder dataLine = new StringBuilder();
            for (Method getter : getters) {
                try {
                    Object value = getter.invoke(item); // Get property value
                    dataLine.append(value).append(",");
                } catch (ReflectiveOperationException e) {
                    System.out.println("Error accessing methods using reflection");
                }
            }
            // Remove the last comma, add to reportLines
            if (dataLine.length() > 0) {
                dataLine.setLength(dataLine.length() - 1); // Remove the last comma
                reportLines.add(dataLine.toString());
            }
        }
        
        return reportLines;
    }

    public static void writeReportToFile(List<String> reportLines, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : reportLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
