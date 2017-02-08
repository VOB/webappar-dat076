/*

    This is the router for pathes /todo/ (but not /todo/list)



*/

var express = require('express');
var router = express.Router();
var todolist = require('../models/todolist.js');
var TodoNote = require('../models/todonote.js');
var list = require('./list.js');
var User = require('../models/user.js');
var userRegistry = require('../models/userregistry.js');

// Hierarcical routing
router.use("/list", list);

router.get('/', function(req, res, next) {
    // TODO
    //res.render('todo', {text: 'Your TODO list on the Web'});
});

router.get('/login', function(req, res, next) {
    // TODO

});

router.get('/register', function(req, res, next) {
    // TODO

});

router.get('/logout', function(req, res, next) {
    // TODO
});

router.post('/login', function(req, res, next) {
    // TODO

});

router.post('/register', function(req, res, next) {
    var user = new User(req.body.name, req.body.password, req.body.email);
    if (!userRegistry.lookup(user)) {
        userRegistry.register(user);
        res.redirect("/todo");
    } else {
        res.render('error', {
            title: 'User exists',
            msg: "This user exists"
        });
    }
});

module.exports = router;
