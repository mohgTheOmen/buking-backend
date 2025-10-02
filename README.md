# Buking Backend

A Spring Boot backend for property booking management.

## To Do

- [X] Implement the search function

## Features

- Property listing and details
- Search properties by name or address

## Project Structure

- `src/main/java` - Source code
- `src/main/resources` - Configuration and templates
- `src/test/java` - Unit tests

## Getting Started

1. Clone the repository
2. Build with Maven:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## License

MIT

## Usage

- Access property list: `http://localhost:8080/properties`
- Search properties: `http://localhost:8080/properties/search?query=SEARCH_TERM`
- View property details: `http://localhost:8080/properties/{id}`
