# csv2db

A simple Java command-line utility to import CSV data into a database.

## Overview

`csv2db` reads CSV files and inserts the rows into a target database table using JDBC.

## Features

- Import CSV files with or without headers
- Map CSV columns to database columns
- Support for custom delimiters
- Batch inserts for improved performance

## Requirements

- Java 8 or later
- JDBC driver for the target database
- Build tool such as Maven or Gradle

## Usage

1. Build the project:

   ```bash
   mvn clean package
   ```

2. Run the tool with the required arguments:

   ```bash
   java -jar target/csv2db.jar \
     --csv /path/to/input.csv \
     --table target_table \
     --url jdbc:postgresql://localhost:5432/mydb \
     --user dbuser \
     --password dbpass
   ```

## Configuration

- `--csv`: path to the CSV file
- `--table`: target database table name
- `--url`: JDBC connection URL
- `--user`: database username
- `--password`: database password
- `--delimiter`: optional CSV delimiter (default is `,`)

## Notes

Adjust the JDBC URL and driver settings for your specific database.
