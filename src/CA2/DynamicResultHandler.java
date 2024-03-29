/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Justin
 */
class DynamicResultHandler {
    
    public void processResultSet(ResultSet rs, OutputFormat format) throws SQLException, IOException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        StringBuilder sb = new StringBuilder();

        // Header
        for (int i = 1; i <= columnCount; i++) {
            sb.append(metaData.getColumnName(i));
            if (i < columnCount) sb.append(format.separator); // Don't add after last column
        }
        sb.append("\n");

        // Rows
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                sb.append(rs.getString(i));
                if (i < columnCount) sb.append(format.separator);
            }
            sb.append("\n");
        }

        switch (format) {
            case CONSOLE:
                System.out.println(sb.toString());
                break;
            case CSV:
                
            case TXT:
                
                try (PrintWriter out = new PrintWriter(new FileWriter("output.txt"))) {
                    out.println(sb.toString());
                }
                break;
        }
    }

    public enum OutputFormat {
        CONSOLE("", ""),
        CSV("output.csv", ","),
        TXT("output.txt", "\t");

        String defaultFilename;
        String separator;

        OutputFormat(String defaultFilename, String separator) {
            this.defaultFilename = defaultFilename;
            this.separator = separator;
        }
    }
    
}
