/*

    This is the control part connecting the table module and the page

*/
// Function run when DOM is finished loading (= document.ready() )
$(function() {

    // Connecting eventhandlers to elements, jQuery style

    // TODO

});

// Dummy data
var data = "The Document Object Model (DOM) is a programming interface for" +
"HTML, XML and SVG documents. It provides a structured representation of the" + " document as a tree. The DOM defines methods that allow access to the tree," + " so that they can change the document structure, style and content.";

// Singleton control object, using immediate invoke pattern
// Control interaction between DOM and table module.
// Only use jQuery DOM API
var control = (function() {

    table : null;

    return {createTable: function() {
          var tbl = document.createElement("TABLE");

          for (i = 0; i < rows; i++) {
            var row = tbl.insertRow(i);
            for (j = 0; j < cols; j++) {
              var cell = row.insertCell(j);
              cell.innerHTML = data[j + cols*i];
            }
          }

          return tbl;
        }, editTable: function() {
            // TODO
        }}
})();
