/*

	A single model object

  *** NOTHING TO DO HERE
*/
// Define dependencies// Define dependencies
define([
    'underscore', 'backbone'
], function(_, Backbone) { // Do injection
    'use strict';

    // (Private) Object for generating serial numbers
    // var counter = {
    //     value: 100,
    //     getNext: function() {
    //         var i = this.value;
    //         this.value++;
    //         return i;
    //     }
    // }
    // /*
        //   Many functions defined by Backbone (i.e. there are hidden functions)
        //   - TodoNote.destroy()
        //   - TodoList.set( ...)
        //   - etc. see Backbone docs.
        // */
    // Constructor function
    var TodoNote = Backbone.Model.extend({
        // defaults: {
        //     text: "empty",
        //     done: false
        // },
        urlRoot: 'http://localhost:3000/todo/list',

        idAttribute: "id"
        // initialize: function(id, text) {
        //     // Will set attributes, see model.attributes
        //     this.set("id", (!id)
        //         ? counter.getNext()
        //         : id);
        //     this.set("text", text);
        //     this.set("dateTime", new Date()); // Must have
        // },
        //url: function() {}

    });
    // Return the constructor function (the "class")
    return TodoNote;

})
