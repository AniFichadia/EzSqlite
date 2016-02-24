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


import android.database.Cursor;
import android.support.annotation.NonNull;

/**
 * Provides utility methods to read from an Android SQLite database using {@link Cursor}
 *
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class ReadUtils
{
	private final Cursor cursor;


	public ReadUtils(@NonNull Cursor cursor)
	{
		this.cursor = cursor;
	}


	public String getString(String columnName)
	{
		return cursor.getString(cursor.getColumnIndex(columnName));
	}


	public long getLong(String columnName)
	{
		return cursor.getLong(cursor.getColumnIndex(columnName));
	}


	public int getInt(String columnName)
	{
		return cursor.getInt(cursor.getColumnIndex(columnName));
	}


	public short getShort(String columnName)
	{
		return cursor.getShort(cursor.getColumnIndex(columnName));
	}


	public byte[] getBlob(String columnName)
	{
		return cursor.getBlob(cursor.getColumnIndex(columnName));
	}


	public double getDouble(String columnName)
	{
		return cursor.getDouble(cursor.getColumnIndex(columnName));
	}


	public float getFloat(String columnName)
	{
		return cursor.getFloat(cursor.getColumnIndex(columnName));
	}


	public boolean getBoolean(String columnName)
	{
		return cursor.getInt(cursor.getColumnIndex(columnName)) != 0;
	}

	
	public static String getString(Cursor cursor, String columnName)
	{
		return cursor.getString(cursor.getColumnIndex(columnName));
	}


	public static long getLong(Cursor cursor, String columnName)
	{
		return cursor.getLong(cursor.getColumnIndex(columnName));
	}


	public static int getInt(Cursor cursor, String columnName)
	{
		return cursor.getInt(cursor.getColumnIndex(columnName));
	}


	public static short getShort(Cursor cursor, String columnName)
	{
		return cursor.getShort(cursor.getColumnIndex(columnName));
	}


	public static byte[] getBlob(Cursor cursor, String columnName)
	{
		return cursor.getBlob(cursor.getColumnIndex(columnName));
	}


	public static double getDouble(Cursor cursor, String columnName)
	{
		return cursor.getDouble(cursor.getColumnIndex(columnName));
	}


	public static float getFloat(Cursor cursor, String columnName)
	{
		return cursor.getFloat(cursor.getColumnIndex(columnName));
	}


	public static boolean getBoolean(Cursor cursor, String columnName)
	{
		return cursor.getInt(cursor.getColumnIndex(columnName)) != 0;
	}
}
