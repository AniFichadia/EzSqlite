/**
 * Copyright (C) 2016 Aniruddh Fichadia
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * <p/>
 * If you use or enhance the code, please let me know using the provided author information or via
 * email Ani.Fichadia@gmail.com.
 */

package com.anifichadia.ezsqlite;


import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * For now, refer to Vogella's example:
 * http://www.vogella.com/tutorials/AndroidSQLite/article.html#databasetutorial_database
 *
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public abstract class BaseSQLiteOpenHelper
		extends SQLiteOpenHelper
{
	/**
	 * Database name
	 */
	protected final String databaseName;
	/**
	 * Database version number
	 */
	protected final int    databaseVersion;

	protected final String[] allTables;

	
	// ============================ Constructors =============================
	public BaseSQLiteOpenHelper(Context context, String databaseName, CursorFactory factory,
	                            int databaseVersion, String[] allTables)
	{
		super(context, databaseName, factory, databaseVersion);
		this.databaseName = databaseName;
		this.databaseVersion = databaseVersion;
		this.allTables = allTables;
	}


	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public BaseSQLiteOpenHelper(Context context, String databaseName, CursorFactory factory,
	                            int databaseVersion, DatabaseErrorHandler errorHandler,
	                            String[] allTables)
	{
		super(context, databaseName, factory, databaseVersion, errorHandler);
		this.databaseName = databaseName;
		this.databaseVersion = databaseVersion;
		this.allTables = allTables;
	}


	// ============================== Inherited ==============================


	@Override
	public void onCreate(SQLiteDatabase db)
	{
		for (String table : allTables) {
			createSpecificTable(db, table);
		}
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		for (String table : allTables) {
			db.execSQL("DROP TABLE IF EXISTS " + table);
		}

		onCreate(db);
	}


	// =============================== Methods ===============================


	/**
	 * Truncate a specified table.
	 * <p/>
	 * Note: The truncation has been has been implemented as dropping the table and re-creating it
	 * since this is more efficient.
	 *
	 * @param db        Database to truncate the table from
	 * @param tableName Table to truncate.
	 */
	public void truncateTable(SQLiteDatabase db, String tableName)
	{
		// Drop table
		db.execSQL("DROP TABLE IF EXISTS " + tableName);
		// Re-create table
		createSpecificTable(db, tableName);
	}
	
	
	// ============================== Abstracted =============================
	/**
	 * Creates a specific table that is supported by the current database.
	 *
	 * @param db        Database to create the table in
	 * @param tableName name of the table to create
	 */
	protected abstract void createSpecificTable(SQLiteDatabase db, String tableName);
}
