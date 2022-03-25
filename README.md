# Stock Fetch

## Project Description

Stock Fetch is a API wrapper for the IEX Cloud API. The IEX Cloud API offers a significant amount of endpoints and Stock Fetch seeks to simplify the available endpoints and add some custom endpoints.
## Technologies Used

* Java - version 8.0
* Spring Boot - version 2.6.4
* Lombok - version 1.8.22
* Jackson - version 2.13.1

## Features

List of features ready and TODOs for future development
* Ability to query specific symbol (e.g. AAPL)
   > http://localhost:8080/StockFetch/quote/AAPL
* Example of custom aggregate query
> http://localhost:8080/StockFetch/quotes/marketCap

To-do list:
* Expand upon the available list of custom aggregate queries
* Add the ability to grab data by specific exchange

## Getting Started
   
To get up and running with Stock Fetch locally you will need a JDK of at least version 8 or higher and you will also need Maven installed.

- clone the repo
> git clone git@github.com:Jakeamorr/stock-fetch.git
- move to the project directory and install Maven dependencies and start the application
> cd stock-fetch
> mvn install
> mvn spring-boot:run

## Usage

Now we can access the available endpoints via a browser or your favorite tool for working with apis.
> http://localhost:8080/StockFetch/quote/AAPL

## License

This project uses the following license: [MIT License](<https://opensource.org/licenses/MIT>).
