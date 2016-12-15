package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator extends Command {
	int buttonPressed;
	protected boolean isAuto = false, isReleased = false;
    public Elevator(int x, boolean isAuto2, boolean isReleased2) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.talonSRX);
    	requires(Robot.arm1UpSwitch);
    	requires(Robot.arm1DownSwitch);
    	requires(Robot.arm2UpSwitch);
    	requires(Robot.arm2DownSwitch);
    	buttonPressed = x;
    	isAuto = isAuto2;
    	isReleased = isReleased2;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm1UpSwitch.initializeCounter();
    	Robot.arm1DownSwitch.initializeCounter();
    	Robot.arm2UpSwitch.initializeCounter();
    	Robot.arm2DownSwitch.initializeCounter();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isReleased == false) {
    		if(isAuto && buttonPressed == 1) {
    			for (int i=0; i<70; i++){
	    			if(buttonPressed==1 && Robot.arm1UpSwitch.getCurrentValue() && Robot.arm2UpSwitch.getCurrentValue()){
			    		
			    		Robot.talonSRX.goUp();
			    	
	    			}
    			}
    			isReleased = true;
    		} else {
		    	if(buttonPressed==1 && Robot.arm1UpSwitch.getCurrentValue() && Robot.arm2UpSwitch.getCurrentValue()){
		    		
		    		Robot.talonSRX.goUp();
		    	}else if(buttonPressed == 2 && Robot.arm1DownSwitch.getCurrentValue() && Robot.arm2DownSwitch.getCurrentValue()){
		    		Robot.talonSRX.goDown();
		    	}
    		}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(buttonPressed == 1 && (Robot.arm1UpSwitch.isSwitchSet() || Robot.arm2UpSwitch.isSwitchSet())) {
    		return true;
    	} else if(buttonPressed == 2 && (Robot.arm1DownSwitch.isSwitchSet() || Robot.arm2DownSwitch.isSwitchSet())) {
    		return true;
    	} else if(isReleased) {
    		return true;
    	} else if(isAuto){
    		return false;
    	}  else{
    		return false;
    	}
    	
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.talonSRX.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
