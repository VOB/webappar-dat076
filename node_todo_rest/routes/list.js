var express = require('express');
var TodoNote = require('../models/todonote.js');
var TodoList = require('../models/todolist.js');

var todolist = new TodoList();
var router = express.Router();

router.get('/', function(req, res, next) {
  console.log("GET: getNotes" + JSON.stringify(todolist.getNotes()));
  res.json(todolist.getNotes());
});

router.get('/count', function(req, res, next) {
  console.log("GET count " + todolist.size());
  res.json({count: todolist.size()});
});

router.get('/:id', function(req, res, next) {
  var id = parseInt(req.params.id);
  console.log("GET: id " + id);
  var result = todolist.getById(id);
  //If there isn't a note corresponding to the id, send a 404 respond
  if(!result) {
    res.status(404).send("Not found");
  } else {
    res.json(result);
  }
});

router.post('/', function(req, res, next) {
  console.log("POST: " + req.body.text);
  var note = new TodoNote(req.query.id, req.body.text, new Date(), false);
  todolist.create(note);
  res.status(201).json(note);
});

router.put('/:id', function(req, res, next) {
  console.log("PUT " + req.params.id + " : " + req.body.text);
  var id = parseInt(req.params.id);
  var result = todolist.getById(id);
  console.log("To be updated " + JSON.stringify(result));
  if(!result) {
    //No note with this corresponding id
    res.status(404).send("Not Found");
  } else {
    //Create new note with updated text
    var note = new TodoNote(result.id, req.body.text, result.dateTime, req.body.done);
    todolist.update(note);
    //Send OK status
    res.sendStatus(200);
  }
});

router.delete('/:id', function(req, res, next) {
  console.log("DELETE " + req.params.id);
  var id = parseInt(req.params.id);
  todolist.delete(id);
  res.sendStatus(200);
});

module.exports = router;
