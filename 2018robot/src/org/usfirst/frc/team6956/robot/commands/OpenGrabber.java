package org.usfirst.frc.team6956.robot.commands;

import org.usfirst.frc.team6956.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class OpenGrabber extends InstantCommand {

    public OpenGrabber() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.grabber);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.grabber.open();
    }

}
