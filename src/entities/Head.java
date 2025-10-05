package entities;

public class Head implements Person {

	@Override
	public char[][] getPartOfPerson(char[][] part, char tile) {

		for (int i = 0; i < part.length; i++) {
			for (int j = 0; j < part[i].length; j++) {
				if (i == 2 || i == 3) {
					if (j >= 8 && j <= 10)
						part[i][j] = tile;
				}

			}
		}
		return part;
	}

}
