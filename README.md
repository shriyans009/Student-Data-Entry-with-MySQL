# Student-Data-Entry-with-MySQL

## 📌 Project Overview

This is a **menu-driven Java program** that demonstrates the concepts of **classes, array of objects, instance members, and constructors**. The program manages student records using **ArrayList**, allowing users to:

✔️ Add Students\
✔️ Display All Students\
✔️ Search for a Student (by PRN, Name, or Position)\
✔️ Update/Edit Student Details\
✔️ Delete a Student

The project follows **best coding practices** and has been structured into multiple Java files for clarity and maintainability.

---

## 🚀 Features Implemented

### **1️⃣ ************************************`Student.java`************************************ (Student Class)**

This class represents a student with the following attributes:

- **PRN** (Permanent Registration Number)
- **Name**
- **Department**
- **Batch**
- **CGPA**

**Methods:**

- Constructor to initialize attributes.
- Getter and Setter methods.
- `display()` method to show student details.

### **2️⃣ ************************************`StudentOperations.java`************************************ (Student Management Class)**

Handles all operations related to students.

**Functions Implemented:**

- **Constructor** → Initializes an `ArrayList<Student>`.
- **`addStudent()`** → Adds a student to the list.
- **`displayStudents()`** → Displays all students.
- **`searchByPRN(int prn)`** → Searches for a student using PRN.
- **`searchByName(String name)`** → Searches for a student using name.
- **`searchByPosition(int index)`** → Retrieves a student by list index.
- **`updateStudent(int prn, String name, String dept, String batch, float cgpa)`** → Updates student details.
- **`deleteStudent(int prn)`** → Deletes a student by PRN.

### **3️⃣ ************************************`Main.java`************************************ (Driver Program)**

The main program provides a **menu-driven interface** for user interaction.

---

## 🎯 How to Run the Project

### **1️⃣ Clone the Repository**

```sh
git clone <repository-url>
cd StudentOperations
```

### **2️⃣ Compile the Java Files**

```sh
javac Main.java Student.java StudentOperations.java
```

### **3️⃣ Run the Program**

```sh
java Main
```

---

## 📌 Coding Guidelines Followed

✅ **Modular Code:** Separate Java files for different functionalities.\
✅ **Object-Oriented Principles:** Used classes, objects, and encapsulation.\
✅ **Best Practices:** Proper variable naming, comments, and efficient data handling.\
✅ **User-Friendly Menu:** Clear instructions and structured program flow.
