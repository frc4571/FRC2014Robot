
package org.usfirst.frc.team4571.robot;

import org.usfirst.frc.team4571.robot.commands.Autonomous;
import org.usfirst.frc.team4571.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4571.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.JoyStick;
import org.usfirst.frc.team4571.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4571.robot.subsystems.Switch;
import org.usfirst.frc.team4571.robot.subsystems.TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static final DriveSystem driveSystem = new DriveSystem();
	public static final JoyStick joyStick = new JoyStick();
	//public static final Camera camera = new Camera();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final TalonSRX talonSRX = new TalonSRX();
	public static final Switch objectSwitch = new Switch(4);
	public static final Switch arm1UpSwitch = new Switch(1);
	public static final Switch arm1DownSwitch = new Switch(0);
	public static final Switch arm2UpSwitch = new Switch(2);
	public static final Switch arm2DownSwitch = new Switch(3);
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new Autonomous();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
