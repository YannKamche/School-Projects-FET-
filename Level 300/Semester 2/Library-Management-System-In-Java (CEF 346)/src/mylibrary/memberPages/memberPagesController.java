
package mylibrary.memberPages;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mylibrary.Models.Book;
import mylibrary.Models.BookFactory;
import mylibrary.Models.Borrow;
import mylibrary.Models.CenteredListViewCell;
import mylibrary.Models.Client;
import mylibrary.Models.Database;
import static mylibrary.Models.Database.getDatabaseConnection;
import mylibrary.Models.Reservation;
import mylibrary.Models.ReservationFactory;

public class memberPagesController implements Initializable{
    
    @FXML
    private Pane AnchorPane_borrowBook;
    
    @FXML
    private Pane memberHomePane;
    
    
    @FXML
    private Pane reserveBookPane;
     @FXML
    private Pane borrowBookPane;
    
    @FXML
    private Pane addClientPane;
    
    @FXML
    private Pane chooseBookPane;
    
    @FXML
    private Button borrowBook;
    
    @FXML
    private Button returnBook;
    
    @FXML
    private Button reserveBook;
    
    @FXML
    private Button reservationList;
    
    @FXML 
    private ListView listOfReservations;
    
    @FXML
    private TextField clientPhoneReservations;
    @FXML
    private TextField clientPhoneCheck;
    @FXML
    private Label borrowError;
    @FXML
    private ComboBox SearchBy;
    @FXML 
    private ListView borrowbooklist;
    @FXML
    private Label borrowErrorMessage;
    @FXML
    private TextField searchParameter;
    @FXML
    private TextField clientPhone;
    @FXML
    private TextField clientName;
    @FXML
    private TextField  clientEmail;
    @FXML
    private Label addborrowMessage;
    @FXML
    private Button continueBorrowBook;
    @FXML
    private Button addClient;
    
    @FXML
    private Button searchClientNb;
    
    @FXML 
    private ListView returnbooklist;
    
    @FXML
    private TextField  clientNumber;
  
    @FXML
    private Label returnBookMsg;
   
    @FXML
    private Label returnBookMsgError;
    
    static int borrowId=0;
    ArrayList<Integer> BorrowsIds = new ArrayList();
    ArrayList<Integer> BookIds = new ArrayList();
    ObservableList<String>booksList =FXCollections.observableArrayList();    
    ObservableList<String> items= FXCollections.observableArrayList();
    Client client;
    static int bookId;
    
   Book book;
    static String phone_nb="";
    ArrayList<Integer> ids = new ArrayList();
   
    String phone;
    
    ObservableList<String> list=FXCollections.observableArrayList();
    
    @FXML
    private Label checkClientMsgError;

    @FXML
    private TextField clientPhoneAdd;
    
    @FXML
    private Label addNewClientMsgError;
    
    
    @FXML
    private TextField clientNameChoose;
    
    @FXML
    private Label chooseBookMsg;
    
    @FXML
    private Label chooseBookMsgError;
    
    @FXML
    private SplitMenuButton booksLists;
    
    static String myPhone;
    
    static String myClientName;
    
    Database db = getDatabaseConnection();
    ResultSet res = null;

    
    @FXML
    private void logoutMember(ActionEvent event)throws IOException{
        
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        double x = currentStage.getWidth();
        double y = currentStage.getHeight();
        Parent root = FXMLLoader.load(getClass().getResource("memberSignIn.fxml"));
        Stage logout = new Stage();
        currentStage.close();
        Scene d = new Scene(root);
        
        logout.setScene(d);
        logout.setWidth(x);
        logout.setHeight(y);
        logout.setMinWidth(1196);
        logout.setMinHeight(710);
        logout.show();
    }
    
    @FXML
    private void memberToBorrowBook(ActionEvent event)throws IOException{
        
       Parent fxml = FXMLLoader.load(getClass().getResource("BorrowBook.fxml"));
       memberHomePane.getChildren().removeAll();
       memberHomePane.getChildren().setAll(fxml);
    }
    
    @FXML
    private void memberToReturnBook(ActionEvent event)throws IOException{
        
       Parent fxml = FXMLLoader.load(getClass().getResource("returnBook.fxml"));
       memberHomePane.getChildren().removeAll();
       memberHomePane.getChildren().setAll(fxml);
    }
    
