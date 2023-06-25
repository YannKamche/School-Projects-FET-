
package mylibrary.adminPages;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import mylibrary.Models.Client;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mylibrary.Models.Book;
import static mylibrary.Models.Book.getBook;
import mylibrary.Models.BookFactory;
import mylibrary.Models.Database;
import static mylibrary.Models.Database.getDatabaseConnection;
import mylibrary.Models.User;
import static mylibrary.Models.User.getUser;

public class adminPagesController implements Initializable{
    
    
    @FXML
    private Pane AnchorPane_adminHome;
    
    @FXML
    private Pane adminHomePane;
    
    @FXML
    private TextField bookTitle;
   
    @FXML
    private TextField bookAuthor;
    
    @FXML
    private TextField bookCategory;
    @FXML
    private TextField numberOfCopies;
    @FXML
    private DatePicker publicationDate;
    @FXML
    private TextArea description;
    
    @FXML
    private SplitMenuButton categoriesList;
    
    @FXML
    private Label removeCategoryMsg;
    
    @FXML
    private Label removeCategoryMsgError;
    
    
    
    
    @FXML
    private SplitMenuButton membersList;
    
    @FXML
    private Label removeMemberMsg;
    
    @FXML
    private Label removeMemberMsgError;
    
  
    
    
    @FXML
    private TextField memberName;
    
    @FXML
    private TextField memberUsername;
    
    @FXML
    private PasswordField memberPassword;
    
    @FXML
    private TextField memberPhone;
    
    @FXML
    private TextField memberEmail;
    
    @FXML
    private CheckBox isAdmin;
    
    @FXML
    private Label addMemberMsg;
    
    @FXML
    private Label addMemberMsgError;
    
     @FXML
    private ComboBox SearchBy;
     
    @FXML 
    private ListView borrowbooklist;
    @FXML
    private Label borrowErrorMessage;
    @FXML
    private ComboBox chooseCategories;
    @FXML
    private ComboBox chooseAuthors;
    
    @FXML
    private Button addCategory;
            
    @FXML
    private Button removeCategory;
    
    @FXML
    private Button addBook;
    
    @FXML
    private Button removeBook;
    
    @FXML
    private Button updateBook;
    
    @FXML
    private Button addMember;
    @FXML 
    private TextField searchParameter;
    @FXML
    private Button removeMember;
    @FXML
    private Label updateMessage;
  
    
    @FXML
    private TextField authorName;
 
    @FXML
    private TextField nbCopies;
    
    @FXML
    private SplitMenuButton categoriesList_addBook;
        

    
    @FXML
    private Label  addBookMsg;
    
    
    
    
    
    @FXML
    private Button deleteBook;
        
    @FXML
    private Label  deleteBookMsgError;
    
    @FXML
    private Label  deleteBookMsg;
    
    
    
    @FXML
    private TextField categoryName;
 
    @FXML
    private Label  addCategoryMsgError;
    
    @FXML
    private Label  addCategoryMsg;


    
    @FXML 
    private ListView removebooklist;
    
    @FXML
    private TextField  searchParameterBook;


    Client client;
    
    Book book;
    
    
  
    Database db = getDatabaseConnection();
    ResultSet res = null;
    
    User user;

 
    ObservableList<String> items= FXCollections.observableArrayList();
    ArrayList<Integer> BookIds = new ArrayList();
   
    ObservableList<String>booksList =FXCollections.observableArrayList();
    static int bookId;
    ObservableList<String> categoriesListO =FXCollections.observableArrayList();
    ObservableList<String> authorsListO =FXCollections.observableArrayList();
    @FXML
    private void logoutAdmin(ActionEvent event)throws IOException{
        
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        double x = currentStage.getWidth();
        double y = currentStage.getHeight();
        Parent root = FXMLLoader.load(getClass().getResource("adminSignIn.fxml"));
        Scene d = new Scene(root);
        Stage logout = new Stage();
        currentStage.close();
        logout.setScene(d);
        logout.setWidth(x);
        logout.setHeight(y);
        logout.setMinWidth(1196);
        logout.setMinHeight(710);
        logout.show();
    }
    
