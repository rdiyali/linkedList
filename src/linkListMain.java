import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class linkListMain {
	public static void main(String[] args) {

		if (args.length != 2) {
            System.out.println("Usage: java LinkedList.linkListMain.java <inputFile> <outputFile>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        LinkedList<linkListFreq> linklist = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {

                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    characterFreqUpdate(linklist, c);
                }

                characterFreqUpdate(linklist, '\n');
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            for (linkListFreq charFreq : linklist) {
                writer.write(charFreq.getCharacter() + "(" + (int) charFreq.getCharacter() + ")\t" + charFreq.getFrequency() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void characterFreqUpdate(LinkedList<linkListFreq> list, char c) {

        boolean found = false;

        for (linkListFreq charFreq : list) {

            if (charFreq.getCharacter() == c) {
                charFreq.increment();
                found = true;
                break;
            }
        }

        if (!found) {
        	linkListFreq newCf = new linkListFreq(c);
            newCf.increment();
            list.add(newCf);
        }
    }
}

