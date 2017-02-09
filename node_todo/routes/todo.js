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
    res.render('todo', {text: 'Your TODO list on the Web'});
});

router.get('/login', function(req, res, next) {
    res.render('login', {});
});

router.get('/register', function(req, res, next) {
    res.render('register', {});
});

router.get('/logout', function(req, res, next) {
    console.log('logout')
    req.session.destroy();
    res.render('todo', {text: 'logged out'});
});

router.post('/login', function(req, res, next) {
    console.log('login')
    var u = User.lookup(req.body)
    if (u && u.password === req.body.password) {
      req.session.user = u.name;
      delete req.session.loginMessage;
      res.redirect("/todo")
    } else {
      req.session.loginMessage = "login failed"
      res.redirect("/list")
    }
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
