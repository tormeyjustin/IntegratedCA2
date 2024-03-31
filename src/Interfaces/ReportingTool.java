/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author Justin
 *
 */
public interface ReportingTool {

    enum reportType {
        COURSE,
        STUDENT,
        LECTURER
    }

    enum reportFormat {
        TXT,
        CSV,
        CONSOLE
    }

    void outputReport(reportFormat format);

}
