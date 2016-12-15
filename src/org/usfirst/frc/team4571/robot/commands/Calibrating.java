package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Calibrating extends Command {

	Timer timer = new Timer();
    public Calibrating() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSystem);
    	requires(Robot.joyStick);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if (timer.get()<4 || (timer.get()>10 && timer.get()<14)){
    			Robot.driveSystem.mechanumDrive(0, 1.0, 0);
    			
    		}else if((timer.get()>4 && timer.get()<5)||(timer.get()>14 && timer.get()<15)){
				Robot.driveSystem.mechanumDrive(0, 0, 0);
			}
    		else if ((timer.get()>5 && timer.get()<9) || timer.get()>15){
    			Robot.driveSystem.mechanumDrive(0, -1.0, 0);
    			
    		} else{
    				Robot.driveSystem.mechanumDrive(0, 0, 0);		
    		}
    		System.out.println(timer.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timer.get()>=20){
    		return true;
    	}else{
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSystem.mechanumDrive(0, 0, 0);
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
