# EzSqlite
Android library to reduce SQLite Database boilerplate code. This is a no frills implementation of code that is repeated when configuring SQLite in Android projects. 


The library provides basic CRUD operations and is suitable for flat/non-relational tables. A single integer primary key is assumed for simplicity.


To use this library, extend BaseSQLiteOpenHelper for every databse, and BaseDataSource and DataPeraister for every table required.

BaseSQLiteOpenHelper handles creating and upgrading your database.

BaseDataSource handles database operations. Just provide implementations for clearing the database, extracting ids from domain models, and conversion to and from rows.

DataPersister provides the public operations to manipulate your database.
