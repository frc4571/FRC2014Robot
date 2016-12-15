package org.usfirst.frc.team4571.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Switch extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 DigitalInput limitSwitch;
	 Counter counter;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new Driving(true));
    }
    
    public Switch(int input) {
    	limitSwitch = new DigitalInput(input);
    	counter = new Counter(limitSwitch);
    }
    
    public boolean isSwitchSet() {
        return counter.get() > 0;
    }
    
    public boolean getCurrentValue() {
		return limitSwitch.get();
    }

    public void initializeCounter() {
        counter.reset();
    }
}

