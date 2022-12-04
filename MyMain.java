package Final;

public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		//ADD HIGHLIGHTER OBJECT FIRST SO IT SITS BEHIND OTHER OBJECTS
		Highlight hilighter = new Highlight(100, 100);
		hilighter.setVelocity(10);
		canvas.addKeyListener(hilighter);
		canvas.addGameObject(hilighter);
	
		//ADD OTHER OBJECTS
		Type_D_GameObject blockD = new Type_D_GameObject(100, 100);
		blockD.setVelocity(10);
		canvas.addKeyListener(blockD);
		canvas.addGameObject(blockD);
		
		Type_A_GameObject blockA = new Type_A_GameObject(200, 500);
		blockA.setVelocity(10);
		canvas.addKeyListener(blockA);
		canvas.addGameObject(blockA);
		
		Type_C_GameObject blockC = new Type_C_GameObject(500, 250);
		blockC.setVelocity(10);
		canvas.addKeyListener(blockC);
		canvas.addGameObject(blockC);
		
		Type_B_GameObject blockB = new Type_B_GameObject(400, 0);
		blockB.setVelocity(10);
		canvas.addKeyListener(blockB);
		canvas.addGameObject(blockB);
		
		
	}

}

