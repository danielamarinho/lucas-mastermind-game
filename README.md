# lucas-mastermind-game


## Running the application

First, create the database container with the following command:

`docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres@123 -e POSTGRES_DB=mastermindgame -p 5432:5432 -d postgres`

Then use the bootRun command to run the app:

`./gradlew bootRun`
