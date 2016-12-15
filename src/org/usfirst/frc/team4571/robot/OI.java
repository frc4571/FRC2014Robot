package org.usfirst.frc.team4571.robot;
import org.usfirst.frc.team4571.robot.commands.Elevator;
import org.usfirst.frc.team4571.robot.commands.Grabber;
import org.usfirst.frc.team4571.robot.commands.Sweep;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
     Joystick stick = new Joystick(0);
     Button buttonA = new JoystickButton(stick, 1);
     Button buttonB = new JoystickButton(stick, 2);
     Button buttonX = new JoystickButton(stick, 3);
     Button buttonY = new JoystickButton(stick, 4);
     
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
     public OI(){
    	 buttonA.whenPressed(new Grabber(1, false));
    	 buttonX.whenPressed(new Sweep(1));
    	 buttonY.whenPressed(new Elevator(1, false, false));
    	 buttonY.whenReleased(new Elevator(1, false, true));
    	 buttonB.whenPressed(new Elevator(2, false, false));
    	 buttonB.whenReleased(new Elevator(2, false, true));
    	 //buttonB.whenPressed(new Calibrating());
     }
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

