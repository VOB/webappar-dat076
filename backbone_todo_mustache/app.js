/*
    Application entry, config and build model, create view.

    *** NOTHING TO DO HERE
*/

/*global require*/
'use strict';

var allowCrossDomain = function(req, res, next) {
  if(allowedHost[req.headers.origin]) {
    res.header('Access-Control-Allow-Credentials', true);
    res.header('Access-Control-Allow-Origin', req.headers.origin)
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE,OPTIONS');
    res.header('Access-Control-Allow-Headers', 'X-CSRF-Token, X-Requested-With, Accept, Accept-Version, Content-Length, Content-MD5, Content-Type, Date, X-Api-Version');
    next();
  } else {
    res.send(403, {auth: false});
  }
}

// Require.js allows us to configure shortcut alias
require.config({
    // The shim config allows us to configure dependencies for
    // scripts that do not call define() to register a module
    shim: {
        underscore: {
            exports: '_'
        },
        backbone: {
            deps: [
                'underscore', 'jquery'
            ],
            exports: 'Backbone'
        },
        backboneLocalstorage: {
            deps: ['backbone'],
            exports: 'Store'
        }
    },
    paths: {
        jquery: '../node_modules/jquery/dist/jquery',
        underscore: '../node_modules/underscore/underscore',
        backbone: '../node_modules/backbone/backbone',
        backboneLocalstorage: '../node_modules/backbone.localstorage/backbone.localStorage',
        text: '../node_modules/requirejs-text/text',
        mustache: '../node_modules/mustache/mustache'
    }
});

require([
    'backbone', 'collections/todoList', 'views/appView'

], function(Backbone, TodoList, AppView, Workspace) {
    // Create collection (of TodoNotes)
    var todoList = new TodoList();
    // Create the application view, supply collection
    new AppView(todoList);

});
