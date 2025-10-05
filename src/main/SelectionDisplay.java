package main;

public class SelectionDisplay {

	private  String word;
	private Game game;
	
	public SelectionDisplay(String word, Game game) {
		this.word = word;
		this.game = game;
	}
	
	public void drawDisplay() {
		
		System.out.println("Угадайте слово. У вас " +  game.getAttemptCounter()  + " попыток");
		System.out.println("Для выхода из игры введите 'exit'\n");
		
		for(int i = 0; i < word.length(); i++) {
			System.out.print("* ");
		}
			
		System.out.println();
	}

}
