# EzSqlite
Android library to reduce SQLite Database boilerplate code

This library wraps up a lot of the boilerplate code required when setting up a SQLite database for Android projects. 

It also provides basic CRUD operations and is suitable for flat/non-relational tables. The library assumes that tables use an integer primary key.


All you need to do is extend the 3 classes and implement the abstract methods.

BaseSQLiteOpenHelper handles database creation and upgrades

BaseDataSource handles database operations. You just need to provide the implementations for clearing the database, extracting the row id from your domain models, and conversion to and from the database for individual domain models.

DataPersister provides the public operations to manipulate your database.