    @FXML
    private void adminToAddCategory(ActionEvent event)throws IOException{
        
       Parent fxml = FXMLLoader.load(getClass().getResource("addCategory.fxml"));
       adminHomePane.getChildren().removeAll();
       adminHomePane.getChildren().setAll(fxml);
    }
    
    @FXML
    private void adminToRemoveCategory(ActionEvent event)throws IOException{
        
       Parent fxml = FXMLLoader.load(getClass().getResource("deleteCategory.fxml"));
       adminHomePane.getChildren().removeAll();
       adminHomePane.getChildren().setAll(fxml);
    }
    
    @FXML
    private void adminToAddBook(ActionEvent event)throws IOException{
        
       Parent fxml = FXMLLoader.load(getClass().getResource("addBook.fxml"));
       adminHomePane.getChildren().removeAll();
       adminHomePane.getChildren().setAll(fxml);
    }
    
    @FXML
    private void adminToRemoveBook(ActionEvent event)throws IOException{
        
       Parent fxml = FXMLLoader.load(getClass().getResource("removeBook.fxml"));
       adminHomePane.getChildren().removeAll();
       adminHomePane.getChildren().setAll(fxml); 
    }
    
    @FXML
    private void adminToUpdateBook(ActionEvent event)throws IOException{
        
       Parent fxml = FXMLLoader.load(getClass().getResource("updateBook.fxml"));
       adminHomePane.getChildren().removeAll();
       adminHomePane.getChildren().setAll(fxml);
    }
    
    @FXML
    private void adminToAddMember(ActionEvent event)throws IOException{
        
       Parent fxml = FXMLLoader.load(getClass().getResource("addMember.fxml"));
       adminHomePane.getChildren().removeAll();
       adminHomePane.getChildren().setAll(fxml);
    }
    
    @FXML
    private void adminToRemoveMember(ActionEvent event)throws IOException{
        
       Parent fxml = FXMLLoader.load(getClass().getResource("deleteMember.fxml"));
       adminHomePane.getChildren().removeAll();
       adminHomePane.getChildren().setAll(fxml);
    }
    
    @FXML
    private void myHoverFunctionStart(MouseEvent event){
        
       Button tempButton = ((Button)event.getSource());
       tempButton.setStyle(tempButton.getStyle().concat("-fx-background-color: #823F15;"));
    }
    
    @FXML
    private void myHoverFunctionEnd(MouseEvent event){
        
       Button tempButton = ((Button)event.getSource());
       if( !( tempButton.getId().equals("addCategory") && adminHomePane.getChildren().get(0).getId().equals("addCategoryPane"))
        && !( tempButton.getId().equals("removeCategory") && adminHomePane.getChildren().get(0).getId().equals("deleteCategoryPane"))
        && !( tempButton.getId().equals("addBook") && adminHomePane.getChildren().get(0).getId().equals("addBookPane"))       
        && !( tempButton.getId().equals("removeBook") && adminHomePane.getChildren().get(0).getId().equals("removeBookPane"))       
        && !( tempButton.getId().equals("updateBook") && adminHomePane.getChildren().get(0).getId().equals("updateBookPane"))    
        && !( tempButton.getId().equals("addMember") && adminHomePane.getChildren().get(0).getId().equals("addMemberPane"))       
        && !( tempButton.getId().equals("removeMember") && adminHomePane.getChildren().get(0).getId().equals("removeMemberPane"))
        ||    adminHomePane.getChildren().get(0).getId().equals("welcome") )
            tempButton.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
    }
    
