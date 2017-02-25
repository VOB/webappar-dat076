/*
      The view for a single todo note
      (created and appended to <tbody id="todo-list"> by appView.js)

*/

define([
    'jquery', 'underscore', 'backbone', 'mustache', 'text!templates/todoNote.html'
    //'text!templates/todoNote.html'
], function($, _, Backbone, Mustache, todoNoteTemplate) {
    'use strict';

    var TodoNoteView = Backbone.View.extend({

        tagName: 'tr', // Will wrap template in an <tr> element
        template: Mustache.parse(todoNoteTemplate),

        // Incomming events from GUI
        events: {
            'click .delete': 'delete',
            'dblclick .edit': 'edit',
            'keypress .edit': 'update'
        },

        initialize: function(todoNote) {
            this.todoNote = todoNote;
            this.listenTo(this.todoNote, 'destroy', this.remove);
            this.listenTo(this.todoNote, 'all', this.spy);
            this.$el.on("click", this.spy);
        },

        // Will create a HTML table row
        render: function() {
            var m = Mustache.render(todoNoteTemplate, {"todoNote": this.todoNote.attributes});
            this.$el.append(m); //.html(m);

        },
        delete: function(e) {
           this.todoNote.destroy();
        },
        edit: function() {
           var input = this.$('.edit');
           input.removeAttr("disabled");
           input.focus();
        },
        update: function(e) {
            var input = this.$('.edit');
            if (e.which !== 13 || !input.val().trim()) {
                return;
            }
            var input = this.$('.edit');
            input.attr("disabled", "disabled");
            this.todoNote.set({text: input.val()});
        },
        spy: function(e) {
            console.log(JSON.stringify(e));
        }
    });

    return TodoNoteView;
});
