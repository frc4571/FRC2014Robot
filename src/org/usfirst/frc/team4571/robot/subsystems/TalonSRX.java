package org.usfirst.frc.team4571.robot.subsystems;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TalonSRX extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon motorRight, motorLeft;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
       // setDefaultCommand(new Elevator(1));
    }
    public TalonSRX(){
    	motorRight = new CANTalon(1); // Initialize the CanTalonSRX on device 1.
    	motorLeft = new CANTalon(2); 
    }
    public void goUp(){
    	 // Set the motor's output to half power.
        // This takes a number from -1 (100% speed in reverse) to +1 (100% speed
        // going forward)
    	
	        motorRight.set(0.7);
	        motorLeft.set(0.7);
	        Timer.delay(0.01);  // Note that the CANTalon only receives updates every
    	                    // 10ms, so updating more quickly would not gain you
                            // anything.
    }
    
    public void goDown(){
   	 // Set the motor's output to half power.
       // This takes a number from -1 (100% speed in reverse) to +1 (100% speed
       // going forward)
       motorRight.set(-0.7);
       motorLeft.set(-0.7);
       Timer.delay(0.01);  // Note that the CANTalon only receives updates every
                           // 10ms, so updating more quickly would not gain you
                           // anything.
   }
    public void stop(){
    	motorRight.set(0);
    	motorLeft.set(0);
    }
}


