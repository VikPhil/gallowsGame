package entities;

public class LeftLeg implements Person{

	@Override
	public char[][] getPartOfPerson(char[][] part, char tile) {
		for (int i = 0; i < part.length; i++) {
			for (int j = 0; j < part[i].length; j++) {
				if (i == 7 && j == 8 || i == 8 && j == 7)
					part[i][j] = tile;

			}
		}

		return part;
	}

}
