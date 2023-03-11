package ro.ase.acs.exception;

import org.sqlite.SQLiteErrorCode;
import org.sqlite.SQLiteException;

public class SQLException extends SQLiteException {
    public SQLException(String message, SQLiteErrorCode resultCode) {
        super(message, resultCode);
    }
}
