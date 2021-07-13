<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shuffleboard</title>
  </head>
  <body>
    <h1> Add Shuffleboard Record </h1>
    <form action="/games" method="post">
      <h2> RED TEAM </h2>
      <div>
        <label for="redTeamPlayer1">player 1: </label>
        <input type="text" id="redTeamPlayer1" name="redTeamPlayer1">
      </div>
      <div>
        <label for="redTeamPlayer2">player 2: </label>
        <input type="text" id="redTeamPlayer2" name="redTeamPlayer2">
      </div>
      <div>
        <label for="redTeamScore">Score: </label>
        <input type="text" id="redTeamScore" name="redTeamScore">
      </div>

      <h2> BLUE TEAM </h2>
      <div>
        <label for="blueTeamPlayer1">player 1: </label>
        <input type="text" id="blueTeamPlayer1" name="blueTeamPlayer1">
      </div>
      <div>
        <label for="blueTeamPlayer2">player 2: </label>
        <input type="text" id="blueTeamPlayer2" name="blueTeamPlayer2">
      </div>
      <div>
        <label for="blueTeamScore">Score: </label>
        <input type="text" id="blueTeamScore" name="blueTeamScore">
      </div>
      <div>
        <p> ------------------------------------------------  </p>
        <input type="submit" value="Submit Shuffleboard Record">
      </div>
    </form>
  </body>
 </html>