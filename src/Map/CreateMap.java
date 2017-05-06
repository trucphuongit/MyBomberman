package Map;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateMap {
	
	public static String[][] createMap() {
		String[][] map = new String[15][15];
		
		// Khởi tạo map
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = "N";
			}
		}
		// Create Wall
		for (int row = 0; row < map.length; row++) {
			for (int collumn = 0; collumn < map[0].length; collumn++) {
				if (row == 0 || collumn == 0 || row == map.length - 1 || collumn == map.length - 1) {
					map[row][collumn] = "W"; // W = wall
				}
			}
		}
		// create monster randomly
		Random random = new Random();
		int xMonster , yMonster;
		for (int i = 0; i < 5; i++) {
			xMonster = random.nextInt((13-2) + 1 ) + 2;
			yMonster = random.nextInt((13-2) + 1 ) + 2;
			if (map[xMonster][yMonster] == "N") {
				map[xMonster][yMonster] = "E"; // E = Enemy
			}
		}
		// create brick randomly
		Random randomBrick = new Random();
		int xBrick , yBrick;
		int totalBrick = 300;
		for (int i = 0; i < totalBrick; i++) {
			xBrick = random.nextInt(map.length);
			yBrick = random.nextInt(map.length);
			if (map[xBrick][yBrick] == "N") {
				map[xBrick][yBrick] = "R"; //R = brick
			}
		}
		// create player
		map[1][1] = map[1][2] = map[1][3] = "N";
		map[1][1] = "P"; // P = player
		
		return map;
	}
	public static void write(String filename) throws IOException {
		String[][] x = createMap();
		BufferedWriter outputWriter = null;
		outputWriter = new BufferedWriter(new FileWriter(filename));
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				outputWriter.write(x[i][j] + "");
			}
			outputWriter.write("\n");
		}
		outputWriter.flush();
		outputWriter.close();
	}

}
