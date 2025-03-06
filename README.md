# Logistics Management Software

A logistics management system designed to handle real-world data and provide RESTful APIs for logistics information based on level mapping (province, district, subdistrict). The system includes features like exporting data, managing warehouses, and last-mile services.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Packages and Architecture](#packages-and-architecture)
- [APIs](#apis)
- [Data Export](#data-export)
- [Database Operations](#database-operations)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [License](#license)

## Project Overview

This project was developed between July 2024 and September 2024, providing a logistics management system with APIs to manage and retrieve information based on a hierarchical level mapping (province, district, subdistrict). It handles data on Fulfillments, Last Mile services, and Warehouses, allowing users to query and export logistics data.

## Technologies Used

- **Java Core**
- **PostgreSQL**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Validation**
- **Apache POI**

## Features

- **RESTful APIs**: To retrieve logistics information based on various hierarchical levels (province, district, subdistrict).
- **Warehouse and Last Mile Services**: API to retrieve data for all Warehouses and Last Mile services associated with specific Fulfillments.
- **Data Export**: Export logistics data based on a specific region using Apache POI.
- **Native Queries**: Retrieve data efficiently using native SQL queries and convert it into DTOs using mappers.
- **Transactional Operations**: Ensure data integrity and rollback with `@Transactional` and `@Modifying`.

## Packages and Architecture

The project follows a layered architecture and includes the following packages:

- **Model**: Contains entity classes representing logistics-related data (Fulfillments, Warehouses, Last Mile services).
- **Controller**: Manages the API requests and responses.
- **Service**: Business logic for handling logistics operations and data transformation.
- **Repository**: Manages database operations using Spring Data JPA, including custom queries.
- **Utility**: Includes mappers for transforming entity data into DTOs and utility methods for exporting data using Apache POI.

## APIs

1. **Get Logistics Information by Level Mapping**  
   Retrieve logistics data based on province, district, and subdistrict:
   ```http
   GET /api/logistics/{province}/{district}/{subdistrict}
