//Positive test case for scenario
//"MongoDB is used through MongoClient and URL is created using Format module and the database credentials are not hardcoded"

var express = require('express');
var mongodb = require('mongodb');
var sanitize = require('mongo-sanitize');
var format = require('util').format;
var app = express();
var bodyParser     =         require("body-parser");
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.disable('x-powered-by');

var collection;

//We need to work with "MongoClient" interface in order to connect to a mongodb server.
var MongoClient = mongodb.MongoClient;

// Connection URL. This is where your mongodb server is running.
var fileName = "./db_config.json";
var config;
try {
    config = require(fileName);
} catch (err) {
    config = {};
    console.log("unable to read file '" + fileName + "': ", err);
}

// LDAP Server
var server = "ldap.example.com";
var user = config.username;
var pass = config.password;
var url = format("mongodb://%s:%s@%s/test?authMechanism=PLAIN&maxPoolSize=1", user, pass, server);

// Use connect method to connect to the Server
MongoClient.connect(url, function (err, db) {
    if (err) {
        console.log('Unable to connect to the mongoDB server. Error:', err);
    } else {
        //HURRAY!! We are connected. :)
        console.log('Connection established');

        // Get the documents collection
        collection = db.collection('users');
        //Clean up users from previous run
        collection.remove({})
        //Create users
        var admin = {username: 'admin', firstname: 'admin', lastname: 'admin', password: 'admin', created: new Date()};
        var user = {username: 'user', firstname: 'john', lastname: 'edwards',password: 'user', created: new Date()};
        var koen = {username: 'koen', firstname: 'koen', lastname: 'buyens',password: 'koen', created: new Date()};
        var ten = {"_id":10, username: 'ten', firstname: 'eleven', lastname: 'twelve',password: 'ten', created: new Date()};

        // Insert users
        collection.insert([admin, user, koen, ten], function (err, result) {
            if (err) {
                console.log(err);
            } else {
                console.log('Inserted %d documents into the "users" collection. The documents inserted with "_id" are:', result.length, result);
            }
            //Close connection
            db.close();
        });
    }
});


var server = app.listen(3000, function () {
    console.log('listening on port %d', server.address().port);
});