package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Driving extends Command {
	public boolean isAuto = false;
	public boolean forward = false;
	public boolean stopAuto = false;
	public int seconds;
    public Driving(boolean isAuto2, boolean forward2, int seconds2) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSystem);
    	requires(Robot.joyStick);
    	requires(Robot.objectSwitch);
    	isAuto = isAuto2;
    	forward= forward2;
    	seconds=seconds2;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.objectSwitch.initializeCounter();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!(isAuto)){
    		Robot.driveSystem.mechanumDrive(Robot.joyStick.getLateral(), Robot.joyStick.getForward(), Robot.joyStick.getRotation());
    	}else if(forward){
    		for(int i=0; i<seconds;i++){
    			Robot.driveSystem.mechanumDrive(0.0, 0.0, -0.5);
    		}
    		stopAuto = true;
    	}else{
    		for (int i=0; i<200; i++){
    			Robot.driveSystem.mechanumDrive(0.0, 0.5, 0.0);
    			
    		}
    		//for(int i=0; i<seconds;i++){
    			//Robot.driveSystem.mechanumDrive(0.0, -0.5, 0.0);
    		//} 
    		stopAuto = true;
    	}
    	
         
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isAuto && stopAuto == true) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println('1');
    	Robot.driveSystem.mechanumDrive(0.0, 0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
