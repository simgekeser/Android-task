package com.example.simge.conn;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c=null;


    public DatabaseAccess(Context context){
        this.openHelper=new DatabaseOpenHelper(context);
    }


    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db=openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }
/*    public ArrayList<HashMap<String,String>> GetUsers(String name){

        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        c=db.rawQuery("select yemekad,yemektarifi from Yemektarifleri where kategori = '"+name+"'", new String[]{});
        while(c.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("yemekad",c.getString(c.getColumnIndex("yemekad")));
            user.put("yemektarifi",c.getString(c.getColumnIndex("yemektarifi")));
            userList.add(user);


        }return userList;
    }
*/



   public ArrayList<String> getYemekadı(String name){
        c=db.rawQuery("select yemekad from Yemektarifleri where kategori = '"+name+"'", new String[]{});
        ArrayList<String> tarif = new ArrayList<>();

        while(c.moveToNext()){
            String yemekName = c.getString(0);
            tarif.add(yemekName);

        }
        return tarif;
    }
    public ArrayList<String> getTumYemekadı(){
        c=db.rawQuery("select yemekad from Yemektarifleri", new String[]{});
        ArrayList<String> tarif = new ArrayList<>();

        while(c.moveToNext()){
            String yemekName = c.getString(0);
            tarif.add(yemekName);

        }
        return tarif;
    }


}