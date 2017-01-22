/*
   A function to create a HTML-table
   Using plain JS and standard DOM API

*/

// The function to implement
function createTable(rows, cols, data) {

  var tbl = $("table");

  /*for (i = 0; i < rows; i++) {
    tbl.append($("<tr>"))
    for (j = 0; j < cols; j++) {
      var cell = $("<td>" + data[i][j] + "</td>")
      tbl.append(cell);
    }
    tbl.append($("</tr"))
  }
  tbl.append($("</table>"));
  */
  return tbl;
}

$(document).ready(function() {
  document.getElementById("test").innerHTML = "HAI"
  //test.innerHTML = "This page should display a table created using pure JS/DOM API";

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
