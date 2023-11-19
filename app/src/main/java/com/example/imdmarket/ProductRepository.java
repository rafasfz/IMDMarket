package com.example.imdmarket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
public class ProductRepository extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "imdmarket_db";
    private static final String TABLE_NAME = "products";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_STOCK = "stock";

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_NAME + " TEXT NOT NULL, " +
            COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
            COLUMN_STOCK + " INTEGER NOT NULL" + ")";

    public ProductRepository(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    public void insertProduct(ProductEntity product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, product.id);
        values.put(COLUMN_NAME, product.name);
        values.put(COLUMN_DESCRIPTION, product.description);
        values.put(COLUMN_STOCK, product.stock);

        long id = db.insert(TABLE_NAME, null, values);
        db.close();

        Log.d("ProductRepository", "Product inserted successfully with id: " + id);
    }

    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> products = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION));
                int stock = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_STOCK));

                ProductEntity product = new ProductEntity(id, name, description, stock);
                products.add(product);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return products;
    }

    public ProductEntity getProductById(int id) {
        ProductEntity product = null;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);

        if (cursor.moveToFirst()) {
            int productId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION));
            int stock = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_STOCK));

            product = new ProductEntity(productId, name, description, stock);
        }

        cursor.close();
        db.close();

        return product;
    }

    public void deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        int rowsDeleted = db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();

        if (rowsDeleted > 0) {
            Log.d("ProductRepository", "Product deleted successfully");
        } else {
            Log.d("ProductRepository", "Product not deleted");
        }
    }


    public void updateProduct(ProductEntity product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, product.name);
        values.put(COLUMN_DESCRIPTION, product.description);
        values.put(COLUMN_STOCK, product.stock);

        int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(product.id)});
        db.close();

        if (rowsUpdated > 0) {
            Log.d("ProductRepository", "Product updated successfully");
        } else {
            Log.d("ProductRepository", "Product not updated");
        }
    }

}
