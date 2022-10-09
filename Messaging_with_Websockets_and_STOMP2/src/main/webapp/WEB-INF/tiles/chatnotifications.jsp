<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

	
<sec:authorize access="isAuthenticated()">

<c:url var="webSocketEndpoint" value="/chat" scope="request" />
<%-- <h2>${webSocketEndpoint}</h2> --%>

<c:url var="notificationQueue" value="/user/queue/newmessages" />
<%-- <h2>${notificationQueue}</h2> --%>


<c:url var="notificationUrl" value="/messages?p=1" />
<%-- <h2>${notificationUrl}</h2> --%>



	<script>
	
	function alertUser(from, text) {
		
		if (!("Notification" in window)) {
			// Notifications not supported
			return;
		}
		else if (Notification.permission === "denied") {
			// User doesn't want notifications
			return;
		}
		else if (Notification.permission !== "granted") {
			Notification.requestPermission();
		}
		
		if (Notification.permission === "granted") {
			var notification = new Notification(from, { body: text });
			
			notification.onclick = function () {
				window.location.href = "${notificationUrl}";
			}
		}
	}

	
	
	var connectionManager = new ConnectionManager("${webSocketEndpoint}");
		
		
		
	connectionManager.addSubscription("${notificationQueue}", function(messageJson) {
			var message = JSON.parse(messageJson.body);
			//alert(message.text);
			alertUser(message.from, message.text);
	});
		
	
	</script>

</sec:authorize>