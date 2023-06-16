#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <ctime>

using namespace std;

class Book {
public:
    string title;
    string author;
    bool borrowed;
    time_t borrowDate;
    time_t returnDate;

    Book(string title, string author) {
        this->title = title;
        this->author = author;
        this->borrowed = false;
        this->borrowDate = 0;
        this->returnDate = 0;
    }
};

class Student {
public:
    string name;
    vector<Book*> borrowedBooks;

    Student(string name) {
        this->name = name;
    }

    void borrowBook(Book* book) {
        book->borrowed = true;
        book->borrowDate = time(nullptr);
        book->returnDate = book->borrowDate + 10 * 24 * 60 * 60; // 10 days deadline
        borrowedBooks.push_back(book);
        cout << "Book \"" << book->title << "\" borrowed successfully by " << name << "." << endl;
    }

    void returnBook(Book* book) {
        book->borrowed = false;
        borrowedBooks.erase(remove(borrowedBooks.begin(), borrowedBooks.end(), book), borrowedBooks.end());

        time_t currentTime = time(nullptr);
        if (currentTime > book->returnDate) {
            int daysLate = (currentTime - book->returnDate) / (24 * 60 * 60);
            int fineAmount = 1000 * daysLate;
            cout << "Book \"" << book->title << "\" returned late by " << daysLate << " days. Fine imposed: $" << fineAmount << endl;
        } else {
            cout << "Book \"" << book->title << "\" returned successfully by " << name << "." << endl;
        }
    }
};

class Library {
private:
    vector<Book*> books;
    vector<Student*> students;

public:
    void addBook() {
        string title, author;
        cout << "Enter the title of the book: ";
        cin.ignore();
        getline(cin, title);
        cout << "Enter the author of the book: ";
        getline(cin, author);

        Book* book = new Book(title, author);
        books.push_back(book);
        cout << "Book \"" << book->title << "\" added to the library." << endl;
    }

    void addStudent() {
        string name;
        cout << "Enter the name of the student: ";
        cin.ignore();
        getline(cin, name);

        Student* student = new Student(name);
        students.push_back(student);
        cout << "Student \"" << student->name << "\" added to the library." << endl;
    }

    void borrowBook(string studentName, string bookTitle) {
        Student* student = findStudent(studentName);
        Book* book = findBook(bookTitle);

        if (student && book && !book->borrowed) {
            student->borrowBook(book);
        } else {
            cout << "Book \"" << bookTitle << "\" is not available for borrowing." << endl;
        }
    }

    void returnBook(string studentName, string bookTitle) {
        Student* student = findStudent(studentName);
        Book* book = findBook(bookTitle);

        if (student && book && book->borrowed) {
            student->returnBook(book);
        } else {
            cout << "Book \"" << bookTitle << "\" is not borrowed by " << studentName << "." << endl;
        }
    }

    void displayBooks() {
        cout << "Available Books:" << endl;
        for (Book* book : books) {
            if (!book->borrowed) {
                cout << "Title: " << book->title << ", Author: " << book->author << endl;
            }
        }
    }

    void displayBorrowedBooks() {
        cout << "Borrowed Books:" << endl;
        for (Book* book : books) {
            if (book->borrowed) {
                cout << "Title: " << book->title << ", Author: " << book->author << ", Borrowed by: " << getStudentNameByBook(book) << ", Borrowed Date: " << getBorrowedDateAsString(book) << ", Deadline: " << getDeadlineAsString(book) << endl;
            }
        }
    }

    void displayNotBorrowedBooks() {
        cout << "Not Borrowed Books:" << endl;
        for (Book* book : books) {
            if (!book->borrowed) {
                cout << "Title: " << book->title << ", Author: " << book->author << endl;
            }
        }
    }

    void displayReturnedBooks() {
        cout << "Returned Books:" << endl;
        for (Book* book : books) {
            if (!book->borrowed) {
                time_t currentTime = time(nullptr);
                if (currentTime > book->returnDate) {
                    int daysLate = (currentTime - book->returnDate) / (24 * 60 * 60);
                    int fineAmount = 1000 * daysLate;
                    cout << "Title: " << book->title << ", Author: " << book->author << ", Return Date: " << getReturnDateAsString(book) << ", Fine: $" << fineAmount << endl;
                } else {
                    cout << "Title: " << book->title << ", Author: " << book->author << ", Return Date: " << getReturnDateAsString(book) << ", Fine: $0" << endl;
                }
            }
        }
    }

