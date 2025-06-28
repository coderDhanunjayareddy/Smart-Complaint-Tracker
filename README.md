# 📌 Smart Complaint Tracker

This is a **minor project** built as part of a Java Full Stack course. It is a web-based complaint tracking system that allows users to raise, track, and manage complaints efficiently.

---

## 📁 Project Structure

```
Smart-Complaint-Tracker/
├── src/                      # Java source code
│   ├── main/
│   │   ├── java/
│   │   └── resources/
├── .gitignore
├── pom.xml                  # Maven configuration
├── mvnw, mvnw.cmd           # Maven wrapper scripts
└── README.md
```

---

## 🛠️ Technologies Used

- **Backend**: Java, Spring Boot, Spring MVC, Spring Data JPA
- **Frontend**: Thymeleaf (server-side rendering)
- **Database**: MySQL
- **Build Tool**: Maven
- **Tools**: Git, Postman, Eclipse/IntelliJ

---

## 🔧 How to Run the Project

1. **Clone the repository**:
   ```bash
   git clone <your-git-repo-url>
   cd Smart-Complaint-Tracker
   ```

2. **Configure the database**:
   Update the `application.properties` file under `src/main/resources/`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build and run the application**:
   You can run it directly from your IDE or via terminal:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the app**:
   Navigate to `http://localhost:8080` in your browser.

---

## 📌 Features

- User registration and login
- Complaint creation and tracking
- Admin panel for managing complaints
- Email notifications (if implemented)
- User-friendly interface with Thymeleaf templates

---

## 📚 Learning Outcomes

- Full-stack web app development using Java
- CRUD operations with Spring Data JPA
- MVC architecture in Spring Boot
- Practical Git and GitHub usage

---

## 🤝 Contributing

This project was created for educational purposes. Contributions are welcome!

---

## 📄 License

This project is licensed for educational/demo use only.
