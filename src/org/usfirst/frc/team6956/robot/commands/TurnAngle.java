package org.usfirst.frc.team6956.robot.commands;

import org.usfirst.frc.team6956.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnAngle extends Command {

	double desiredAngle;
	
    public TurnAngle(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	desiredAngle = angle;
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (desiredAngle > 0) {
    		Robot.drivetrain.setTankDrive(0.5, -0.5);
    	} else if (desiredAngle < 0) {
    		Robot.drivetrain.setTankDrive(-0.5, 0.5);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	boolean a = Math.abs(-6.0) > Math.abs(5.0);
    	 return Math.abs(Robot.gyro.getAngle()) >= Math.abs(desiredAngle);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.setTankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
