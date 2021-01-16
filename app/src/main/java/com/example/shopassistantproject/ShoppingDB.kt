package com.example.shopassistantproject

/*import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Shopping::class], version = 1)
abstract class ShoppingDB : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

companion object {
    private var instance: ShoppingDB? = null

    fun getDatabase(context: Context): ShoppingDB{
        if (instance != null)
            return instance as ShoppingDB
        instance = Room.databaseBuilder(
            context,
            ShoppingDB::class.java,
            "ShoppingDB"
        ).allowMainThreadQueries().build()
        return instance as ShoppingDB

    }

}

}*/