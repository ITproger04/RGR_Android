package com.example.mymovies.data;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class MovieDatabase_Impl extends MovieDatabase {
  private volatile MovieDao _movieDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `movies` (`id` INTEGER NOT NULL, `voteCount` INTEGER NOT NULL, `title` TEXT, `originalTitle` TEXT, `overview` TEXT, `posterPath` TEXT, `bigPosterPath` TEXT, `backdropPath` TEXT, `voteAverage` REAL NOT NULL, `releaseDate` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `favourite_movies` (`id` INTEGER NOT NULL, `voteCount` INTEGER NOT NULL, `title` TEXT, `originalTitle` TEXT, `overview` TEXT, `posterPath` TEXT, `bigPosterPath` TEXT, `backdropPath` TEXT, `voteAverage` REAL NOT NULL, `releaseDate` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"2dcc723ff34af0b1d6de767a1a316a42\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `movies`");
        _db.execSQL("DROP TABLE IF EXISTS `favourite_movies`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMovies = new HashMap<String, TableInfo.Column>(10);
        _columnsMovies.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsMovies.put("voteCount", new TableInfo.Column("voteCount", "INTEGER", true, 0));
        _columnsMovies.put("title", new TableInfo.Column("title", "TEXT", false, 0));
        _columnsMovies.put("originalTitle", new TableInfo.Column("originalTitle", "TEXT", false, 0));
        _columnsMovies.put("overview", new TableInfo.Column("overview", "TEXT", false, 0));
        _columnsMovies.put("posterPath", new TableInfo.Column("posterPath", "TEXT", false, 0));
        _columnsMovies.put("bigPosterPath", new TableInfo.Column("bigPosterPath", "TEXT", false, 0));
        _columnsMovies.put("backdropPath", new TableInfo.Column("backdropPath", "TEXT", false, 0));
        _columnsMovies.put("voteAverage", new TableInfo.Column("voteAverage", "REAL", true, 0));
        _columnsMovies.put("releaseDate", new TableInfo.Column("releaseDate", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMovies = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMovies = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMovies = new TableInfo("movies", _columnsMovies, _foreignKeysMovies, _indicesMovies);
        final TableInfo _existingMovies = TableInfo.read(_db, "movies");
        if (! _infoMovies.equals(_existingMovies)) {
          throw new IllegalStateException("Migration didn't properly handle movies(com.example.mymovies.data.Movie).\n"
                  + " Expected:\n" + _infoMovies + "\n"
                  + " Found:\n" + _existingMovies);
        }
        final HashMap<String, TableInfo.Column> _columnsFavouriteMovies = new HashMap<String, TableInfo.Column>(10);
        _columnsFavouriteMovies.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsFavouriteMovies.put("voteCount", new TableInfo.Column("voteCount", "INTEGER", true, 0));
        _columnsFavouriteMovies.put("title", new TableInfo.Column("title", "TEXT", false, 0));
        _columnsFavouriteMovies.put("originalTitle", new TableInfo.Column("originalTitle", "TEXT", false, 0));
        _columnsFavouriteMovies.put("overview", new TableInfo.Column("overview", "TEXT", false, 0));
        _columnsFavouriteMovies.put("posterPath", new TableInfo.Column("posterPath", "TEXT", false, 0));
        _columnsFavouriteMovies.put("bigPosterPath", new TableInfo.Column("bigPosterPath", "TEXT", false, 0));
        _columnsFavouriteMovies.put("backdropPath", new TableInfo.Column("backdropPath", "TEXT", false, 0));
        _columnsFavouriteMovies.put("voteAverage", new TableInfo.Column("voteAverage", "REAL", true, 0));
        _columnsFavouriteMovies.put("releaseDate", new TableInfo.Column("releaseDate", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFavouriteMovies = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFavouriteMovies = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavouriteMovies = new TableInfo("favourite_movies", _columnsFavouriteMovies, _foreignKeysFavouriteMovies, _indicesFavouriteMovies);
        final TableInfo _existingFavouriteMovies = TableInfo.read(_db, "favourite_movies");
        if (! _infoFavouriteMovies.equals(_existingFavouriteMovies)) {
          throw new IllegalStateException("Migration didn't properly handle favourite_movies(com.example.mymovies.data.FavouriteMovie).\n"
                  + " Expected:\n" + _infoFavouriteMovies + "\n"
                  + " Found:\n" + _existingFavouriteMovies);
        }
      }
    }, "2dcc723ff34af0b1d6de767a1a316a42", "290eea1da785ced6dd806ab6a76e9184");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "movies","favourite_movies");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `movies`");
      _db.execSQL("DELETE FROM `favourite_movies`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public MovieDao movieDao() {
    if (_movieDao != null) {
      return _movieDao;
    } else {
      synchronized(this) {
        if(_movieDao == null) {
          _movieDao = new MovieDao_Impl(this);
        }
        return _movieDao;
      }
    }
  }
}
