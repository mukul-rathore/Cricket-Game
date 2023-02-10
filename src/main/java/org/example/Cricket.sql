create database Cricket;
use Cricket;

create table team1_scorecard
(
 player_id INT,
 player_name varchar(50),
 runs INT,
 player_role varchar(50)
);

create table team2_scorecard
(
 player_id INT,
 player_name varchar(50),
 runs INT,
 player_role varchar(50)
);

drop table final_scorecard;

create table final_scorecard (
	team_name varchar(50),
    team_score int,
    team_wickets int,
    team_ballsPlayed int,
    game_status varchar(50)
);

Select * from team1_scorecard;
Select * from team2_scorecard;
Select * from final_scorecard;