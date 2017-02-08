var express = require('express');
var TodoNote = require('../models/todonote.js');

var router = express.Router();

// List notes for current user
router.get('/', function(req, res, next) {
    // TODO
});

router.post('/add', function(req, res, next) {
    // TODO
});

router.get('/add', function(req, res, next) {
    // TODO
});

router.get('/delete', function(req, res, next) {
    // TODO
});

router.post('/delete', function(req, res, next) {
    // TODO
});

module.exports = router;
