<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	
%>

<div id="groupView" class="groupView_${param.clubId}">
	<div class="title">${param.cName}</div>
	<div class="goal">${param.goal}</div>
	<input id="hashtag"></input>
	<span class="line"></span>
	<iconify-icon class="groupImage" icon="mingcute:group-line"></iconify-icon>
	<div class="groupCount">${param.current_member} / ${param.max_member}</div>
</div>

<script>
	var groupView = document.querySelector('.groupView_<%=request.getParameter("clubId")%>');
	
	var hashtagInput = groupView.querySelector('#hashtag');
	var tagify = new Tagify(hashtagInput);
	
	tagify.on('add', function() {
		console.log(tagify.value); 
	});	
	
	tagify.addTags(<%=request.getParameter("tags")%>);
	tagify.setReadonly(true);
	
	groupView.onclick = () => {
		groupInfo_set(
				<%=request.getParameter("clubId")%>, 
				"<%=request.getParameter("cName")%>", 
				"<%=request.getParameter("goal")%>", 
				"<%=request.getParameter("info")%>",
				<%=request.getParameter("current_member")%>,
				<%=request.getParameter("max_member")%>,
				<%=request.getParameter("tags")%>
		);
	};
</script>