package helpz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Word {

	private static final String file = "../GallowsGame/res/Words.txt";

	private static BufferedReader reader;
	private static Random rand = new Random();

	public static String getRandomWord() throws IOException {

		reader = new BufferedReader(new FileReader(file));
		String result = null;

		int counter = rand.nextInt(51301) + 1;

		while (counter > 1) {
			counter--;
			reader.readLine();
		}

		result = reader.readLine();
		reader.close();

		return result;
	}

}
