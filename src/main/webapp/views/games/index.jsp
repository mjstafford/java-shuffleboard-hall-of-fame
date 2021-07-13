<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shuffleboard</title>
  </head>
  <body>
    <h1>Shuffleboard Records </h1>
    <c:forEach items="${requestScope.games}" var="game">
      <h2>RECORD:</h2>
      <div>
        <p>RED TEAM</p>
        <c:out value="Player 1: ${game.redTeamPlayer1}" />
      </div>
      <div>
        <c:out value="Player 2: ${game.redTeamPlayer2}" />
      </div>
      <div>
        <c:out value="Score:  ${game.redTeamScore}" />
      </div>
      <div>
        <p>BLUE TEAM</p>
        <c:out value="Player 1: ${game.blueTeamPlayer1}" />
      </div>
      <div>
        <c:out value="Player 2: ${game.blueTeamPlayer2}" />
      </div>
      <div>
        <c:out value="Score:  ${game.blueTeamScore}" />
      </div>
      <c:if test = "${game.redTeamScore < game.blueTeamScore}">
        <h4> BLUE WON<h4/>
      </c:if>
      <c:if test = "${game.redTeamScore > game.blueTeamScore}">
        <h4> RED WON<h4/>
      </c:if>
    </c:forEach>
  </body>
 </html>