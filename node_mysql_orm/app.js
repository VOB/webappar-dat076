/*

	Application entry (= main)

  *** NOTHIN TO DO HERE ***
*/

var express = require('express');
var path = require('path');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var methodOverride = require('method-override')
var mustacheExpress = require('mustache-express');

var index = require('./routes/index');
var todo = require('./routes/todo');

var app = express();

app.use(cookieParser());

// Used for static resources (must have first arg, to make path absolute)
app.use('/public', express.static(path.join(__dirname, '/public')));

// View engine setup
app.set('views', path.join(__dirname, 'views'));
app.engine('html', mustacheExpress()) // Same as file extensions (*.html)
app.set('view engine', 'html');

// Uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));

app.listen(3000, function() {
    console.log("Listening at port 3000");
});

// The routes and routers
app.use('/', index);
app.use('/todo', todo);

// Catch 404 and forward to error handler
app.use(function(err, req, res, next) {
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
})

// Exception handling
if (app.get('env') === 'development') {
    console.log("In development mode");
    app.use(function(err, req, res, next) {
        console.log("Error:" + err.stack);
        res.status(err.status || 500);
        res.render('error', {
            message: err.message,
            error: err
        });
    });
} else {
    app.use(function(err, req, res, next) {
        res.status(err.status || 500);
        res.render('error', {
            message: err.message,
            error: {}
        });
    });
}

module.exports = app;
