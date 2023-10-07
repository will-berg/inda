
import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer {
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer() {
        files = new ArrayList<>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename) {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles() {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    // 4.16
    public void listFile(int index) {
        if (validIndex(index) == true) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Checks valid index.
     */
    // 4.14
    public void checkIndex(int index) {
        if ( !(index >= 0 && index < files.size())) {
            System.out.println("The valid range is 0 to " + (files.size() - 1) + ".");
        }
    }

    /**
     * Checks valid index.
     */
    // 4.15
    public boolean validIndex(int index) {
        if ( !(index >= 0 && index < files.size())) {
            return false;
        }
		else return true;
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    // 4.16
    public void removeFile(int index) {
        if (validIndex(index) == true) {
            files.remove(index);
        }
    }
}


