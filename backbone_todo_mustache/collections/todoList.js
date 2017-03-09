/*

  A collection of TodoNote's

  *** NOTHING TO DO HERE

*/
// Define dependencies
define([
    'underscore', 'backbone', 'backboneLocalstorage', 'models/todoNote'
], function(_, Backbone, Store, TodoNote) { // Inject dependencies (in order)
    'use strict';
    /*
    	All CRUD methods are defined by Backbone (i.e. there are hidden functions)
    	- TodoList.add()
    	- TodoList.remove(id)
    	- TodoList.add(...)
    	- TodoList.length();
    	- etc. see Backbone docs.

    */
    // Constructor function
    var TodoList = Backbone.Collection.extend({

        // Should specify which model "class" the collection handles
        model: TodoNote,

        // Save all of the todo items under this example's namespace.
        // Using browsers localstore
        // MUST: Have this else Backbone will try to access server
        // i.e. must use and URL when saving notes
        // localStorage: new Store('todos-backbone'),

        url: 'http://localhost:3000/todo/list',
        // This is the server side id (cid created clientside automatically by Backbone)
        modelId: function(attributes) {
            return attributes.id;
        },

        // initialize: function() {
        //     // This will end up in browser local storage
        //     // Use dev tools > resources to inspect
        //     this.create(1, 'Äta gröt');
        //     this.create(2, 'Rensa sallad');
        //     this.create(3, 'Jaga älg');
        // }

    });
    // Return the constructor function (the "class"), see app.js for use
    // (not returning an object, can't inject an instance of this)
    return TodoList;
});