    void displayDismissedStudents() {
        cout << "Dismissed Students:" << endl;
        for (Student* student : students) {
            if (student->borrowedBooks.size() >= 10) {
                int lateReturns = 0;
                for (Book* book : student->borrowedBooks) {
                    time_t currentTime = time(nullptr);
                    if (currentTime > book->returnDate) {
                        lateReturns++;
                    }
                }
                if (lateReturns == student->borrowedBooks.size()) {
                    cout << "Student: " << student->name << endl;
                }
            }
        }
    }

    string getBorrowedDateAsString(Book* book) {
        time_t borrowedDate = book->borrowDate;
        tm* t = localtime(&borrowedDate);
        char buffer[80];
        strftime(buffer, sizeof(buffer), "%Y-%m-%d", t);
        return buffer;
    }

    string getReturnDateAsString(Book* book) {
        time_t returnDate = book->returnDate;
        tm* t = localtime(&returnDate);
        char buffer[80];
        strftime(buffer, sizeof(buffer), "%Y-%m-%d", t);
        return buffer;
    }

private:
    Book* findBook(string title) {
        for (Book* book : books) {
            if (book->title == title) {
                return book;
            }
        }
        return nullptr;
    }

    Student* findStudent(string name) {
        for (Student* student : students) {
            if (student->name == name) {
                return student;
            }
        }
        return nullptr;
    }

    string getStudentNameByBook(Book* book) {
        for (Student* student : students) {
            if (find(student->borrowedBooks.begin(), student->borrowedBooks.end(), book) != student->borrowedBooks.end()) {
                return student->name;
            }
        }
        return "";
    }

    string getDeadlineAsString(Book* book) {
        time_t deadline = book->returnDate;
        tm* t = localtime(&deadline);
        char buffer[80];
        strftime(buffer, sizeof(buffer), "%Y-%m-%d", t);
        return buffer;
    }
};

int main() {
    Library library;
    
    int choice;
    do {
        cout << "\n**** Library Management System ****" << endl;
        cout << "1. Add Book" << endl;
        cout << "2. Add Student" << endl;
        cout << "3. Borrow Book" << endl;
        cout << "4. Return Book" << endl;
        cout << "5. Display Available Books" << endl;
        cout << "6. Display Borrowed Books" << endl;
        cout << "7. Display Not Borrowed Books" << endl;
        cout << "8. Display Returned Books" << endl;
        cout << "9. Display Dismissed Students" << endl;
        cout << "0. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                library.addBook();
                break;
            }
            case 2: {
                library.addStudent();
                break;
            }
            case 3: {
                string studentName, bookTitle;
                cout << "Enter student name: ";
                cin.ignore();
                getline(cin, studentName);
                cout << "Enter book title: ";
                getline(cin, bookTitle);
                library.borrowBook(studentName, bookTitle);
                break;
            }
            case 4: {
                string studentName, bookTitle;
                cout << "Enter student name: ";
                cin.ignore();
                getline(cin, studentName);
                cout << "Enter book title: ";
                getline(cin, bookTitle);
                library.returnBook(studentName, bookTitle);
                break;
            }
            case 5: {
                library.displayNotBorrowedBooks();
                break;
            }
            case 6: {
                library.displayBorrowedBooks();
                break;
            }
            case 7: {
                library.displayNotBorrowedBooks();
                break;
            }
            case 8: {
                library.displayReturnedBooks();
                break;
            }
            case 9: {
                library.displayDismissedStudents();
                break;
            }
            case 0: {
                cout << "Exiting the program. Goodbye!" << endl;
                break;
            }
            default: {
                cout << "Invalid choice. Please try again." << endl;
                break;
            }
        }
    } while (choice != 0);

    // Clean up memory
  

    return 0;
}
