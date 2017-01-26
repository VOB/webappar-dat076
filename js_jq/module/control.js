/*

    This is the control part connecting the table module and the page

*/
// Function run when DOM is finished loading (= document.ready() )
$(function() {

    // Connecting eventhandlers to elements, jQuery style
    $("#create").on("click", control.createTable);
    $("#edit").on("click", control.editTable);
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
          table = new Table($("#rows").val(),
                            $("#cols").val(),
                            data.split(' '),
                            $("#striped").is(":checked"));

          var tbl = table.render();
          var parent = document.getElementById("parent");
          parent.innerHTML = "";
          parent.appendChild(tbl);

        }, editTable: function() {
            var r = $("#row").val();
            var c = $("#col").val();
            var v = $("#value").val();

            table.edit(r,c,v);

            var tbl = document.getElementById("tbl").firstChild;
            var row = tbl.childNodes[r];
            var cell = row.childNodes[c];
            cell.innerHTML = v;
        }}
})();