    @FXML
    private void memberToReserveBook(ActionEvent event)throws IOException{
        
       Parent fxml = FXMLLoader.load(getClass().getResource("reserveBook.fxml"));
       memberHomePane.getChildren().removeAll();
       memberHomePane.getChildren().setAll(fxml);
    }    
    
    @FXML
    private void memberToReservationsList(ActionEvent event)throws IOException, SQLException{
        
       Parent fxml = FXMLLoader.load(getClass().getResource("reservationsList.fxml"));
       memberHomePane.getChildren().removeAll();
       memberHomePane.getChildren().setAll(fxml);
    }
    
    @FXML
    private void myHoverFunctionStart(MouseEvent event){
        
       Button tempButton = ((Button)event.getSource());
       tempButton.setStyle(tempButton.getStyle().concat("-fx-background-color: #823F15;"));
    }
    
    @FXML
    private void myHoverFunctionEnd(MouseEvent event){
        
       Button tempButton = ((Button)event.getSource());
       if( !( tempButton.getId().equals("borrowBook") && memberHomePane.getChildren().get(0).getId().equals("borrowBookPane"))
            && !( tempButton.getId().equals("returnBook") && memberHomePane.getChildren().get(0).getId().equals("returnBookPane"))
            && !( tempButton.getId().equals("reserveBook") && memberHomePane.getChildren().get(0).getId().equals("reserveBookPane"))       
            && !( tempButton.getId().equals("reservationList") && memberHomePane.getChildren().get(0).getId().equals("bookReservationPane"))       
            ||memberHomePane.getChildren().get(0).getId().equals("welcome") )
            tempButton.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
    }
    
    @FXML
    private void selectedOption(MouseEvent event){
        
       Button tempButton = ((Button)event.getSource());
       borrowBook.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
       returnBook.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
       reserveBook.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
       reservationList.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
       tempButton.setStyle(tempButton.getStyle().concat("-fx-background-color: #823F15;"));
    }
    
    @FXML
    private void addClientPage(ActionEvent event)throws IOException, SQLException{
        
       if(!clientPhone.getText().trim().equals("")){
           
           myPhone = clientPhone.getText().trim();
           res = db.SelectFun("select * from client where CLIENT_PHONE = '"+clientPhone.getText().trim()+"';");
           if(!res.next()){
                Parent fxml = FXMLLoader.load(getClass().getResource("addNewClient.fxml"));
                reserveBookPane.getChildren().removeAll();
                reserveBookPane.getChildren().setAll(fxml);
           }
           else{
               myClientName = res.getString("CLIENT_NAME");
               Parent fxml = FXMLLoader.load(getClass().getResource("chooseBook.fxml"));
               reserveBookPane.getChildren().removeAll();
               reserveBookPane.getChildren().setAll(fxml);
           }
       }
       else
           checkClientMsgError.setText("You must enter the phone number !");
    }
    
    @FXML
    private void setClientPhone(MouseEvent event){
        
        clientPhoneAdd.setText(myPhone);
    }
    
    @FXML
    private void setClientName(MouseEvent event){
        
        clientNameChoose.setText(myClientName);
    }
    
    @FXML
    private void chooseBookPage(ActionEvent event)throws IOException, SQLException{
        
       if( !clientName.getText().trim().equals("") && !clientEmail.getText().trim().equals("") ){
            
            client = Client.getUser(clientName.getText().trim(),clientPhoneAdd.getText().trim(),clientEmail.getText().trim());
            db.InsertFun("INSERT INTO client VALUES ('"+client.getPhone()+"', '"+client.getClientName()+"', '"+client.getEmail()+"');");
            myClientName = client.getClientName();
            Parent fxml = FXMLLoader.load(getClass().getResource("chooseBook.fxml"));
            addClientPane.getChildren().removeAll();
            addClientPane.getChildren().setAll(fxml);
       }
       else{
           addNewClientMsgError.setText("You must fill in all fields !");
       }
    }
    
