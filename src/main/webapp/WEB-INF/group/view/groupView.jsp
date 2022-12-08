<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="groupView" onclick = "groupInfo_set(this)">	
	<div id="cName" class="title">${clubData.getCname()}</div>
	<div id="goal" class="goal">${clubData.getGoal()}</div>
	<input id="hashtag" value="${hashtags.get(Long.valueOf(clubData.getClubId()))}"></input>
	<span class="line"></span>
	<iconify-icon class="groupImage" icon="mingcute:group-line"></iconify-icon>
	<div id="member" class="groupCount">${members.get(Long.valueOf(clubData.getClubId())).size()} / ${clubData.getMax_member()}</div>
	
	<input id="clubId" type="hidden" value="${clubData.getClubId()}"></input>
	<input id="info" type="hidden" value="${clubData.getInfo()}"></input>
	<input id="hashtags" type="hidden" value="${hashtags.get(Long.valueOf(clubData.getClubId()))}"></input>
</div>