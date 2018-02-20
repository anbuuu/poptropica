package com.application.domainchallenge.data.cache;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Helper class to do operations on regular files / directories
 */

@Singleton
public class FileManager {


    @Inject
    FileManager() {}
    /**
     * Writes File to Disk
     * This is I/O Operation and this method executes in main thread, so it is recommended to
     * perform this operation using another thread
     *
     * @param file The file to write to Disk
     */
    void writeToFile(File file, String fileContent) {
        if (!file.exists()) {
            try {
                final FileWriter writer = new FileWriter(file);
                writer.write(fileContent);
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    /**
     * Reads a content from a file
     * This is an I/O Opeation and this method executes in the main thread, so it is recommended
     * to perform the operation using another thread
     *
     * @param file - The file to read from
     * @return A String with the content of the file
     * TODO Think about handling with Retrofit rather than this
     */
    String readFileContent(File file) {
        final StringBuilder fileContentBuilder = new StringBuilder();
        if (file.exists()) {

            String line;
            try {
                final FileReader fileReader = new FileReader(file);
                final BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ( (line = bufferedReader.readLine()) != null){
                    fileContentBuilder.append(line).append("\n");
                }


            } catch ( IOException ex) {
                ex.printStackTrace();
            }
        }
        return fileContentBuilder.toString();
    }

    /**
     * Returns a boolean indicating whether this file can be found on the underlying file system.
     *
     * @param file The file to check existence.
     * @return true if this file exists, false otherwise.
     */
    boolean exists(File file) {
        return file.exists();
    }

    /**
     * Warning: Deletes the content of a directory.
     * This is an I/O operation and this method executes in the main thread, so it is recommended to
     * perform the operation using another thread.
     *
     * @param directory The directory which its content will be deleted.
     */
    boolean clearDirectory(File directory) {
        boolean result = false;
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                result = file.delete();
            }
        }
        return result;
    }

    /**
     * Write a value to a user preferences file.
     *
     * @param context {@link android.content.Context} to retrieve android user preferences.
     * @param preferenceFileName A file name reprensenting where data will be written to.
     * @param key A string for the key that will be used to retrieve the value in the future.
     * @param value A long representing the value to be inserted.
     */
    void writeToPreferences(Context context, String preferenceFileName, String key,
                            long value) {

        final SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName,
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * Get a value from a user preferences file.
     *
     * @param context {@link android.content.Context} to retrieve android user preferences.
     * @param preferenceFileName A file name representing where data will be get from.
     * @param key A key that will be used to retrieve the value from the preference file.
     * @return A long representing the value retrieved from the preferences file.
     */
    long getFromPreferences(Context context, String preferenceFileName, String key) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName,
                Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, 0);
    }

}