    @FXML
    private void finishReservation(ActionEvent event)throws IOException, SQLException, ParseException{
        
       if(!booksLists.getText().equals("Books")){
           
            chooseBookMsgError.setText("");
            res = db.SelectFun("select BOOK_ID from book where BOOK_TITLE = '"+booksLists.getText()+"'");
            String bookID = null;
            if(res.next()) 
                bookID = res.getString("BOOK_ID");
            res = db.SelectFun("select min(RETURNED_DATE) from borrow where BOOK_ID = '"+bookID+"'");
            String returnDate = null;
            if(res.next())
                returnDate = res.getString("min(RETURNED_DATE)");
            Date resDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(returnDate); 
            Calendar c = Calendar.getInstance(); 
            c.setTime(resDate); 
            c.add(Calendar.DATE, 1);
            resDate = (Date) c.getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            String strDate= formatter.format(resDate);  
            db.InsertFun("INSERT INTO reservation (`CLIENT_PHONE`, `BOOK_ID`, `RESERVATION_DATE`) VALUES ('"+myPhone+"', '"+bookID+"', '"+strDate+"');");
            chooseBookMsg.setText("Successfully reservation.\nYou can come on "+strDate);
       }
       else{
           chooseBookMsg.setText("");
           chooseBookMsgError.setText("You must select the book first !");
       }
    }
    
    @FXML
    private void getBooksToReserve(MouseEvent event) throws SQLException{
        ResultSet res;
       SplitMenuButton myComboBox = ((SplitMenuButton)event.getSource());
       myComboBox.getItems().clear();
       myComboBox.showingProperty().addListener((obs, wasShowing, isNowShowing) -> {
          if (isNowShowing){
              chooseBookMsg.setText("");
              myComboBox.setText("Books");
          }
       });
       res = db.SelectFun("select BOOK_TITLE from book where COPIES_NBR = 0");
       List<String> allBooks = new ArrayList<>();
       while(res.next()){
           allBooks.add(res.getString("BOOK_TITLE"));
       }
       MenuItem choice;
       if(allBooks.isEmpty()){
           choice = new MenuItem("No books found");
           choice.setStyle("-fx-text-fill: #AAAAAA; -fx-font-size: 15pt ;-fx-font-weight: bold;");
           myComboBox.getItems().addAll(choice);
       }
       else{
            for (int i = 0; i < allBooks.size(); i++) {
                 choice = new MenuItem(allBooks.get(i));
                 choice.setOnAction((e)-> {
                     MenuItem myChoice = (MenuItem)e.getSource();
                     chooseBookMsgError.setText("");
                     myComboBox.setText(myChoice.getText());
                 });
                 myComboBox.getItems().addAll(choice);
            }
       }
    }
    // Reservation List Section 
    @FXML
    private void getReservationsList(ActionEvent event) throws SQLException{
        ids=  new ArrayList();  
        list.clear();
          
          phone = clientPhoneReservations.getText().toString();
          ResultSet res= db.SelectFun("select RESERVATION_ID,BOOK_TITLE,RESERVATION_DATE from reservation,book "
                 + "                    where CLIENT_PHONE='"+phone+"'"
                 + "                    AND book.BOOK_ID=reservation.BOOK_ID ; ");
          
       Reservation reservation = ReservationFactory.getReservation(phone);
        while(res.next())
            {
               
                reservation.setDate(res.getDate("RESERVATION_DATE"));
                reservation.setBookTitle(res.getString("BOOK_TITLE"));
                int id = res.getInt("RESERVATION_ID");
              reservation.setReservationId(id);
              ids.add(id);
                
                list.addAll(reservation.toString());
            }
           listOfReservations.setCellFactory(stringListView -> new CenteredListViewCell());
           listOfReservations.setItems(list);
           listOfReservations.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
           
   }     
   