    @FXML
    private void selectedOption(MouseEvent event){
        
       Button tempButton = ((Button)event.getSource());
       addCategory.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
       removeCategory.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
       addBook.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
       removeBook.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
       updateBook.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
       addMember.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
       removeMember.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
       tempButton.setStyle(tempButton.getStyle().concat("-fx-background-color: #823F15;"));
    }
    
    @FXML
    private void getCategories(MouseEvent event) throws SQLException{
        
       SplitMenuButton myComboBox = ((SplitMenuButton)event.getSource());
       myComboBox.getItems().clear();
       res = db.SelectFun("select * from category");
       List<String> allCategories = new ArrayList<>();
       while(res.next()){
           allCategories.add(res.getString("CATEGORY_NAME"));
       }
       MenuItem choice;
       if(allCategories.isEmpty()){
           choice = new MenuItem("No categories found");
           choice.setStyle("-fx-text-fill: #AAAAAA; -fx-font-size: 15pt ;-fx-font-weight: bold;");
           myComboBox.getItems().addAll(choice);
       }
       else{
            for (int i = 0; i < allCategories.size(); i++) {
                 choice = new MenuItem(allCategories.get(i));
                 choice.setOnAction((e)-> {
                     MenuItem myChoice = (MenuItem)e.getSource();
                     myComboBox.setText(myChoice.getText());
                 });
                 myComboBox.getItems().addAll(choice);
            }
       }
    }
    
    @FXML
    private void removeSelectedCategory(ActionEvent event) throws SQLException{
        
       if(!categoriesList.getText().equals("Categories")){
           
           removeCategoryMsgError.setText("");
           try{
           db.InsertFun("DELETE FROM category WHERE (CATEGORY_NAME = '"+categoriesList.getText()+"');");
           
           categoriesList.setText("Categories");
           removeCategoryMsg.setText("Category deleted successfully.");
           }
           catch(SQLException a){
             removeCategoryMsgError.setText("You can't delete this category");  
           }
           
       }
       else{
           removeCategoryMsg.setText("");
           removeCategoryMsgError.setText("You must select the category first !");
       }
    }
    
    @FXML
    private void getMemberes(MouseEvent event) throws SQLException{
        
       SplitMenuButton myComboBox = ((SplitMenuButton)event.getSource());
       myComboBox.getItems().clear();
       res = db.SelectFun("select * from user where IS_SUPER != 1");
       List<String> allMembers = new ArrayList<>();
       while(res.next()){
           allMembers.add(res.getString("USER_NAME"));
       }
       MenuItem choice;
       if(allMembers.isEmpty()){
           choice = new MenuItem("No members found");
           choice.setStyle("-fx-text-fill: #AAAAAA; -fx-font-size: 15pt ;-fx-font-weight: bold;");
           myComboBox.getItems().addAll(choice);
       }
       else{
           for (int i = 0; i < allMembers.size(); i++) {
                choice = new MenuItem(allMembers.get(i));
                choice.setOnAction((e)-> {
                    MenuItem myChoice = (MenuItem)e.getSource();
                    myComboBox.setText(myChoice.getText());
                });
                myComboBox.getItems().addAll(choice);
            }
       }
    }
    
    @FXML
    private void removeSelectedMember(ActionEvent event) throws SQLException{
        
       if(!membersList.getText().equals("Members")){
           
           removeMemberMsgError.setText("");
           db.InsertFun("DELETE FROM `librarydb`.`user` WHERE (`USER_NAME` = '"+membersList.getText()+"');");
           membersList.setText("Members");
           removeMemberMsg.setText("Member deleted successfully.");
       }
       else{
           removeMemberMsg.setText("");
           removeMemberMsgError.setText("You must choose the member first !");
       }
    }
    
