# Art Heist Capstone Project - backend API

## Introduction 
This is a game where the player has to answer art related multiple choice questions. Based on the rarity level (common, rare or legendary) of the artwork displayed, the randomly generated MCQ can be easy, medium or hard.
The rules of the game 
* Answer a question right, and steal the artwork and increase your score
* the game ends when you:
>1.  answer all 10 questions correctly
 >2.  get 3 questions wrong (3 penalties max)
 >3. forfeit the game. 


## Pre-requisites
### Requirements for running back-end game code:
* Download intellij/VSCode for editing/displaying back-end code (intellij preferrable)
* For Command Line Tools, it's recommended to download:
>* Xcode Command line tools (easier terminal control)
>* Postgres + SQL(for the Game Database and its language)
>* Git (for version control)
>* HomeBrew 15.2 (ease of package management)
* Other recommended off-the-web downloads include:
>* Java 17 (back-end code language)
>* Postman(for the API to mimic the front-end responses and test different API requests)
>* Postico (for the viewing of Game database information)
* Using Spring initializr, the recommended dependencies that were incorporated in the back-end code design were:
>* Spring Web
>* Spring Boot DevTools
>* PostgreSQL Driver
>* Spring Data JPA


## Data Structure of project:
The `models` package consists of 4 POJO classes which are used to define how the classes are mapped to the databaseand 1 ENUM:
>1) A `Artwork` POJO class for each work properties, including `title`, `rarity level`, `artist`, `value` etc..
>2) A `ArtworkInGame` POJO class which tells you the artworks that are being used for each game with properties including `stolen`, and `game_id`, `artowkr_id`
>3) A `Game` POJO class for the game information 
>4) A `Player` POJO class with properties including: `name`, list of `games`
>5) A `RarityLevel` Enum for the rarity level of each artwork


The `repositories` package consists of 4 repositories including `ArtworkRepository`, `ArtworkInRepository`, `GameRepository`, `PlayerRepository`.

The `services` package has 4 classes, namely `ArtworkInGameService`, `ArtworkService`, `PlayerService`, `GameService` to handle game logic.

The `controllers` package consists of 4 classes `PlayerController`, `GameController`, `ArtworkInGameController` and `ArtworkController` which enables you to perform different requests corresponding to the `CRUD` functionalities
The `DataLoader` in the `components` package is used to pre-populate the `artworks` table and added a few `players` in the database.You may wish to connect to Postico to view/inspect the tables.

### UML Diagram
![Screenshot 2023-06-19 at 10 05 13](https://github.com/IsabelG96/capstone_backend/assets/56633439/ea009a32-0ad7-41fe-9522-8929242c2f95)

### ERD (for database structure)
![Screenshot 2023-06-19 at 10 05 34](https://github.com/IsabelG96/capstone_backend/assets/56633439/d58be084-d1c4-4d76-a7a2-9a1ee782a8ab)




## Github Username:
- Kelly Wong: KKLW97
- Katie Bamford: klb545
- Hayan Butt: HayanButt
- Isabel Galwey: IsabelG96
- Stella Annor: StellaA30