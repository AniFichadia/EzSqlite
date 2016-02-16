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


import android.content.Context;
import android.database.SQLException;
import android.util.Log;

import java.util.Collection;

/**
 * Provides database CRUD operations for a specific table
 *
 * @param <T> The data type stored using your {@link BaseDataSource} below
 * @param <B> Your {@link BaseDataSource} type
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class DataPersister<T, B extends BaseDataSource<T>>
{
	// ============================= Attributes ==============================
	protected String TAG = DataPersister.class.getSimpleName();

	protected final Context context;
	protected final B dataSource;

	public boolean DEBUG = true;


	// ============================ Constructors =============================
	public DataPersister(Context context, B dataSource)
	{
		this.context = context;
		this.dataSource = dataSource;
	}


	// ========================== Delegate Methods ===========================
	public synchronized void open() throws SQLException
	{
		dataSource.open();
	}


	public synchronized void close()
	{
		dataSource.close();
	}


	public synchronized T insert(T value)
	{
		if (DEBUG) {
			Log.d(TAG, "Inserting item: " + value.toString());
		}

		open();
		T o = dataSource.insert(value);
		close();

		return o;
	}


	public synchronized T update(T value)
	{
		if (DEBUG) {
			Log.d(TAG, "Updating item: " + value.toString());
		}

		open();
		T d = dataSource.update(value);
		close();

		return d;
	}


	public synchronized T get(long id)
	{
		if (DEBUG) {
			Log.d(TAG, "Getting item with id: " + id);
		}

		open();
		T i = dataSource.get(id);
		close();

		if (DEBUG) {
			if (i != null) {
				Log.d(TAG, "Retrieved item: " + i.toString());
			}
		}

		return i;
	}


	public synchronized Collection<T> getAll()
	{
		if (DEBUG) {
			Log.d(TAG, "Getting all items");
		}

		open();
		Collection<T> all = dataSource.getAll();
		close();

		if (DEBUG) {
			Log.d(TAG, "... retrieved " + all.size() + " items");
		}

		return all;
	}


	public synchronized boolean delete(T value)
	{
		if (DEBUG) {
			Log.d(TAG, "Deleting item: " + value.toString());
		}

		open();
		boolean result = dataSource.delete(value);
		close();

		return result;
	}


	public synchronized boolean contains(T value)
	{
		if (DEBUG) {
			Log.d(TAG, "Checking if database contains item: " + value.toString());
		}

		open();
		boolean result = dataSource.contains(value);
		close();

		return result;
	}


	public synchronized long count()
	{
		if (DEBUG) {
			Log.d(TAG, "Getting row count");
		}

		open();
		long result = dataSource.count();
		close();

		if (DEBUG) {
			Log.d(TAG, "... count is: " + result);
		}

		return result;
	}


	// ========================== Getters & Setters ==========================
	public Context getContext()
	{
		return context;
	}


	public B getDataSource()
	{
		return dataSource;
	}
}