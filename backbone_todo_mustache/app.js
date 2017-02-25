/*
    Application entry, config and build model, create view.

    *** NOTHING TO DO HERE
*/

/*global require*/
'use strict';

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
