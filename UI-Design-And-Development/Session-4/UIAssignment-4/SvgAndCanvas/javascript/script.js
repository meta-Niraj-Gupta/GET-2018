var canvas = document.getElementById("myCanvas");
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;
var context = canvas.getContext("2d");

//Pattern-1
context.beginPath();
context.fillStyle = "dodgerblue";
context.arc(100, 100, 50, 0, Math.PI * 2, false);
context.fill();

//Pattern-2
context.beginPath();
context.fillStyle = "dodgerblue";
context.arc(100, 250, 50, Math.PI / 2, (Math.PI / 2) * 3, false);
context.fill();

context.beginPath();
context.arc(100, 250, 50, (Math.PI / 2) * 3, Math.PI / 2, false);
context.fillStyle = "grey";
context.fill();

context.beginPath();
context.arc(100, 250, 40, (Math.PI / 2) * 3, Math.PI / 2, false);
context.fillStyle = "white";
context.fill();

//Pattern-3
context.beginPath();
context.arc(300, 100, 50, 0, Math.PI * 2, false);
context.fillStyle = "purple";
context.fill();

context.beginPath();
context.arc(300, 100, 30, 0, Math.PI * 2, false);
context.fillStyle = "white";
context.fill();

//Pattern-4
context.beginPath();
context.arc(300, 250, 50, 0, Math.PI * 2, false);
context.fillStyle = "yellow";
context.fill();

context.beginPath();
context.moveTo(290, 210);
context.lineTo(310, 210);
context.lineTo(310, 240);
context.lineTo(340, 240);
context.lineTo(340, 260);
context.lineTo(310, 260);
context.lineTo(310, 290);
context.lineTo(290, 290);
context.lineTo(290, 260);
context.lineTo(260, 260);
context.lineTo(260, 240);
context.lineTo(290, 240);
context.lineTo(290, 210);
context.fillStyle = "white";
context.fill();

//Pattern-5
context.beginPath();
context.moveTo(500, 150);
context.lineTo(600, 150);
context.lineTo(550, 50);
context.lineTo(500, 150);
context.fillStyle = "purple";
context.fill();

//Pattern-6
context.beginPath();
context.moveTo(500, 200);
context.lineTo(500, 300);
context.lineTo(600, 300);
context.lineTo(600, 200);
context.lineTo(500, 200);
context.fillStyle = "green";
context.fill();