    @FXML 
    private void borrowReservation(ActionEvent event) throws SQLException{
       int index = listOfReservations.getSelectionModel().getSelectedIndex();
       
      
       ResultSet res = db.SelectFun("select BOOK_ID from reservation where RESERVATION_ID="+ids.get(index));
      int book_id=0;
       if(res.next()){
       book_id= res.getInt("BOOK_ID");
      
       
       }
        int nb=0;
       ResultSet res2 = db.SelectFun("select COPIES_NBR from reserved_books where BOOK_ID="+book_id);
       if(res2.next()){
       nb=res2.getInt("COPIES_NBR");
       }
       if(nb==0){
         borrowError.setStyle("-fx-text-fill:red;");
       borrowError.setText("Borrow failed because no book returned!");
       
       }
       else{
        String ClientPhone =phone;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now(); // Gets the current date
        String borrowdate = formatter.format(date);
        date = date.plusDays(30);
        String returnDate = formatter.format(date);
        Borrow borrow = Borrow.getBrrow(ClientPhone, book_id, borrowdate, returnDate);
        db.InsertFun("insert into borrow(CLIENT_PHONE,BOOK_ID,BORROW_DATE,RETURNED_DATE) values('"+borrow.getClient()+"','"+borrow.getbook()+"','"+borrow.getBorrowDate()+"','"+borrow.getReturnDate()+"')");
        nb=nb -1;
         borrowError.setStyle("-fx-text-fill:green;");
            borrowError.setText("Borrow Succeed!");
        if(nb==0){
           
        db.InsertFun("delete from reserved_books where BOOK_ID="+book_id);
        }
        else{
        db.InsertFun("update  reserved_books  SET COPIES_NBR="+nb+"  where BOOK_ID="+book_id);
        }
        db.InsertFun("delete from reservation where Reservation_ID="+ids.get(index));
        list.remove(index);
        
       }
       
    }
    // Borrow Section

   @FXML
   public void  getComboSearch(MouseEvent e){
   items.clear();
   items.add("Title");
   items.add("Author");
   items.add("Category");
   SearchBy.setItems(items);
   
   }
   
   @FXML 
   public void SearchBooksBy(ActionEvent e) throws SQLException{
      booksList.clear();
       String parameter =""; 
      System.out.println("Search"); 
       int index = SearchBy.getSelectionModel().getSelectedIndex();
        if(SearchBy.getSelectionModel().getSelectedItem()!=null){
         parameter = items.get(index);}
        ResultSet res;
        switch(parameter){
   
        case "Category":
           res= db.SelectFun("select BOOK_ID,Book_TITLE,AUTHOR_NAME,CATEGORY_NAME,BOOK_DATE,COPIES_NBR from book where Category_NAME like '"+searchParameter.getText()+"%'");
           break;
   
        case "Author":
            res= db.SelectFun("select BOOK_ID,Book_TITLE,AUTHOR_NAME,CATEGORY_NAME,BOOK_DATE,COPIES_NBR from book where Author_NAME like '"+searchParameter.getText()+"%'");
            break;
   
        case "Title":
            res= db.SelectFun("select BOOK_ID,Book_TITLE,AUTHOR_NAME,CATEGORY_NAME,BOOK_DATE,COPIES_NBR from book where BOOK_TITLE like'"+searchParameter.getText()+"%'");
            break;
        
        default:
            borrowErrorMessage.setText("Please choose the type of search");
            return ;
           
        }
      
    while(res.next()){
         borrowErrorMessage.setText("");
          Book book = BookFactory.getBook(res.getString("Category_NAME"));
          book.setAuthor(res.getString("AUTHOR_NAME"));
          book.setCopies(res.getInt("COPIES_NBR"));
          book.setDate(res.getDate("BOOK_DATE"));
          book.setTitle(res.getString("BOOK_TITLE"));
          booksList.add(book.toString());
         BookIds.add(res.getInt("BOOK_ID"));
         
      
      }
      borrowbooklist.setItems(booksList);
     
      
      
   }
   @FXML
    private void goToCheckClient(ActionEvent event)throws IOException{
       int index =borrowbooklist.getSelectionModel().getSelectedIndex();
       if(index==-1){
       borrowErrorMessage.setText("Please choose a book");
       
       }else{
       Parent fxml = FXMLLoader.load(getClass().getResource("checkClient.fxml"));
       borrowBookPane.getChildren().removeAll();
       borrowBookPane.getChildren().setAll(fxml);
       bookId = BookIds.get(index);
      
      
       }
    }
   
    
    
