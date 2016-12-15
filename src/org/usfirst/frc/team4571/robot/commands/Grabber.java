package org.usfirst.frc.team4571.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4571.robot.Robot;
/**
 *
 */
public class Grabber extends Command {
	int numberPressed;
	boolean isFinished;
	boolean isAuto;
    public Grabber(int x, boolean isAuto2) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	 requires(Robot.pneumatics);
         numberPressed=x;
         isAuto = isAuto2;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isFinished=false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(numberPressed % 2 == 0){
    		Robot.pneumatics.pushOutArms();
    		numberPressed++;
    		isFinished=true;
    	} else{
    		Robot.pneumatics.pushInArms();
    		numberPressed++;
    		isFinished=true;
    	}
    	if(isAuto) {
    		Timer.delay(1.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