    @FXML
    private void addNewMember(ActionEvent event) throws SQLException{
        
       if( !memberName.getText().trim().equals("") && !memberUsername.getText().trim().equals("") && !memberPassword.getText().trim().equals("") && !memberPhone.getText().trim().equals("") && !memberEmail.getText().trim().equals("") ){
           addMemberMsgError.setText("");
           addMemberMsg.setText("");
           res = db.SelectFun("select * from user where USERNAME = '"+memberUsername.getText().trim()+"';");
           if(!res.next()){
               user = getUser(memberName.getText().trim(),memberUsername.getText().trim(),memberPassword.getText().trim(),memberPhone.getText().trim(),memberEmail.getText().trim(),isAdmin.isSelected());
               int isAdmin = 0;
               if(user.getIsSuper()) isAdmin = 1;
               db.InsertFun("INSERT INTO user VALUES ('"+user.getUserName()+"', '"+user.getPassword()+"', '"+user.getName()+"', '"+user.getEmail()+"', '"+user.getPhone()+"', '"+isAdmin+"');");
               addMemberMsg.setText("Member added successfully.");
           }
           else
               addMemberMsgError.setText("This username already exists !");
       }
       else{
           addMemberMsg.setText("");
           addMemberMsgError.setText("You must fill in all fields !");
       }
    }
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
       BookIds.clear();
       booksList.clear();
       String parameter =""; 
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
   public void  getBookInfo(MouseEvent e) throws SQLException{
       int index =borrowbooklist.getSelectionModel().getSelectedIndex();
       if(index==-1){
       borrowErrorMessage.setText("Please choose a book");
       
       }else{
       bookId =BookIds.get(index);
       
      ResultSet res= db.SelectFun("select Book_TITLE,AUTHOR_NAME,CATEGORY_NAME,BOOK_DATE,COPIES_NBR,DESCRIPTION from book where  BOOK_ID="+bookId);
       while(res.next()){
         bookTitle.setText(res.getString("BOOK_TITLE"));
         bookAuthor.setText(res.getString("AUTHOR_NAME"));
         bookCategory.setText(res.getString("CATEGORY_NAME"));
        Date date = res.getDate("BOOK_DATE");
        LocalDate d = date.toLocalDate();
  
        publicationDate.setValue(d);
        
         numberOfCopies.setText(""+res.getInt("COPIES_NBR"));
       description.setText(res.getString("DESCRIPTION"));
       bookTitle.setDisable(false);
       
       publicationDate.setDisable(false);
       description.setDisable(false);
       numberOfCopies.setDisable(false);
       updateBook.setDisable(false);
       chooseCategories.setDisable(false);
       chooseAuthors.setDisable(false);
       }
       }
   
   
   
   }
   @FXML
   public void updateBook(ActionEvent e) {
       String title = bookTitle.getText();
       String Category = bookCategory.getText();
       String Author = bookAuthor.getText();
       if(chooseCategories.getSelectionModel().getSelectedItem() != null){
        Category = chooseCategories.getSelectionModel().getSelectedItem().toString();}
           if(chooseAuthors.getSelectionModel().getSelectedItem() != null){
        Author = chooseAuthors.getSelectionModel().getSelectedItem().toString();}
           int number=0;
       try{
        number =Integer.parseInt( numberOfCopies.getText());}
       catch(NumberFormatException n){
       updateMessage.setStyle("-fx-text-fill:red;");
        updateMessage.setText("Update failed please enter a valid data");
        return ;
       }
       String descriptions = description.getText();
     try{  
       db.InsertFun("update book set BOOK_TITLE= '"+title+"' ,AUTHOR_NAME='"+Author+"',CATEGORY_NAME='"+Category+"',COPIES_NBR='"+number+"',DESCRIPTION='"+descriptions+"',BOOK_DATE='"+publicationDate.getValue()+"' where BOOK_ID="+bookId+" ");
      updateMessage.setStyle("-fx-text-fill:green;");
        updateMessage.setText("Done!");
        booksList.clear();
         bookTitle.setDisable(true);
       
       publicationDate.setDisable(true);
       description.setDisable(true);
       numberOfCopies.setDisable(true);
       updateBook.setDisable(true);
       chooseCategories.setDisable(true);
       chooseAuthors.setDisable(true);
        
     }
     catch(SQLException a){
         updateMessage.setStyle("-fx-text-fill:red;");
        updateMessage.setText("Update failed please enter a valid data");
     }
   }
   
