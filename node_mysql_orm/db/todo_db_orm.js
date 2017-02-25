/*

    Using Sequelize as out ORM framework
*/

'use strict';

var Sequelize = require('sequelize');

// Sequelize('database', 'username', 'password', {
var sq = new Sequelize('todo', 'root', 'admin', {
    host: 'localhost',
    dialect: 'mysql', //|'sqlite'|'postgres'|'mssql',
    pool: {
        max: 5,
        min: 0,
        idle: 10000
    }

    // SQLite only
    //storage: 'path/to/database.sqlite'
});

sq.sync();

module.exports = sq;
