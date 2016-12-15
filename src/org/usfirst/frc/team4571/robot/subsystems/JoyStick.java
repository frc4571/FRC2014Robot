package org.usfirst.frc.team4571.robot.subsystems;
import org.usfirst.frc.team4571.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class JoyStick extends Subsystem {
	Joystick stick;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public JoyStick(){
    	stick = new Joystick(RobotMap.joystickChannel);
    }
    public double getLateral(){
		if(Math.abs(stick.getX())>0.1){
			return (stick.getX()/2);
		}else{
			return 0;
		}
	}
	public double getForward(){
		if(Math.abs(stick.getY())>0.1){
			return (stick.getY()/2);
		}else{
			return 0;
		}
	}
	public double getRotation(){
		if(stick.getRawAxis(3)>0.05){
			return (stick.getRawAxis(3)/2);
		}else if(stick.getRawAxis(2)>0.05){
			return -(stick.getRawAxis(2)/2);
		}else{
			return 0;
		}
	}
	
}

