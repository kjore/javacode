<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>实时时间</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #83a4d4, #b6fbff);
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            color: #333;
        }
        .time-container {
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.15);
            padding: 40px 60px;
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        .time-container:hover {
            transform: scale(1.03);
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.2);
        }
        h1 {
            color: #2c3e50;
            margin-bottom: 25px;
            font-size: 32px;
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
        }
        #time {
            font-size: 38px;
            font-weight: bold;
            color: #2980b9;
            padding: 20px;
            border-radius: 8px;
            background-color: #f8f9fa;
            display: inline-block;
            min-width: 300px;
            box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1);
            text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.05);
        }
        .date-info {
            margin-top: 20px;
            font-size: 18px;
            color: #34495e;
        }
        .animated-border {
            position: relative;
            margin-top: 15px;
            height: 4px;
            width: 80%;
            background: linear-gradient(90deg, #3498db, #9b59b6, #e74c3c, #f1c40f);
            background-size: 400% 400%;
            animation: gradient 5s ease infinite;
            border-radius: 2px;
        }
        @keyframes gradient {
            0% {background-position: 0% 50%;}
            50% {background-position: 100% 50%;}
            100% {background-position: 0% 50%;}
        }
    </style>
    <script>
        function updateTime() {
            const now = new Date();
            document.getElementById("time").innerText = now.toLocaleTimeString();
            document.getElementById("date").innerText = now.toLocaleDateString('zh-CN', {
                year: 'numeric',
                month: 'long',
                day: 'numeric',
                weekday: 'long'
            });
        }
        setInterval(updateTime, 1000);

        // 添加页面加载特效
        window.addEventListener('load', function() {
            document.querySelector('.time-container').style.opacity = '0';
            setTimeout(function() {
                document.querySelector('.time-container').style.transition = 'opacity 1s ease';
                document.querySelector('.time-container').style.opacity = '1';
            }, 100);
        });
    </script>
</head>
<body onload="updateTime()">
<div class="time-container">
    <h1>当前时间</h1>
    <p id="time"></p>
    <div class="animated-border"></div>
    <p id="date" class="date-info"></p>
</div>
</body>
</html>