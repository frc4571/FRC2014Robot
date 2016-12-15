package org.usfirst.frc.team4571.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    Compressor compressor = new Compressor(0);
	DoubleSolenoid grabberSolenoid = new DoubleSolenoid(0, 1);
	DoubleSolenoid sweeperSolenoid = new DoubleSolenoid(2, 3);

    public Pneumatics() {
        compressor.setClosedLoopControl(true);
    }

    /**
     * Drive left & right motors for 2 seconds then stop
     */
    public void autonomous() {
        
    }

    /**
     * push pistons out
     */
    public void pushOutArms() {
        grabberSolenoid.set(DoubleSolenoid.Value.kReverse);        
    	}
    public void pushInArms(){
    	grabberSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void sweepDown() {
    	sweeperSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void sweepUp() {
    	sweeperSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}

