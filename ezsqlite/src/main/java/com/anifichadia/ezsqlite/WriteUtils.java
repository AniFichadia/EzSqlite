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


import android.content.ContentValues;

/**
 * Provides utility methods to write to an Android SQLite database using {@link ContentValues}
 *
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class WriteUtils
{
	public static void writeString(ContentValues values, String columnName, String value)
	{
		values.put(columnName, value);
	}


	public static void writeLong(ContentValues values, String columnName, long value)
	{
		values.put(columnName, value);
	}


	public static void writeInt(ContentValues values, String columnName, int value)
	{
		values.put(columnName, value);
	}


	public static void writeShort(ContentValues values, String columnName, short value)
	{
		values.put(columnName, value);
	}


	public static void writeBlob(ContentValues values, String columnName, byte[] value)
	{
		values.put(columnName, value);
	}


	public static void writeDouble(ContentValues values, String columnName, double value)
	{
		values.put(columnName, value);
	}


	public static void writeFloat(ContentValues values, String columnName, float value)
	{
		values.put(columnName, value);
	}


	public static void writeBoolean(ContentValues values, String columnName, boolean value)
	{
		values.put(columnName, value ? 1 : 0);
	}
}