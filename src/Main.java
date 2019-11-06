import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        //initializing file to read
        FileReader fileToRead = new FileReader("source.txt");
        Scanner text = new Scanner(fileToRead);

        int counter = 1;
        ArrayList<StringBuffer> lines = new ArrayList<>();
        // calculating and writing lines into storage
        while (text.hasNextLine()) {
            StringBuffer lineToWrite = new StringBuffer();
            lineToWrite.append(text.nextLine()).reverse();
            lines.add(lineToWrite);
            counter++;
        }
        fileToRead.close();

        ArrayList<Integer> sequence = fib_sequence(counter);
        //initializing file to write
        FileWriter fileToWrite = new FileWriter("output.txt");
        //writing in file only required strings
        for (int i = 0; i < lines.size(); i++) {
            if (sequence.get(i) <= counter) {
                fileToWrite.write((lines.get(sequence.get(i) - 1)).toString() + "\n");
            } else {
                fileToWrite.close();
                return;
            }
        }
    }

    // fibonacci sequence in ArrayList
    public static ArrayList<Integer> fib_sequence(int countOfStrings) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0, 1);
        array.add(1, 2);
        for (int i = 2; i < countOfStrings - 2; i++) {
            array.add(i, array.get(i - 1) + array.get(i - 2));
        }
        return array;
    }
}
