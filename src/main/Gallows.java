package main;

import entities.RightArm;
import entities.RightLeg;
import entities.Body;
import entities.Head;
import entities.LeftArm;
import entities.LeftLeg;

public class Gallows {

	private char[][] areaGallows = new char[10][13];
	private char tile = '#';

	private void createGallows() {
		for (int i = 0; i < areaGallows.length; i++) {
			for (int j = 0; j < areaGallows[i].length; j++) {

				// vertical, horizontal
				if (i == 0 || j == 0)
					areaGallows[i][j] = tile;

				// angle
				if (i == 3 && j == 1 || i == 2 && j == 2 || i == 1 && j == 3)
					areaGallows[i][j] = tile;

				// rope
				if (j == 9 && i <= 2)
					areaGallows[i][j] = tile;
			}
		}

	}

	public void drawGallows() {

		createGallows();
		
		System.out.println();
		
		for (int i = 0; i < areaGallows.length; i++) {
			for (int j = 0; j < areaGallows[i].length; j++) {
				System.out.print(areaGallows[i][j]);
			}

			System.out.println();
		}

	}
	
	public void gallowsChanges(int counter) {
			
		switch (counter) {
		case 5:
			createHead();
			break;
		case 4:
			createBody();
			break;
		case 3:
			createLeftArm();
			break;
		case 2:
			createRightArm();
			break;
		case 1:
			createLeftLeg();
			break;
		case 0:
			createRightLeg();
			break;
		default:
			break;
		}

	}

	private void createRightLeg() {
		areaGallows = new RightLeg().getPartOfPerson(areaGallows, tile);
	}

	private void createLeftLeg() {
		areaGallows = new LeftLeg().getPartOfPerson(areaGallows, tile);
	}

	private void createRightArm() {
		areaGallows = new RightArm().getPartOfPerson(areaGallows, tile);
	}

	private void createLeftArm() {
		areaGallows = new LeftArm().getPartOfPerson(areaGallows, tile);
	}

	private void createHead() {
		areaGallows = new Head().getPartOfPerson(areaGallows, tile);
	}

	private void createBody() {
		areaGallows = new Body().getPartOfPerson(areaGallows, tile);
	}
	
}
