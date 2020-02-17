var express = require('express');
var app = express();

app.get('/', function(req, res){
   res.send("Hello Neher!");
});

app.listen(3000);