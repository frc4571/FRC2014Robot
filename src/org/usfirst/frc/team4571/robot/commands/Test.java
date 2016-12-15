package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Test extends Command {
	Talon rearRight = new Talon(RobotMap.rearRightChannel);
	Talon rearLeft = new Talon(RobotMap.rearLeftChannel);
	Talon frontRight = new Talon(RobotMap.frontRightChannel);
	Talon frontLeft = new Talon(RobotMap.frontLeftChannel);
	int numMax;
	boolean done;
    public Test() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	done = false;
    	numMax = 5000;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	for(int i = 0; i < numMax; i++) {
	    	rearRight.set(0.2);
	    	rearLeft.set(0.2);
	    	frontRight.set(-0.2);
	    	frontLeft.set(-0.2);
	    	Timer.delay(0.001);
    	}
    	done = true;
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
