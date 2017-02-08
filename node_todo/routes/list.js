/*

    The router for all /list/* pathes


    NOTE:  Order of pathes IMPORTANT
    Express will try to match top down
    If something before matches, .... then what should match NOT executed.
*/

var express = require('express');
var TodoNote = require('../models/todonote.js');
var TodoList = require('../models/todolist.js');

var todolist = new TodoList();
var router = express.Router();

// List notes for current user
router.get('/', function(req, res, next) {
    // TODO

});

router.get('/add', function(req, res, next) {
    // TODO

});

// TODO get by id

router.post('/add', function(req, res, next) {
    // TODO

});

router.get('/delete', function(req, res, next) {
    // TODO

});

router.post('/delete', function(req, res, next) {
    // TODO

});

// TODO edit by id

router.post('/edit', function(req, res, next) {
    // TODO

});

module.exports = router;
