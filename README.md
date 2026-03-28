# CartForge - Scalable E-commerce Backend

CartForge is a scalable backend application built using Spring Boot that provides core functionalities of an e-commerce system. The project is designed with a modular architecture and follows RESTful API principles.

---

## Features

- User Authentication (Register & Login)
- JWT-based Authentication & Authorization
- Product Management (Add & View Products)
- Cart Management (Add to Cart & View Cart)
- PostgreSQL Database Integration
- Secure REST APIs with Spring Security

---

## Architecture

The project follows a layered architecture:

- **Controller Layer** → Handles API requests
- **Service Layer** → Business logic
- **Repository Layer** → Database interaction
- **Model Layer** → Entity classes

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT (JSON Web Tokens)
- Maven

---

## Authentication Flow

1. User registers using `/api/auth/register`
2. User logs in via `/api/auth/login`
3. Server generates a JWT token
4. Token is used to access protected APIs

---

## API Endpoints

### Auth APIs
- `POST /api/auth/register` → Register user
- `POST /api/auth/login` → Login & get JWT token

### Product APIs
- `POST /api/products` → Add product
- `GET /api/products` → Get all products

### Cart APIs
- `POST /api/cart` → Add item to cart
- `GET /api/cart/{userId}` → Get user cart

---

## Setup & Run

1. Clone the repository
2. Create PostgreSQL database:
   ```
   cartforge
   ```
3. Configure database in `application.properties`:
   ```
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```
5. Test APIs using Postman

---

## Testing

- Use Postman to test APIs
- Login first to get JWT token
- Use token in Authorization header for protected APIs

---

## Future Improvements

- Password encryption (BCrypt)
- Order management system
- Payment integration
- Redis caching for performance
- Role-based access control (Admin/User)

---

## Author

Developed by [Arnav Tongia]

---

## Notes

This project was built to gain hands-on experience in backend development, REST API design, authentication, and real-world system architecture.