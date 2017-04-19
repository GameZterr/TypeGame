package at.htlklu.bitzan;

import java.util.Random;

public class RandomTexture {
private Random r = new Random();
private String randomPath;

public void RandomTexture(){
}

	public String generate(){
		switch(r.nextInt(7)){
		case 0:
			randomPath = "res/block_red.png";
			break;
		case 1:
			randomPath = "res/block_yellow.png";
			break;
		case 2:
			randomPath = "res/block_blue.png";
			break;
		case 3:
			randomPath = "res/block_darkBlue.png";
			break;
		case 4:
			randomPath = "res/block_orange.png";
			break;
		case 5:
			randomPath = "res/block_green.png";
			break;
		case 6:
			randomPath = "res/block_purple.png";
			break;
		}
	return randomPath;
}

}
