package entities;

public class RightArm implements Person{

	@Override
	public char[][] getPartOfPerson(char[][] part, char tile) {
		for (int i = 0; i < part.length; i++) {
			for (int j = 0; j < part[i].length; j++) {
				if (i == 4 && j == 11 || i == 5 && j == 12)
					part[i][j] = tile;

			}
		}

		return part;
	}

}
