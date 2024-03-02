# Weather Forecast Service

## Description

The Weather Forecast Service is a Java Spring Boot project that provides two APIs for retrieving weather forecasts. One API provides information about the forecast for a specific location, while the other gives an hourly breakdown of the forecast for the same location.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/weather-forecast-service.git
    cd weather-forecast-service
    ```

2. Build and run the project using Maven:

    ```bash
    ./mvnw spring-boot:run
    ```

The service will be accessible at `http://localhost:8085`.

## Usage

To use the Weather Forecast Service, make HTTP requests to the provided API endpoints.

```bash
# Get Forecast by Location (Hourly)
curl http://localhost:8085/dice/api/weatherSummary/ofLocationByHourly?location=Delhi

# Get Forecast by Location
curl http://localhost:8085/dice/api/weatherSummary/ofLocation?location=Delhi

## Configuration
Make following changes in the application.properties file
server.port=8085
server.servlet.context-path = /dice/api
