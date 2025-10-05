package entities;

public class Body implements Person {

	@Override
	public char[][] getPartOfPerson(char[][] part, char tile) {
		
		for (int i = 0; i < part.length; i++) {
			for (int j = 0; j < part[i].length; j++) {
				if (i <= 6 && j == 9) {
					part[i][j] = tile;
				}

			}
		}

		return part;
	}

}
