package Java2_06_07;

import java.sql.*;
import java.util.Scanner;

public class Ex_java2_07 {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("1. UpdateBookByID \n2. BestSeller100");
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                UpdateBookByID();
                break;
            case 2:
                BestSeller100();
                break;
        }
    }
        public static void UpdateBookByID(){
            try(
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/ebookshop?" +
                                    "&serverTimezone=UTC" +
                                    "&useSSL=false" +
                                    "&allowPublicKeyRetrieval=true",
                            "root",
                            "");
                    Statement stmt = conn.createStatement();
            ){
                book.Book book = new book.Book();
                System.out.println("Enter id: ");
                int id = scanner.nextInt();
                book.setId(id);
                System.out.println("Enter price: ");
                float price = scanner.nextFloat();
                book.setPrice(price);
                System.out.println("Enter quantity: ");
                int qty = scanner.nextInt();
                book.setQty(qty);
                String sqlUpdate = "update books set price = " + book.getPrice() + ", qty = " + book.getQty()
                        + " where id = " + book.getId();
                System.out.println("The SQL statement is: " + sqlUpdate);
                int countUpdate = stmt.executeUpdate(sqlUpdate);
                System.out.println(countUpdate + " records updated.");
                String sqlSelect = "Select * from books where id = " + book.getId();
                ResultSet rset = stmt.executeQuery(sqlSelect);
                book.setTitle(rset.getString("title"));
                book.setAuthor(rset.getString("author"));
                System.out.println(book.toString());
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        public static void BestSeller100(){
            try(
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                            "root", "");
                    Statement stmt = conn.createStatement();
            ){
                String strSelect = "select books.id, books.title, books.category, sum(orderQty) as sumQty from orderdetail\n" +
                        "Join books on   orderdetail.Bookid = books.id\n" +
                        "JOIN orderproduct o on orderdetail.orderID = o.orderID\n" +

                        "group by id" +
                        " order by sumQty DESC limit 100";
                System.out.println("The stetament SQL is : "+ strSelect + "\n");
                ResultSet rset = stmt.executeQuery(strSelect);

                System.out.println("The records select are: ");
                int rowCount = 0;
                while (rset.next()){
                    int id = rset.getInt("books.id");
                    String title = rset.getString("books.title");
                    String category = rset.getString("books.category");
                    int qty = rset.getInt("sumQty");
                    System.out.println("STT " + (rowCount+ 1) + "-" + id + ", " + title + ", " + category + ", "  + qty + "\n");
                    rowCount++;
                }
                System.out.println("Total number of records = " + rowCount);
            } catch (SQLException ex){
                ex.printStackTrace();
            }

        }
    }

