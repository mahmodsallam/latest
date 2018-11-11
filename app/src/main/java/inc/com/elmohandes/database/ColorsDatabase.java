package inc.com.elmohandes.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import inc.com.elmohandes.constants.Constants;
import inc.com.elmohandes.model.Colors;

@Database(entities = {Colors.class}, version = 1)
public abstract class ColorsDatabase extends RoomDatabase {

    public abstract ColorsDao colorsDao();
    private static ColorsDatabase colorsDatabase;

    //implementing single tone
    public static ColorsDatabase getInstance(Context context) {
        if (null == colorsDatabase) {
            colorsDatabase = buildDatabaseInstance(context);
        }
        return colorsDatabase;
    }

    private static ColorsDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context, ColorsDatabase.class, Constants.DATABASE_NAME).allowMainThreadQueries().build();
    }

    public void cleanUp() {
        colorsDatabase = null;
    }
}
