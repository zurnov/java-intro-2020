import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class FileReader {
    public ArrayList<Integer> ReadFromFile(String fileName){
        ArrayList<Integer> values = new ArrayList<>();
        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                values.add(getValues(data));
            }
            scanner.close();
        }
        catch (FileNotFoundException e){}
        return values;
    }
    private  int getValues(String line){
        String[] data = line.split("=");
        return Integer.parseInt( data[1]);
    }

}

