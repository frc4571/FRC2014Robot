package org.usfirst.frc.team4571.robot.subsystems;
import org.usfirst.frc.team4571.robot.RobotMap;
import org.usfirst.frc.team4571.robot.commands.Driving;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;



/**
 *
 */
public class DriveSystem extends Subsystem {
	public RobotDrive robotDrive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Driving(false, false, 0));
    }
    public DriveSystem() {
    	super("DriveTrain");
        robotDrive = new RobotDrive(RobotMap.frontLeftChannel, RobotMap.rearLeftChannel, RobotMap.frontRightChannel, RobotMap.rearRightChannel);
    	robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);	// invert the left side motors
    	robotDrive.setInvertedMotor(MotorType.kRearLeft, true);		// you may need to change or remove this to match your robot
        robotDrive.setExpiration(0.1);
        robotDrive.setSafetyEnabled(true);

        
    }
    public void mechanumDrive(double lateral, double forward, double rotation){
    		
        	// Use the joystick X axis for lateral movement, Y axis for forward movement, and Z axis for rotation.
        	// This sample does not use field-oriented drive, so the gyro input is set to zero.
        	robotDrive.mecanumDrive_Cartesian(lateral, forward, rotation, 0);
        	/*System.out.println("lateral"+lateral);
        	System.out.println("forward"+forward);
        	System.out.println("rotationS"+rotation);*/
        	Timer.delay(0.005);// wait 5ms to avoid hogging CPU cycles
        	
    }
    
}

