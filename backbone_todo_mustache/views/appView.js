/*
    The view for index.html

    Adding notes belong to this (and index.html)
*/
define([
    'jquery', 'underscore', 'backbone', 'views/todoNoteView'
], function($, _, Backbone, TodoNoteView) {
    'use strict';

    var AppView = Backbone.View.extend({

        //el: "#todoapp", // <section id="todoapp">
        el: "#todoapp",

        template: null, // No template used for this (everything in index.html)
        //template: Mustache.parse(appView),

        // Incomming from view
        events: {
           'keypress #newNote': 'createOnEnter'
        },

        //todoList: new TodoList(), //if injecting constructor

        initialize: function(todoList) {
            this.todoList = todoList;

            this.$newNote = this.$('#newNote');
            this.$tbody = this.$('#todoNoteTable tbody');

            this.listenTo(this.todoList, 'add', this.renderNote);
            this.listenTo(this.todoList, 'all', this.spy);

            this.render(); // This is just to get the hard coded notes
        },

        render: function() {
             var self = this;
             this.todoList.each(function(todoNote) {
               self.renderNote(todoNote);
             });
        },

        renderNote: function(todoNote) {
             var view = new TodoNoteView(todoNote);
             view.render();
             this.$tbody.append(view.el);
        },

        // From view to model
        // NOTE: Using loca l storage
        createOnEnter: function(e) {
            // 13 = Enter
            if (e.which !== 13 || !this.$newNote.val().trim()) {
                return;
            }
            var text = this.$newNote.val().trim();
            this.todoList.create(null, text);
            this.$newNote.val('');
        },
        // Utility
        spy: function(e) {
            console.log("appView spy " + e);
        }
    });

    return AppView;
});
