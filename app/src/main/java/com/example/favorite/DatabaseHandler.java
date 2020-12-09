package com.example.favorite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "AddtoFav";
	private static final String TABLE_NAME = "Favorite";
	private static final String KEY_ID = "id";
	private static final String KEY_JID = "jid";
	private static final String KEY_JCID = "jcid";
	private static final String KEY_JIMAGE = "jimage";
	private static final String KEY_JNAME = "jname";
	private static final String KEY_JDESC = "jdesc";
	private static final String KEY_JSALARY = "jsalary";
	private static final String KEY_JVACANCY = "jvacancy";
	private static final String KEY_JDESIGN = "jdesign";
	private static final String KEY_JSKILL = "jskill";
	private static final String KEY_JMAIL = "jmail";
	private static final String KEY_JPHONE = "jphone";
	private static final String KEY_JSITE = "jsite";
	private static final String KEY_JCOMNAME = "jcomname";
	private static final String KEY_JADDRESS = "jaddress";
	private static final String KEY_JCOUNTRY = "jcountry";
	private static final String KEY_JMAPLATI = "jmaplati";
	private static final String KEY_JMAPLONGI = "jmaplongi";
 
	public DatabaseHandler(Context context) 
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," 
				+ KEY_JID + " TEXT,"
				+ KEY_JCID + " TEXT," 
				+ KEY_JIMAGE + " TEXT,"
				+ KEY_JNAME + " TEXT,"
				+ KEY_JDESC + " TEXT,"
				+ KEY_JSALARY + " TEXT,"
				+ KEY_JVACANCY + " TEXT,"
				+ KEY_JDESIGN + " TEXT,"
				+ KEY_JSKILL + " TEXT,"
				+ KEY_JMAIL + " TEXT,"
				+ KEY_JPHONE + " TEXT,"
				+ KEY_JSITE + " TEXT,"
				+ KEY_JCOMNAME + " TEXT,"
				+ KEY_JADDRESS + " TEXT,"
 				+ KEY_JCOUNTRY + " TEXT,"
 				+ KEY_JMAPLATI + " TEXT,"
 				+ KEY_JMAPLONGI + " TEXT"
				+ ")";
		db.execSQL(CREATE_CONTACTS_TABLE);		

	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

		// Create tables again
		onCreate(db);
	}

	//Adding Record in Database

	public	void AddtoFavorite(Pojo pj)
	{
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_JID, pj.getJob_Id());
		values.put(KEY_JCID, pj.getJob_Catid());
		values.put(KEY_JIMAGE, pj.getJob_Image());
		values.put(KEY_JNAME, pj.getJob_Name());
		values.put(KEY_JDESC, pj.getJob_Desc());
		values.put(KEY_JSALARY, pj.getJob_Salary());
		values.put(KEY_JVACANCY, pj.getJob_Vacancy());
		values.put(KEY_JDESIGN, pj.getJob_Designation());
		values.put(KEY_JSKILL, pj.getJob_Skill());
		values.put(KEY_JMAIL, pj.getJob_Mail());
		values.put(KEY_JPHONE, pj.getJob_Phoneno());
		values.put(KEY_JSITE, pj.getJob_Site());
		values.put(KEY_JCOMNAME, pj.getJob_Comname());
		values.put(KEY_JADDRESS, pj.getJob_Address());
		values.put(KEY_JCOUNTRY, pj.getJob_Country());
		values.put(KEY_JMAPLATI, pj.getJob_Maplati());
		values.put(KEY_JMAPLONGI, pj.getJob_Maplongi());
 
		// Inserting Row
		db.insert(TABLE_NAME, null, values);
		db.close(); // Closing database connection

	}

	// Getting All Data
	public List<Pojo> getAllData() 
	{
		List<Pojo> dataList = new ArrayList<Pojo>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_NAME;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) 
		{
			do {
				Pojo contact = new Pojo();
				contact.setId(Integer.parseInt(cursor.getString(0)));
				contact.setJob_Id(cursor.getString(1));
				contact.setJob_Catid(cursor.getString(2));
				contact.setJob_Image(cursor.getString(3));
				contact.setJob_Name(cursor.getString(4));
				contact.setJob_Desc(cursor.getString(5));
				contact.setJob_Salary(cursor.getString(6));
				contact.setJob_Vacancy(cursor.getString(7));
				contact.setJob_Designation(cursor.getString(8));
				contact.setJob_Skill(cursor.getString(9));
				contact.setJob_Mail(cursor.getString(10));
				contact.setJob_Phoneno(cursor.getString(11));
				contact.setJob_Site(cursor.getString(12));
				contact.setJob_Comname(cursor.getString(13));
				contact.setJob_Address(cursor.getString(14));
				contact.setJob_Country(cursor.getString(15));
				contact.setJob_Maplati(cursor.getString(16));
				contact.setJob_Maplongi(cursor.getString(17));
				 
 				// Adding contact to list
				dataList.add(contact);
			} while (cursor.moveToNext());
		}

		// return contact list
		return dataList;
	}

	//getting single row

	public List<Pojo> getFavRow(String id) 
	{
		List<Pojo> dataList = new ArrayList<Pojo>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_NAME +" WHERE jid="+id;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) 
		{
			do {
				Pojo contact = new Pojo();
				contact.setId(Integer.parseInt(cursor.getString(0)));
				contact.setJob_Id(cursor.getString(1));
				contact.setJob_Catid(cursor.getString(2));
				contact.setJob_Image(cursor.getString(3));
				contact.setJob_Name(cursor.getString(4));
				contact.setJob_Desc(cursor.getString(5));
				contact.setJob_Salary(cursor.getString(6));
				contact.setJob_Vacancy(cursor.getString(7));
				contact.setJob_Designation(cursor.getString(8));
				contact.setJob_Skill(cursor.getString(9));
				contact.setJob_Mail(cursor.getString(10));
				contact.setJob_Phoneno(cursor.getString(11));
				contact.setJob_Site(cursor.getString(12));
				contact.setJob_Comname(cursor.getString(13));
				contact.setJob_Address(cursor.getString(14));
				contact.setJob_Country(cursor.getString(15));
				contact.setJob_Maplati(cursor.getString(16));
				contact.setJob_Maplongi(cursor.getString(17));
				
				// Adding contact to list
				dataList.add(contact);
			} while (cursor.moveToNext());
		}

		// return contact list
		return dataList;
	}

	//for remove favorite

	public void RemoveFav(Pojo contact)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NAME, KEY_JID + " = ?",
				new String[] { String.valueOf(contact.getJob_Id()) });
		db.close();
	}

	public enum DatabaseManager {
		INSTANCE;
		private SQLiteDatabase db;
		private boolean isDbClosed =true;
		DatabaseHandler dbHelper;
		public void init(Context context) {
			dbHelper = new DatabaseHandler(context);
			if(isDbClosed){
				isDbClosed =false;
				this.db = dbHelper.getWritableDatabase();
			}

		}


		public boolean isDatabaseClosed(){
			return isDbClosed;
		}

		public void closeDatabase(){
			if(!isDbClosed && db != null){
				isDbClosed =true;
				db.close();
				dbHelper.close();
			}
		}
	}
}
