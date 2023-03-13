package com.example.cours_groupe2.DAO;

import android.content.Context;

public class CalculBaseHelper extends DataBaseHelper{
    public CalculBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, dataBaseName, dataBaseVersion);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS " + CalculDao.TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                CalculDao.COLUMN_PREMIER_ELEMENT + " INTEGER NOT NULL," +
                CalculDao.COLUMN_DEUXIEME_ELEMENT + " INTEGER NOT NULL," +
                CalculDao.SYMBOL + " VARCHAR(5) not null," +
                CalculDao.resultat + " INTEGER NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS "+CalculDao.TABLE_NAME;    }
}
