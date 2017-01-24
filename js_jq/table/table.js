/*
   A function to create a HTML-table
   Using plain JS and standard DOM API

*/

// The function to implement
function createTable(rows, cols, data) {

  var tbl = document.createElement("TABLE");

  for (i = 0; i < rows; i++) {
    var row = tbl.insertRow(i);
    for (j = 0; j < cols; j++) {
      var cell = row.insertCell(j);
      cell.innerHTML = data[j + cols*i];
    }
  }
  return tbl;
}

$(document).ready(function() {

  // Executed at download
  var parent = document.getElementById("parent");
  var table = createTable(10, 5, data.split(" "));
  parent.appendChild(table);
});


// Dummy data
var data = "The Document Object Model (DOM) is a programming interface for" +
  "HTML, XML and SVG documents. It provides a structured representation of the" +
  " document as a tree. The DOM defines methods that allow access to the tree," +
  " so that they can change the document structure, style and content.";
