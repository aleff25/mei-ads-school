package pt.iscte.mei.school.files.excel.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.mei.school.appointments.application.dto.ReadXLSXFileAppointmentDTO;
import pt.iscte.mei.school.appointments.model.Appointment;
import pt.iscte.mei.school.classrooms.model.Caracteristic;
import pt.iscte.mei.school.classrooms.model.Classroom;
import pt.iscte.mei.school.courses.model.Course;
import pt.iscte.mei.school.courses.model.Shift;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Id", "Title", "Description", "Published"};
    static String SHEET = "Tutorials";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static ByteArrayInputStream appointmentsToExcel(List<Appointment> appointments) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (Appointment tutorial : appointments) {
                Row row = sheet.createRow(rowIdx++);

                //TODO: Add others values to fill the cells
                row.createCell(0).setCellValue(tutorial.getId());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

    public static List<ReadXLSXFileAppointmentDTO> excelToAppointments(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

            List<ReadXLSXFileAppointmentDTO> data = new ArrayList<>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Course.CourseBuilder courseBuilder = Course.builder();
                Classroom.ClassroomBuilder classroomBuilder = Classroom.builder();
                Appointment.AppointmentBuilder appointmentBuilder = Appointment.builder();
                String startHour = "", endHour = "";
                Date appointmentDate = null;

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            courseBuilder.location(currentCell.getStringCellValue());
                            break;
                        case 1:
                            courseBuilder.curricularUnit(currentCell.getStringCellValue());
                            break;
                        case 2:
                            //TODO: Add rule to get correct shift
                            courseBuilder.shift(Shift.PostWork);
                            break;
                        case 3:
                            courseBuilder.capacityUsed((int) currentCell.getNumericCellValue());
                            break;
                        case 5:
                            courseBuilder.name(currentCell.getStringCellValue());
                            break;
                        case 7:
                            //TODO: Search if day of week is really necessary
                            break;
                        case 8:
                            startHour = currentCell.getStringCellValue();
                            break;
                        case 9:
                            endHour = currentCell.getStringCellValue();
                            break;
                        case 10:
                            appointmentDate = currentCell.getDateCellValue();
                            break;
                        case 11:
                            //TODO: Get the correct caracteristic
                            appointmentBuilder.caracteristic(Caracteristic.CLASSROOM_MASTER);
                            break;
                        case 12:
                            classroomBuilder.name(currentCell.getStringCellValue());
                            break;
                        case 13:
                            classroomBuilder.capacity((int) currentCell.getNumericCellValue());
                            break;
                        case 14:
                            //TODO: For each caracterisct instantiate a new object to set in the class as list
                            //classroomBuilder.caracteristics()
                            break;
                        default:
                            break;
                    }

                    cellIdx++;
                }

//                appointmentDate.setTime(Long.parseLong(startHour.split(":")[0]));
//
//                LocalDateTime startAppointmentDate = LocalDateTime.parse(appointmentDate.toString(), formatter);
//
//                appointmentDate.setTime(Long.parseLong(endHour.split(":")[0]));
//                LocalDateTime endAppointmentDate = LocalDateTime.parse(appointmentDate.toString() + " " + endHour, formatter);
//
//                appointmentBuilder.startDate(startAppointmentDate);
//                appointmentBuilder.endDate(endAppointmentDate);

                ReadXLSXFileAppointmentDTO dto = ReadXLSXFileAppointmentDTO.from(courseBuilder.build(),
                        appointmentBuilder.build(), classroomBuilder.build());

                data.add(dto);
            }

            workbook.close();

            return data;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
