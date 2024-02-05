# Stock Market Data Extraction Service

## Prerequisites

Before you begin, make sure you have the following installed on your machine:

- Docker: [Install Docker](https://docs.docker.com/get-docker/)
- Docker Compose: [Install Docker Compose](https://docs.docker.com/compose/install/)

## Getting Started

1. **Clone the repository:**

    ```bash
    git clone https://github.com/vkmguy/data-extraction-service.git
    cd data-extractoin-service
    ```

2. **Build and start the services:**

    ```bash
    docker-compose up --build
    ```

   This command will build the Docker images and start the services.

    1. **Access your application:**
        - Web App: [http://localhost:5000](http://localhost:5000)
        - GET request to fetch data from yahoo finance API: [http://localhost:5000/fetchHistoricalData/DJI](http://localhost:5000/fetchHistoricalData/DJI)
        - GET request to split the data into TRAIN AND TEST set: [http://localhost:5000/api/strategies/trainTestSplit](http://localhost:5000/api/strategies/trainTestSplit)
5. **To stop the services, press `Ctrl + C` in the terminal where `docker-compose` is running.**

## Services

### 

The quartz app is used to schedule data extraction jobs from the YFinance API. Visit [http://localhost:8090/api](http://localhost:8090/api) to access the APIs.

## Troubleshooting

- If you encounter issues, check the logs of individual containers for more details.

## License

This project is licensed under the [MIT License](LICENSE).