   @FXML
    private void getCategoriesCombo(MouseEvent event) throws SQLException{
        
      
       categoriesListO.clear();
       res = db.SelectFun("select * from category");
       
       while(res.next()){
           categoriesListO.add(res.getString("CATEGORY_NAME"));
       }
       chooseCategories.setItems(categoriesListO);
            
       
    }
    @FXML
    private void getAuthors(MouseEvent event) throws SQLException{
        
      
       authorsListO.clear();
       res = db.SelectFun("select * from author");
       
       while(res.next()){
           authorsListO.add(res.getString("AUTHOR_NAME"));
       }
       chooseAuthors.setItems(authorsListO);
            
       
    }
    public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        int d = Integer.parseInt(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
    public void checkAuthor(String name) throws SQLException{
           res = db.SelectFun("select * from author where AUTHOR_NAME = '"+name+"';");
           if(!res.next()){
               db.InsertFun("INSERT INTO author VALUES ('"+name+"');");
           }
    }
    
    @FXML
    private void addNewBook(ActionEvent event) throws SQLException{
            
       if( !bookTitle.getText().trim().equals("") && !authorName.getText().trim().equals("") && !categoriesList_addBook.getText().equals("Categories") && !nbCopies.getText().trim().equals("") && !description.getText().trim().equals("") && publicationDate.getValue()!=null){
           addBookMsg.setText("");
           if(!isNumeric(nbCopies.getText())){
               addBookMsg.setTextFill(Color.RED);
               addBookMsg.setText("Enter a positif number of copies !");
           }
           else{
           res = db.SelectFun("select * from book where BOOK_TITLE = '"+bookTitle.getText().trim()+"';");
           if(!res.next()){
               Date date = Date.valueOf(publicationDate.getValue());
               book = getBook(bookTitle.getText().trim(),authorName.getText().trim(),categoriesList_addBook.getText(),date,Integer.parseInt(nbCopies.getText().trim()),description.getText().trim());
               checkAuthor(authorName.getText().trim());
               db.InsertFun("INSERT INTO book(BOOK_TITLE,AUTHOR_NAME,CATEGORY_NAME,BOOK_DATE, COPIES_NBR,DESCRIPTION) VALUES ('"+book.getTitle()+"', '"+book.getAuthor()+"', '"+book.getCategory()+"', '"+book.getDate()+"', '"+book.getCopies()+"', '"+book.getDescription()+"');");
               addBookMsg.setTextFill(Color.GREEN);
               addBookMsg.setText("Book added successfully.");
           }
           else{
               addBookMsg.setTextFill(Color.RED);
               addBookMsg.setText("This book already exists !");
           }
        }
       }
       else{    
           addBookMsg.setTextFill(Color.RED);
           addBookMsg.setText("You must fill in all fields !");
       }
    }
    
    
   
    @FXML
    private void addCategory(ActionEvent event) throws SQLException{
        
       if( !categoryName.getText().trim().equals("")){
           addCategoryMsgError.setText("");
           addCategoryMsg.setText("");
           res = db.SelectFun("select * from category where CATEGORY_NAME = '"+categoryName.getText().trim()+"';");
           if(!res.next()){
               db.InsertFun("INSERT INTO category VALUES ('"+categoryName.getText().trim()+"');");
               addCategoryMsg.setText("Category added successfully.");
           }
           else
               addCategoryMsgError.setText("This category already exists !");
       }
       else{
           addCategoryMsg.setText("");
           addCategoryMsgError.setText("You must fill in all fields !");
       }
    }

   
   void deleteBook()  throws SQLException{
       
       booksList.clear();
        BookIds.clear();
       String parameter =""; 
       int index = SearchBy.getSelectionModel().getSelectedIndex();
        if(SearchBy.getSelectionModel().getSelectedItem()!=null){
         parameter = items.get(index);

        }
         switch(parameter){
   
        case "Category":
           res= db.SelectFun("select BOOK_ID,Book_TITLE,AUTHOR_NAME,CATEGORY_NAME,BOOK_DATE,COPIES_NBR from book where Category_NAME like '"+searchParameterBook.getText()+"%'");
           
           break;
   
        case "Author":
            res= db.SelectFun("select BOOK_ID,Book_TITLE,AUTHOR_NAME,CATEGORY_NAME,BOOK_DATE,COPIES_NBR from book where Author_NAME like '"+searchParameterBook.getText()+"%'");
           
            break;
   
        case "Title":
            res= db.SelectFun("select BOOK_ID,Book_TITLE,AUTHOR_NAME,CATEGORY_NAME,BOOK_DATE,COPIES_NBR from book where BOOK_TITLE like '"+searchParameterBook.getText()+"%'");
            
            break;
        
        default:
            deleteBookMsgError.setText("Please choose the type of search");
            return ;
           
        }
    if(res.next()==false){
        
        deleteBookMsgError.setText("No book exists");
        return ;
    }
      switch(parameter){
   
        case "Category":
           res= db.SelectFun("select BOOK_ID,Book_TITLE,AUTHOR_NAME,CATEGORY_NAME,BOOK_DATE,COPIES_NBR from book where Category_NAME like '"+searchParameterBook.getText()+"%'");
           
           break;
   
        case "Author":
            res= db.SelectFun("select BOOK_ID,Book_TITLE,AUTHOR_NAME,CATEGORY_NAME,BOOK_DATE,COPIES_NBR from book where Author_NAME like '"+searchParameterBook.getText()+"%'");
           
            break;
   
        case "Title":
            res= db.SelectFun("select BOOK_ID,Book_TITLE,AUTHOR_NAME,CATEGORY_NAME,BOOK_DATE,COPIES_NBR from book where BOOK_TITLE like'"+searchParameterBook.getText()+"%'");
            
            break;
        
        default:
            deleteBookMsgError.setText("Please choose the type of search");
            return ;
           
        }
      
    while(res.next()){
         deleteBookMsgError.setText("");
          book = BookFactory.getBook(res.getString("Category_NAME"));
          book.setAuthor(res.getString("AUTHOR_NAME"));
          book.setCopies(res.getInt("COPIES_NBR"));
          book.setDate(res.getDate("BOOK_DATE"));
          book.setTitle(res.getString("BOOK_TITLE"));
          booksList.add(book.toString());
          BookIds.add(res.getInt("BOOK_ID"));
      
      }
      removebooklist.setItems(booksList);
   }
   @FXML 
   public void SearchBooksBys(ActionEvent e) throws SQLException{
        deleteBook();
   }
boolean checkBorrowed(int id) throws SQLException{
    ResultSet res = db.SelectFun("select * from borrow where book_id='"+id+"';");
       return res.next() != false;
}
   
   
 @FXML
public void removeBook(ActionEvent event) throws SQLException{
int index =removebooklist.getSelectionModel().getSelectedIndex();
if(index==-1){
    deleteBookMsgError.setText("Please choose a book");
    deleteBookMsg.setText("");
    
}
else{
    bookId = BookIds.get(index);
if(!checkBorrowed(bookId)){
    db.InsertFun("DELETE FROM BOOK WHERE BOOK_ID = '"+bookId+"';");
    deleteBook();
    deleteBookMsg.setText("Book deleted successfully.");
    deleteBookMsgError.setText("");
}
else{
    deleteBookMsgError.setText("Please choose a book not borrowed.");
    deleteBookMsg.setText("");
}
}
}
   
    
    

   
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }
    
}
