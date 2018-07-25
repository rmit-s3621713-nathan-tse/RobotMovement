import java.util.Scanner;
import java.util.StringTokenizer;

public class RobotMovement {
	
	//constants for the maximum x and y values
	static final int XMAXVAL= 4;
	static final int YMAXVAL = 4;
	
	//intialising x and y values
	int xValue ;
	int yValue; 
	
	//intialising the direction, the direction is an integer 0-3
	int direction;
	
	//intialising boolean for robot being placed
	boolean robotPlaced = false;
	
	Scanner sc = new Scanner(System.in);
	
	String robotCommand;
	
	//an array to store all directions the robot can face.
	String[] directions = {"NORTH", "EAST","SOUTH","WEST"};
	
	
	

	public void robotCommands() {
		
		
		
		// TODO Auto-generated method stub
		
		
		
		
		do {
			System.out.println("Robot Command: ");
			robotCommand = sc.next();
			
			
			switch (robotCommand) {
			
			case "PLACE":
				
				String coordinates = sc.next();
				
				//Using a string tokenizer to to break up the second string
				StringTokenizer tok = new StringTokenizer(coordinates);
				
				String x = tok.nextToken(",");
				int xPos= convertString(x);
				
			
				
				String y = tok.nextToken(",");
				int yPos = convertString(y);
	
				
				String dir = tok.nextToken();
				
				placeRobot(xPos, yPos, dir);
					
				break;
			case"MOVE":
				// checks if robot is still in range
				if(coordiantesInRange(xValue, yValue) == true && robotPlaced == true)
				{
					moveRobot();
				}
				break;
			case "LEFT":
	
				// checks if the robot has been placed before turning robot
				if(robotPlaced == true)
				{
					turnRobot(robotCommand);
				}
				
				break;
			case "RIGHT":
				if(robotPlaced == true)
				{
					turnRobot(robotCommand);
				}
				break;
				
			case "REPORT":
				if(robotPlaced == true)
				{
					System.out.println(xValue +", " + yValue + ", "+ directions[direction] );
				}
				
				break;
			
			}
			
		//ends do loop when report command is entered
		}while(robotCommand.equals("REPORT")== false);
		
		
	}
	
	// compares the input to the directions list to see if it is a valid direction then assigns to the intialised variables
	public  boolean placeRobot(int x, int y, String dir)
	{
		
		int n = directions.length;
		robotPlaced = false;
		for(int i =0; i <n; i++)
		{
			if(dir.equals(directions[i])== true)
			{
				direction = i;
				if(coordiantesInRange(x,y) == true)
				{
					robotPlaced = true;
					xValue = x;
					yValue = y;
				}else
					robotPlaced = false;
				
			}
				
		}
		
		return robotPlaced;
		
		
	}
	//Increments or decrements the x and y values depending on where the robot is facing.
	public void moveRobot() {
			
		if(direction ==0)
		{
			yValue++;
		}
		else if(direction == 1)
		{
			xValue++;
		}
		else if(direction == 2)
		{
			yValue--;
		}
		else if(direction ==3)
		{
			xValue--;
		}
	}
	//Algorithm to find the next direction determined by the current direction
	public void turnRobot(String turnDirection)
	{
		if(turnDirection.equals("RIGHT") == true)
		{
			direction =(direction +1)%4;
		}
		else if(turnDirection.equals("LEFT")== true)
		{
			direction = (4 + direction -1) %4;
		}
			
	}
	//checks if the coordiantes are less than the boundary
	public boolean coordiantesInRange(int x, int y)
	{
		
		if((x >=0 && x < XMAXVAL) && (y >=0 && y < YMAXVAL))
		{
			return true;
		}
		else
			return false;
		
	}
	
	public int convertString(String number)
	{

		
		try
		{
			int num = Integer.parseInt(number);
			return num;
			
		}
		catch(NumberFormatException e) {
			
			robotPlaced = false;
		}
		return 99;
	
		
		
	}
	
	
	
}

