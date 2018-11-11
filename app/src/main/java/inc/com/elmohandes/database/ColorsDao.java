package inc.com.elmohandes.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.graphics.Color;

import java.util.List;

import inc.com.elmohandes.model.Colors;
@Dao
public interface ColorsDao {

    //getting all colors in db
    @Query("SELECT * FROM Colors")
    List<Colors> getAll();

    //deleting
    @Delete
    void deleteColor(Colors color);

    //inserting
    @Insert
    void insertColor(Colors color);
}
