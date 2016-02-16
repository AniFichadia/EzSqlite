# EzSqlite
Android library to reduce SQLite Database boilerplate code. This is a no frills, zero reflection and code generation implementation of code that is typically repeated when configuring SQLite in Android projects. 


The library provides basic CRUD operations and is suitable for flat/non-relational tables. A single integer primary key is assumed for simplicity.


To use this library, extend BaseSQLiteOpenHelper for every database, and BaseDataSource and DataPersister for every table required.

BaseSQLiteOpenHelper handles creating and upgrading your database.

BaseDataSource handles database operations. Just provide implementations for clearing the database, extracting ids from domain models, and conversion to and from rows.

DataPersister provides the public operations to manipulate your database as well as opening and closing connections to the database.

Todo:
Logging
Table builder
