<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WebSocket Demo</title>
	<style type="text/css">
		html, body{
			margin: 0;
			padding: 0;
		}
		header{
			width: 100%; 
			height: 100px; 
			text-align: center; 
			font-size: 50px; 
			line-height: 100px; 
			font-family: "微软雅黑";
			border-bottom: 1px solid black;
			margin-bottom: 10px;
		}
		#submit{
			width: 200px;
			height: 50px;
			font-size: 20px;
		}
		#submit:HOVER {
			cursor: pointer;
		}
		.btn-zone{ text-align: center;}
		#messages{ padding: 10px; font-size: 20px;}
		.message:nth-child(2n+1){ color: olive;}
	</style>
</head>
<body>
<header>
	WebSocket
</header>
<div>
	<div class="btn-zone">
		<input id="submit" type="submit" value="sendMessage" onclick="send()" />
	</div>
	<div id="messages"></div>
</div>
	
	<script type="text/javascript">
		var webSocket = new WebSocket(
				'ws://localhost:8080/websocket/chat?query=Picasso');
		var reciver = document.getElementById('messages');
		
		webSocket.onerror = function(event) {
			onError(event)
		};

		webSocket.onopen = function(event) {
			onOpen(event)
		};

		webSocket.onmessage = function(event) {
			onMessage(event)
		};

		function onMessage(event) {
			var mess = document.createElement("div")
			mess.setAttribute("class", "message");
			var text = document.createTextNode(new Date().toLocaleTimeString() + " : " +event.data);
			mess.appendChild(text);
			reciver.appendChild(mess);
		}

		function onOpen(event) {
			reciver.innerHTML = new Date().toLocaleTimeString() + " : Connection established";
		}

		function onError(event) {
			reciver.innerHTML = "<b style='color:red;'>Connected faild</b>";
		}

		function send() {
			webSocket.send('hello ' + Math.random());
			return false;
		}
	</script>
</body>
</html>
