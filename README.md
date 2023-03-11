# GameOfCricket 

# Flow

1. first create person

`   `Post "/person/"

`   `Details needed for creating person:

`   `first name (String type)

`   `second name (String type)

`   `age (number - which should be in pre-decided range (ByDefault in range of 20-45))

2. after creating persons, you have to create team     Post "/team/"

`    `Details needed for creating team:

`    `name (String type)

3. after making teams, you can decide teams, and players for team and create

match                                                                                                                                between them

`  `Post "/match/"

`  `Details needed for creating team:

`  `team1 :

`    `team\_id (long)

`    `team size (positive integer)

`    `list of players:

`      `for each player:

`        `person id

`        `role (Bowler or Batsman)

`        `batting Order

`  `team2:

`    `team\_id (long)

`    `team size (positive integer)

`    `list of players:

`      `for each player:

`        `person id

`        `role (Bowler or Batsman)

`        `batting Order

Validations performed :
1.
      1. team size should match to list of players
      1. all players in teams only created if persons are exist
      1. minimum 2 bowlers should be in your team
      1. order no for all bowlers should unique and positive
      1. team size for both teams should be same
      1. players should be unique in both teams
      1. teams should be created first before creaing match


4. Now we are ready to start match 

`    `Post "/match/start/{id}"

`    `You will get these details as response:

Toss result:

First Inning bowling and batting summary Second Inning bowling and batting summary Match final result

Validation : match with given id should exist and not played before.


# Database Design

<img width="896" alt="Pasted Graphic" src="https://user-images.githubusercontent.com/123222064/224466836-3cdee354-484b-4839-87c1-8f302a25ae3a.png">


