package org.usfirst.frc.team6956.robot.commands;

import org.usfirst.frc.team6956.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedDriveStraight extends TimedCommand {

    public TimedDriveStraight(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.setTankDrive(0.5, 0.5);
    }
    
    // Called once after timeout
    protected void end() {
    	Robot.drivetrain.setTankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
