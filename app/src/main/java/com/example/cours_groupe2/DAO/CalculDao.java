package com.example.cours_groupe2.DAO;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.cours_groupe2.model.entities.Calcul;

public class CalculDao extends BaseDao<Calcul> {
    public CalculDao(DataBaseHelper helper) {
        super(helper);
    }

    public static String TABLE_NAME = "Calculs";
    public static String COLUMN_PREMIER_ELEMENT = "Premier_Element";
    public static String COLUMN_DEUXIEME_ELEMENT = "Deuxieme_element";
    public static String SYMBOL = "Symbole";
    public static String resultat= "Resultat";
    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected void putValues(ContentValues values, Calcul entity) {
        values.put(COLUMN_PREMIER_ELEMENT,entity.getPremierElement());
        values.put(COLUMN_DEUXIEME_ELEMENT,entity.getDeuxiemeElement());
        values.put(SYMBOL,entity.getSymbole());
        values.put(resultat,entity.getResultat());
    }

    @Override
    protected Calcul getEntity(Cursor cursor) {
        Integer indexPremierElement = cursor.getColumnIndex(COLUMN_PREMIER_ELEMENT);
        Integer indexDeuxiemeElement = cursor.getColumnIndex(COLUMN_DEUXIEME_ELEMENT);
        Integer indexSymbole = cursor.getColumnIndex(SYMBOL);
        Integer indexResultat = cursor.getColumnIndex(resultat);
        Calcul monCalcul = new Calcul();
        monCalcul.setPremierElement(cursor.getInt(indexPremierElement));
        monCalcul.setDeuxiemeElement(cursor.getInt(indexDeuxiemeElement));
        monCalcul.setSymbole(cursor.getString(indexSymbole));
        monCalcul.setResultat(cursor.getInt(indexResultat));
        return monCalcul;
    }
}
