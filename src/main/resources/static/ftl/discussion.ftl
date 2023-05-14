<!DOCTYPE html>
<html>
<head>
    <title>WebSocket Chat</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script>
        var socket = new SockJS('/ws');
        var stompClient = Stomp.over(socket);

        stompClient.connect({}, function (frame) {
            stompClient.subscribe('/topic/chat', function (message) {
                // Обработка полученного сообщения
                var chatMessage = JSON.parse(message.body);
                // Действия с сообщением, например, добавление его в чат-окно
                console.log(chatMessage);
            });
        });

        // Функция для отправки сообщения в чат
        function sendMessage() {
            var messageInput = document.getElementById("messageInput");
            var message = messageInput.value;
            stompClient.send("/app/chat", {}, message);
            messageInput.value = "";
        }
    </script>
</head>
<body>
<h1>WebSocket Chat</h1>

<div id="chatWindow">
    <!-- Окно чата, куда добавляются сообщения -->
</div>

<div>
    <input type="text" id="messageInput" placeholder="Введите сообщение">
    <button onclick="sendMessage()">Отправить</button>
</div>
</body>
</html>
