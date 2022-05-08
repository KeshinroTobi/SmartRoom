package DataObject;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.time.OffsetDateTime;
import java.util.Iterator;

public class ReadData {
    static int count = 0;
    public ReadData() throws SQLException {
        String username = "postgres";
        String password = "BOOKmarks12";
        String URL = "jdbc:postgresql://localhost/smartroom";
        Connection connection = null;
        try {
            //file location
            FileInputStream file =
                    new FileInputStream("C:\\Users\\keshi\\Desktop\\Smart Room\\src\\Data\\smartroom_exampledata (3).xlsx");
            Workbook workbook = new XSSFWorkbook(file);
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            connection = DriverManager.getConnection(URL, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            System.out.println(" ");
            while (sheetIterator.hasNext()){
                Sheet sh = sheetIterator.next();
                System.out.println(sh.getSheetName());
                System.out.println("-------------------");
                        int rows = sh.getLastRowNum();
                        if(sh.getSheetName().equals("Room")){
                            try {
                                for (int r = 1; r<=rows; r++) { //we do not need the header
                                    XSSFRow row1 = (XSSFRow) sh.getRow(r);
                                    String name = row1.getCell(0).getStringCellValue();
                                    int size = (int) row1.getCell(1).getNumericCellValue();
                                    int id = (int) row1.getCell(2).getNumericCellValue();
                                    insertRoom(connection, name, size, id);
                                }

                            }
                            catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            System.out.println(count + " records inserted"); //number of rows inserted
                            count = 0;
                            System.out.println("  ");
                            sh = sheetIterator.next();
                            System.out.println(sh.getSheetName());
                            System.out.println("-------------------");
                        }
                        if(sh.getSheetName().equals("Ventilator")){
                            rows = sh.getLastRowNum();
                            try {
                                for (int r = 1; r<=rows; r++) { //we do not need the header
                                    XSSFRow row1 = (XSSFRow) sh.getRow(r);
                                    int id = (int) row1.getCell(0).getNumericCellValue();
                                    int room_id = (int) row1.getCell(1).getNumericCellValue();
                                    insertVentilator(connection, id,room_id);
                                }
                            }
                            catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            System.out.println(count + " records inserted"); //number of rows inserted
                            count = 0;
                            System.out.println("  ");
                            sh = sheetIterator.next();
                            System.out.println(sh.getSheetName());
                            System.out.println("-------------------");

                        }
                        if(sh.getSheetName().equals("Door")){
                            rows = sh.getLastRowNum();
                            try {

                                for (int r = 1; r<=rows; r++) { //we do not need the header
                                    XSSFRow row1 = (XSSFRow) sh.getRow(r);
                                    int id = (int) row1.getCell(0).getNumericCellValue();
                                    insertDoor(connection, id);
                                }
                            }
                            catch (Exception e){
                                //e.printStackTrace();

                            }
                            System.out.println(count + " records inserted"); //number of rows inserted
                            count = 0;
                            System.out.println("  ");
                            sh = sheetIterator.next();
                            System.out.println(sh.getSheetName());
                            System.out.println("-------------------");

                        }
                        if(sh.getSheetName().equals("Window")){
                            rows = sh.getLastRowNum();
                            try {
                                for (int r = 1; r<=rows; r++) { //we do not need the header
                                    XSSFRow row1 = (XSSFRow) sh.getRow(r);
                                    int id = (int) row1.getCell(0).getNumericCellValue();
                                    int room_id = (int) row1.getCell(1).getNumericCellValue();
                                    insertWindow(connection, id,room_id);
                                }
                            }
                            catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            System.out.println(count + " records inserted"); //number of rows inserted
                            count = 0;
                            System.out.println("  ");
                            sh = sheetIterator.next();
                            System.out.println(sh.getSheetName());
                            System.out.println("-------------------");
                        }
                        if(sh.getSheetName().equals("Door_Connects_Room")){
                            rows = sh.getLastRowNum();
                            try {
                                for (int r = 1; r<=rows; r++) { //we do not need the header
                                    XSSFRow row1 = (XSSFRow) sh.getRow(r);
                                    int door_id = (int) row1.getCell(0).getNumericCellValue();
                                    int room_id = (int) row1.getCell(1).getNumericCellValue();
                                    insertDoorConnectsRoom(connection, door_id,room_id);
                                }
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                            System.out.println(count + " records inserted"); //number of rows inserted
                            count = 0;
                            System.out.println("  ");
                            sh = sheetIterator.next();
                            System.out.println(sh.getSheetName());
                            System.out.println("-------------------");

                        }
                        if(sh.getSheetName().equals("PeopleInRoom")){
                            rows = sh.getLastRowNum();
                            try {
                                for (int r = 1; r<=rows; r++) { //we do not need the header
                                    XSSFRow row1 = (XSSFRow) sh.getRow(r);
                                    String input = row1.getCell(0).getStringCellValue();
                                    OffsetDateTime offsetDateTime = OffsetDateTime.parse(input);
                                    int room_id = (int) row1.getCell(1).getNumericCellValue();
                                    int no_people_in_room = (int) row1.getCell(2).getNumericCellValue();
                                    insertPeopleInRoom(connection, offsetDateTime,room_id,no_people_in_room);
                                }

                            }
                            catch (Exception e){
                                e.printStackTrace();
                                System.out.println(e.getMessage());
                            }
                            System.out.println(count + " records inserted"); //number of rows inserted
                            count = 0;
                            System.out.println("  ");
                            sh = sheetIterator.next();
                            System.out.println(sh.getSheetName());
                            System.out.println("-------------------");

                        }
                        if(sh.getSheetName().equals("Windows")){
                            rows = sh.getLastRowNum();
                            try {
                                for (int r = 1; r<=rows; r++) { //we do not need the header
                                    XSSFRow row1 = (XSSFRow) sh.getRow(r);
                                    String input = row1.getCell(0).getStringCellValue();
                                    OffsetDateTime offsetDateTime = OffsetDateTime.parse(input);
                                    int window_id = (int) row1.getCell(1).getNumericCellValue();
                                    String value =  row1.getCell(2).getStringCellValue();
                                    Boolean isOpen = Boolean.parseBoolean(value);
                                    insertIntoWindows(connection, offsetDateTime,window_id,isOpen);
                                }

                            }
                            catch (Exception e){
                                e.printStackTrace();
                                System.out.println(e.getMessage());
                            }
                            System.out.println(count + " records inserted"); //number of rows inserted
                            count = 0;
                            System.out.println("  ");
                            sh = sheetIterator.next();
                            System.out.println(sh.getSheetName());
                            System.out.println("-------------------");
                        }
                        if(sh.getSheetName().equals("Doors")){
                            rows = sh.getLastRowNum();
                            try {
                                for (int r = 1; r<=rows; r++) { //we do not need the header
                                    XSSFRow row1 = (XSSFRow) sh.getRow(r);
                                    String input = row1.getCell(0).getStringCellValue();
                                    OffsetDateTime offsetDateTime = OffsetDateTime.parse(input);
                                    int door_id = (int) row1.getCell(1).getNumericCellValue();
                                    String value =  row1.getCell(2).getStringCellValue();
                                    Boolean isOpen = Boolean.parseBoolean(value);
                                    insertIntoDoors(connection, offsetDateTime,door_id,isOpen);
                                }
                            }
                            catch (Exception e){
                                e.printStackTrace();
                                System.out.println(e.getMessage());
                            }
                            System.out.println(count + " records inserted"); //number of rows inserted
                            count = 0;
                            System.out.println("  ");
                            sh = sheetIterator.next();
                            System.out.println(sh.getSheetName());
                            System.out.println("-------------------");

                        }
                        if(sh.getSheetName().equals("Ventilators")){
                            rows = sh.getLastRowNum();
                            try {
                                for (int r = 1; r<=rows; r++) { //we do not need the header
                                    XSSFRow row1 = (XSSFRow) sh.getRow(r);
                                    String input = row1.getCell(0).getStringCellValue();
                                    OffsetDateTime offsetDateTime = OffsetDateTime.parse(input);
                                    int ventilatorId = (int) row1.getCell(1).getNumericCellValue();
                                    String value =  row1.getCell(2).getStringCellValue();
                                    Boolean isOpen = Boolean.parseBoolean(value);
                                    insertIntoVentilators(connection, offsetDateTime,ventilatorId,isOpen);
                                }
                            }
                            catch (Exception e){
                                e.printStackTrace();
                                System.out.println(e.getMessage());
                            }
                            System.out.println(count + " records inserted"); //number of rows inserted
                            count = 0;
                            System.out.println("  ");
                        }

                    }
                    System.out.println(" ");
                System.out.println(" ");

            workbook.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            connection.close();
        }

    }
    public void insertRoom(Connection con, String name, int size, int id) throws SQLException {
        try {

            String jdbc_insert_sql = "INSERT INTO room (name , size, id) VALUES(?,?,?)";
            PreparedStatement sql_statement = con.prepareStatement(jdbc_insert_sql);
            sql_statement.setString(1, name);
            sql_statement.setInt(2, size);
            sql_statement.setInt(3, id);
            sql_statement.executeUpdate();
            count++;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void insertVentilator(Connection con, int id, int room_id) throws SQLException {
        try {

            String jdbc_insert_sql = "INSERT INTO ventilator (id , room_id) VALUES(?,?)";
            PreparedStatement sql_statement = con.prepareStatement(jdbc_insert_sql);
            sql_statement.setInt(1, id);
            sql_statement.setInt(2, room_id);
            sql_statement.executeUpdate();
            count++;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void insertDoor(Connection con, int id) throws SQLException {
        try {
            String jdbc_insert_sql = "INSERT INTO door (id) VALUES(?)";
            PreparedStatement sql_statement = con.prepareStatement(jdbc_insert_sql);
            sql_statement.setInt(1, id);
            sql_statement.executeUpdate();
            count++;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void insertWindow(Connection con, int id, int room_id) throws SQLException {
        try {

            String jdbc_insert_sql = "INSERT INTO w_indow (id , room_id) VALUES(?,?)";
            PreparedStatement sql_statement = con.prepareStatement(jdbc_insert_sql);
            sql_statement.setInt(1, id);
            sql_statement.setInt(2, room_id);
            sql_statement.executeUpdate();
            count++;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void insertDoorConnectsRoom(Connection con, int door_id, int room_id) throws SQLException {
        try {
            String jdbc_insert_sql = "INSERT INTO door_connects_room (door_id , room_id) VALUES(?,?)";
            PreparedStatement sql_statement = con.prepareStatement(jdbc_insert_sql);
            sql_statement.setInt(1, door_id);
            sql_statement.setInt(2, room_id);
            sql_statement.executeUpdate();
            count++;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void insertPeopleInRoom(Connection con, OffsetDateTime offsetDateTime, int room_id, int no_people_in_room) throws SQLException {
        try {
            String jdbc_insert_sql = "INSERT INTO people_in_room (timestamp , room_id, nopeopleinroom) VALUES(?,?,?)";
            PreparedStatement sql_statement = con.prepareStatement(jdbc_insert_sql);
            sql_statement.setObject(1, offsetDateTime.minusHours(1));
            sql_statement.setInt(2, room_id);
            sql_statement.setInt(3, no_people_in_room);
            sql_statement.executeUpdate();
            count++;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void insertIntoWindows(Connection con, OffsetDateTime offsetDateTime, int window_id, boolean isOpen) throws SQLException {
        try {
            String jdbc_insert_sql = "INSERT INTO windows (timestamp , window_id, isOpen) VALUES(?,?,?)";
            PreparedStatement sql_statement = con.prepareStatement(jdbc_insert_sql);
            sql_statement.setObject(1, offsetDateTime.minusHours(1));
            sql_statement.setInt(2, window_id);
            sql_statement.setBoolean(3, isOpen);
            sql_statement.executeUpdate();
            count++;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void insertIntoDoors(Connection con, OffsetDateTime offsetDateTime, int window_id, boolean isOpen) throws SQLException {
        try {
            String jdbc_insert_sql = "INSERT INTO doors (timestamp , door_id, isOpen) VALUES(?,?,?)";
            PreparedStatement sql_statement = con.prepareStatement(jdbc_insert_sql);
            sql_statement.setObject(1, offsetDateTime.minusHours(1));
            sql_statement.setInt(2, window_id);
            sql_statement.setBoolean(3, isOpen);
            sql_statement.executeUpdate();
            count++;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void insertIntoVentilators(Connection con, OffsetDateTime offsetDateTime, int ventilatorId, boolean isOn) throws SQLException {
        try {
            String jdbc_insert_sql = "INSERT INTO ventilators (timestamp , ventilator_id, ventilator_isOn) VALUES(?,?,?)";
            PreparedStatement sql_statement = con.prepareStatement(jdbc_insert_sql);
            sql_statement.setObject(1, offsetDateTime.minusHours(1));
            sql_statement.setInt(2, ventilatorId);
            sql_statement.setBoolean(3, isOn);
            sql_statement.executeUpdate();
            count++;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
