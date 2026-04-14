# CartForge - Scalable E-commerce Backend

CartForge is a scalable backend application built using Spring Boot that provides core functionalities of an e-commerce system. The project is designed with a modular architecture and follows RESTful API principles.

---

## Features

- User Authentication (Register & Login)
- JWT-based Authentication & Authorization
- Role-based Access Control (ADMIN / USER)
- Product Management (Create, Read, Update, Delete)
- Cart Management (Add, View, Update, Remove items)
- Secure user-specific cart operations (no client-side userId)
- Input validation using Jakarta Validation
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

## Authentication & Authorization Flow

1. User registers using `/api/auth/register`
2. User logs in via `/api/auth/login`
3. Server generates a JWT token with user role
4. Token is sent in Authorization header: `Authorization: Bearer <token>`
5. JWT is validated via filter and user is set in SecurityContext
6. Role-based access is enforced using Spring Security


---

## API Endpoints

### Auth APIs
- `POST /api/auth/register` → Register user (USER / ADMIN)
- `POST /api/auth/login` → Login & get JWT token

### Product APIs

| Method | Endpoint | Access | Description |
|--------|---------|--------|------------|
| POST | `/api/products` | ADMIN | Add product |
| GET | `/api/products` | USER, ADMIN | View all products |
| PUT | `/api/products/{id}` | ADMIN | Update product |
| DELETE | `/api/products/{id}` | ADMIN | Delete product |

---

### Cart APIs

| Method | Endpoint | Access | Description |
|--------|---------|--------|------------|
| POST | `/api/cart` | USER | Add item to cart |
| GET | `/api/cart` | USER | Get logged-in user cart |
| PUT | `/api/cart/{productId}` | USER | Update quantity |
| DELETE | `/api/cart/{productId}` | USER | Remove item |

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

- Order management system
- Payment integration
- Redis caching for performance

---

## Author

Developed by Arnav Tongia

---

## Notes

This project demonstrates real-world backend development concepts including secure API design, JWT authentication, role-based access control, and scalable architecture using Spring Boot.