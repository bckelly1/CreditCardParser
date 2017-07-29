package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
/**
 * Created by Brian on 10/1/2016.
 *
 */
class FileReader {
    Object[] readInFile(String path) throws IOException {
        File inputFile = new File(path);
        if(isValidFile(inputFile)){
            return Files.lines(inputFile.toPath()).toArray();
        }
        return null;
    }

    private static boolean isValidFile(File inputFile) throws FileNotFoundException {
        //check file permissions
        //check file existence
        //check file size
        //check file contents
        if(inputFile.exists()){
            if(inputFile.isFile()){
                return true;
            }
            else{
                System.err.println("Input file is not a file! Is it a directory?");
            }
        }
        else{
            throw new FileNotFoundException("The input file " + inputFile.getAbsolutePath() + " does not exist!!");
        }
        return false;
    }
}