   @FXML
   public void checkClientPhone(ActionEvent e) throws SQLException, IOException{
    int nbc=0;
       phone_nb= clientPhoneCheck.getText();
       ResultSet res = db.SelectFun("select * from client where CLIENT_PHONE='"+clientPhoneCheck.getText()+"'");
       if(res.next()==false){
        phone_nb= clientPhoneCheck.getText();
        Parent fxml = FXMLLoader.load(getClass().getResource("addNewClient2.fxml"));
        reserveBookPane.getChildren().removeAll();
        reserveBookPane.getChildren().setAll(fxml);
          
        return;
       }
       res = db.SelectFun("select * from client where CLIENT_PHONE='"+clientPhoneCheck.getText()+"'");
       while(res.next()){
        client= Client.getUser(res.getString("CLIENT_NAME"),res.getString("CLIENT_PHONE"),res.getString("EMAIL"));}
        res = db.SelectFun("select COPIES_NBR,BOOK_ID from book where BOOK_ID="+bookId+" and COPIES_NBR>0");
        if(res.next()){
             nbc=res.getInt("COPIES_NBR");
             System.out.println(nbc);
             nbc=nbc-1;
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDate date = LocalDate.now(); // Gets the current date
             String borrowdate = formatter.format(date);
             date = date.plusDays(30);
            String returnDate = formatter.format(date);
            Borrow borrow= Borrow.getBrrow(client.getPhone(), bookId, borrowdate, returnDate);
            db.InsertFun("insert into borrow(CLIENT_PHONE,BOOK_ID,BORROW_DATE,RETURNED_DATE) values('"+borrow.getClient()+"','"+borrow.getbook()+"','"+borrow.getBorrowDate()+"','"+borrow.getReturnDate()+"')");
            db.InsertFun("update book set COPIES_NBR="+nbc+" where BOOK_ID="+bookId);
            addborrowMessage.setStyle("-fx-text-fill:green");
            addborrowMessage.setText("Borrow Succeed");
            continueBorrowBook.setDisable(true);
        }
        else{
                addborrowMessage.setStyle("-fx-text-fill:red");
                addborrowMessage.setText("Borrow Failed Because No Copies Available");
            }
   
   }
   @FXML
   public  void AddAndBorrow(ActionEvent event) throws SQLException{
       int nbc=0;
       
       String p= clientPhone.getText();
       String n = clientName.getText();
       String e = clientEmail.getText();
       
       if(p.equals("")||n.equals("")||e.equals("")){
           addborrowMessage.setStyle("-fx-text-fill:red");
           addborrowMessage.setText("Please fill all fields");
       }
       else{
           
       
        db.InsertFun("insert into client values('"+p+"','"+n+"','"+e+"')");
        ResultSet res = db.SelectFun("select COPIES_NBR,BOOK_ID from book where BOOK_ID="+bookId+" and COPIES_NBR>0");
        if(res.next()==false){
         addborrowMessage.setStyle("-fx-text-fill:red");
         addborrowMessage.setText("No copies");
         return ;
        }
             res = db.SelectFun("select COPIES_NBR,BOOK_ID from book where BOOK_ID="+bookId+" and COPIES_NBR>0");  
            if(res.next()){
             nbc=res.getInt("COPIES_NBR");
             System.out.println(nbc);
             }
            nbc=nbc-1;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.now(); // Gets the current date
            String borrowdate = formatter.format(date);
            date = date.plusDays(30);
            String returnDate = formatter.format(date);
            Borrow borrow= Borrow.getBrrow(p, bookId, borrowdate, returnDate);
            
            db.InsertFun("insert into borrow(CLIENT_PHONE,BOOK_ID,BORROW_DATE,RETURNED_DATE) values('"+borrow.getClient()+"','"+borrow.getbook()+"','"+borrow.getBorrowDate()+"','"+borrow.getReturnDate()+"')");
            db.InsertFun("update book set COPIES_NBR="+nbc+" where BOOK_ID="+bookId);
            addborrowMessage.setStyle("-fx-text-fill:green");
            addborrowMessage.setText("Borrow succeed");
            addClient.setDisable(true);
        }
       
   }
      void listReturnBook()  throws SQLException{
        BorrowsIds.clear();
       booksList.clear();
       BookIds.clear();
       String parameter =""; 
       returnBookMsgError.setText("");
       
      ResultSet  res= db.SelectFun("select borrow.BOOK_ID,Category_NAME,AUTHOR_NAME,COPIES_NBR,BOOK_DATE,BOOK_TITLE,BORROW_DATE, RETURNED_DATE  from book,borrow where CLIENT_PHONE ='"+clientNumber.getText()+"' AND book.BOOK_ID=borrow.BOOK_ID;");
        if(res.next()==false){
        returnBookMsgError.setText("No book borrowed");
        
        return;
        } 
    res= db.SelectFun("select  BORROW_ID,borrow.BOOK_ID,Category_NAME,AUTHOR_NAME,COPIES_NBR,BOOK_DATE,BOOK_TITLE,BORROW_DATE, RETURNED_DATE  from book,borrow where CLIENT_PHONE ='"+clientNumber.getText()+"' AND book.BOOK_ID=borrow.BOOK_ID;");
     while(res.next()){
      res= db.SelectFun("select BORROW_ID,borrow.BOOK_ID,Category_NAME,AUTHOR_NAME,COPIES_NBR,BOOK_DATE,BOOK_TITLE,BORROW_DATE, RETURNED_DATE  from book,borrow where CLIENT_PHONE ='"+clientNumber.getText()+"' AND book.BOOK_ID=borrow.BOOK_ID;");
         while(res.next()){
             returnBookMsgError.setText("");
             book = BookFactory.getBook(res.getString("Category_NAME"));
             book.setAuthor(res.getString("AUTHOR_NAME"));
             book.setCopies(res.getInt("COPIES_NBR"));
             book.setDate(res.getDate("BOOK_DATE"));
             book.setTitle(res.getString("BOOK_TITLE"));
             booksList.add(book.toString());
             BookIds.add(res.getInt("borrow.BOOK_ID"));
             BorrowsIds.add(res.getInt("BORROW_ID"));
      }
      returnbooklist.setItems(booksList);
   }
      }
  boolean checkClient(String phoneNb) throws SQLException{
      
       res = db.SelectFun("select * from client where CLIENT_PHONE='"+phoneNb+"';");
       return res.next() != false;
   }
   
