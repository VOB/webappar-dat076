var Sequelize = require('sequelize');
var sequelize = require('../db/todo_db_orm.js');

// Create mapping between table and
// model for a TodoNote

var TodoNote = sequelize.define('Todo', {
  id: {
      type: Sequelize.BIGINT,
      autoIncrement: true,
      primaryKey: true
  },
  text: {
      type: Sequelize.STRING
  }
});


module.exports = TodoNote;
