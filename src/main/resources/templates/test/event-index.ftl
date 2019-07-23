<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8"/>

    <title>Demo Chat</title>

    <link href="css/bootstrap.css" rel="stylesheet">

    <style>
        body {
            padding: 20px;
        }

        #console {
            height: 400px;
            overflow: auto;
        }

        .username-msg {
            color: orange;
        }

        .connect-msg {
            color: green;
        }

        .disconnect-msg {
            color: red;
        }

        .send-msg {
            color: #888
        }
    </style>
</head>

<body>

<h1 id="title"></h1>

<br/>

<div id="console" class="well">
</div>

<form class="well form-inline" onsubmit="return false;">
    <input id="msg" class="input-xlarge" type="text" placeholder="Type something..."/>
    <button type="button" onClick="sendMessage()" class="btn" id="send">Send</button>
    <button type="button" onClick="sendDisconnect()" class="btn">Disconnect</button>
</form>

<script src="js/socket.io/socket.io.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/commom.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>

<script>
    var userName = getCookie("username");
    var socket = io.connect('http://localhost:9092');

    socket.on('connect', function () {
        output('<span class="connect-msg">Client has connected to the server!</span>');
    });

    socket.on('message', function (data) {
        output('<span class="username-msg">' + data.userName + ':</span> ' + data.message);
    });

    socket.on('disconnect', function () {
        output('<span class="disconnect-msg">The client has disconnected!</span>');
    });

    function sendDisconnect() {
        socket.disconnect();
    }

    function sendMessage() {
        var message = $('#msg').val();
        $('#msg').val('');
        socket.emit('message', {userName: userName, message: message});
    }

    function output(message) {
        var currentTime = "<span class='time'>" + moment().format('HH:mm:ss.SSS') + "</span>";
        var element = $("<div>" + currentTime + " " + message + "</div>");
        $('#console').append(element);
    }

    $(document).keydown(function (e) {
        if (e.keyCode == 13) {
            $('#send').click();
        }
    });
</script>
<script>
    // $(function () { })
</script>
</body>

</html>