   @FXML 
   public void searchBorrowedBook(ActionEvent e) throws SQLException{
       returnBookMsg.setText("");
       returnBookMsgError.setText("");

        if(!clientNumber.getText().trim().equals("")){
            System.out.println(clientNumber.getText());
            if(checkClient(clientNumber.getText().trim()))
                listReturnBook();
            else
                      returnBookMsgError.setText("Please enter a correct phone number.");
        }else
           returnBookMsgError.setText("Please enter the phone number.");
        
   }
   
    
   
   
   @FXML
   public  void returnBook(ActionEvent event) throws SQLException, ExecutionException, TimeoutException{    
        int index =returnbooklist.getSelectionModel().getSelectedIndex();
         if(index==-1){
            returnBookMsgError.setText("Please choose a book");
         
       }else{
        borrowId = BorrowsIds.get(index);
         bookId=BookIds.get(index);
        db.InsertFun("DELETE FROM BORROW WHERE BORROW_ID = '"+borrowId+"';");
        //check if reservation exist for this book 
        
        ResultSet res= db.SelectFun("select * from reservation where BOOK_ID='"+bookId+"';");
        if(res.next()== false){
             System.out.println("No book reserved");
            db.InsertFun("UPDATE book SET COPIES_NBR = COPIES_NBR+1  WHERE BOOK_ID = '"+bookId+"';");}
        else{
        //check if book already exist in reserved books
        res=db.SelectFun("select * from reserved_books where BOOK_ID='"+bookId+"';");
        if(res.next()==false){
        db.InsertFun("insert into reserved_books values('"+bookId+"','1');");}
        else{
        //update nbr of copies
        db.InsertFun("update reserved_books set COPIES_NBR = COPIES_NBR+1 where BOOK_ID='"+bookId+"';");
        }
        
        }
        
        listReturnBook();
        returnBookMsg.setText("Book returned successfully.");
       returnBookMsgError.setText("");
        
       }
   
  
   }
   
   
   
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    
    
    
      
}
}