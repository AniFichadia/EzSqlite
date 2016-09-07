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

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aniruddh Fichadia | Email: Ani.Fichadia@gmail.com | GitHub Username: AniFichadia
 *         (http://github.com/AniFichadia)
 */
public class DatabaseUpgrader {
    public static final UpgradeStep NO_UPGRADE = new UpgradeStep() {
        @Override
        public void upgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Do nothing
        }
    };


    private List<UpgradeStep> upgradeSteps;


    public DatabaseUpgrader() {
        super();
    }

    public DatabaseUpgrader(@NonNull List<UpgradeStep> upgradeSteps) {
        super();

        setUpgradeSteps(upgradeSteps);
    }


    /**
     * Upgrades a database using the provided {@link UpgradeStep}s
     *
     * @param db
     *         Your SQLite database
     * @param oldVersion
     *         old database version
     * @param newVersion
     *         new database version
     *
     * @throws NullPointerException
     *         if {@link #upgradeSteps} is null
     */
    public final void upgrade(SQLiteDatabase db, int oldVersion, int newVersion) throws NullPointerException {
        if (upgradeSteps == null) {
            throw new NullPointerException("Upgrade steps cannot be null");
        }

        for (int upgrade = oldVersion - 1; upgrade < newVersion - 1; upgrade++) {
            int upgradeOldVersion = oldVersion + upgrade;
            int upgradeNewVersion = upgradeOldVersion + 1;

            upgradeSteps.get(upgrade).upgrade(db, upgradeOldVersion, upgradeNewVersion);
        }
    }

    public void setUpgradeSteps(@NonNull List<UpgradeStep> upgradeSteps) {
        this.upgradeSteps = new ArrayList<>(upgradeSteps);
    }


    public interface UpgradeStep {
        void upgrade(SQLiteDatabase db, int oldVersion, int newVersion);
    }
}