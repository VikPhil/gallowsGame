package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import helpz.Word;

public class Game {

	private Gallows gallows;
	private SelectionDisplay selectionDisplay;

	private String letter, word;
	private char[] copyWord;

	private int attemptCounter;
	private boolean isSame;

	private ArrayList<Character> saveLetters = new ArrayList<>();

	public Game() throws IOException {

		newGame();
		initGame();
	}

	private void initGame() {
		
		Scanner sc = new Scanner(System.in);

		while (true) {

			isSame = false;
			
			gallows.drawGallows();

			System.out.print("Введите букву: ");

			letter = sc.nextLine().toUpperCase();

			saveLetters.add(letter.charAt(0));

			// exit game
			if (letter.equals("EXIT"))
				break;

			// checking the matching of letters in a word
			for (int i = 0; i < copyWord.length; i++) {

				if (letter.charAt(0) == word.charAt(i)) {
					copyWord[i] = letter.charAt(0);
					isSame = true;
				}

			}

			if (isTheWordFilledWithLetters(copyWord)) {
				System.out.print("ПОЗДРАВЛЯЕМ С ПОПЕДОЙ!!! ВЫ УГАДАЛИ СЛОВО - ");
				
				showWord();

				System.out.println("\nХотите продолжить? д/н");

				if (continueOrExitGame(sc))
					continue;
				else
					break;
			}

			// if not, then we reduce the counter and add changes to the handed man
			if (!isSame) {
				attemptCounter--;

				System.out.print("Неверная буква! ");

				gallows.gallowsChanges(attemptCounter);

				// lost game and repeat game
				if (attemptCounter == 0) {
					gallows.drawGallows();

					System.out.println("Вы проиграли. Хорошего дня =)");
					System.out.println("Заданное слово было: " + word);

					System.out.println("Хотите продолжить? д/н");

					if (continueOrExitGame(sc))
						continue;
					else
						break;

				}
			} else {
				System.out.print("Вы угадали! ");
			}

			System.out.println("Попыток осталось: " + attemptCounter);

			System.out.println();

			showWord();

			outputOfTheLastEnteredLetters(saveLetters);

		}
		
		sc.close();
	}

	private void showWord() {
		for (char ch : copyWord)
			System.out.print(ch + " ");
	}

	private boolean continueOrExitGame(Scanner sc) {
		if (sc.nextLine().toUpperCase().equals("Д")) {
			try {
				newGame();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		} else {
			System.out.println("До встречи! Приятно было с Вами поиграть.");
			return false;
		}
	}

	private boolean isTheWordFilledWithLetters(char[] thisWord) {

		int letter = 0;

		for (char ch : thisWord) {
			if (ch != '*')
				letter++;
		}

		return letter == thisWord.length;
	}

	private void newGame() throws IOException {

		attemptCounter = 6;
		word = Word.getRandomWord().toUpperCase();
		
		selectionDisplay = new SelectionDisplay(word, this);
		gallows = new Gallows();

		selectionDisplay.drawDisplay();

		copyWord = new char[word.toCharArray().length];

		for (int k = 0; k < copyWord.length; k++)
			copyWord[k] = '*';

		saveLetters.clear();
	}

	private void outputOfTheLastEnteredLetters(ArrayList<Character> saveLetters) {

		System.out.print("\nПоследние введенные буквы: ");
		for (Character ch : saveLetters)
			System.out.print(ch + ", ");

		System.out.println();
	}

	public int getAttemptCounter() {
		return attemptCounter;
	}
}
