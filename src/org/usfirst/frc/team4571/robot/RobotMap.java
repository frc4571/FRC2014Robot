package org.usfirst.frc.team4571.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	// Channels for the wheels
    public static int frontLeftChannel	= 2;
    public static int rearLeftChannel	= 3;
    public static int frontRightChannel	= 1;
    public static int rearRightChannel	= 0;
    
    // The channel on the driver station that the joystick is connected to
    public static int joystickChannel	= 0;
    
    
	public static double AREA_MINIMUM = 0.5; //Default Area minimum for particle as a percentage of total image area
	public static double LONG_RATIO = 2.22; //Tote long side = 26.9 / Tote height = 12.1 = 2.22
	public static double SHORT_RATIO = 1.4; //Tote short side = 16.9 / Tote height = 12.1 = 1.4
	public static double SCORE_MIN = 75.0;  //Minimum score to be considered a tote
	public static double VIEW_ANGLE = 64; //View angle fo camera, set to Axis m1011 by default, 64 for m1013, 51.7 for 206, 52 for HD3000 square, 60 for HD3000 640x480
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
