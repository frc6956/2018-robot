package org.usfirst.frc.team6956.robot.commands;

import org.usfirst.frc.team6956.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StopArm extends InstantCommand {

    public StopArm() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.arm);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.arm.setArmSpeed(0);
    }

}
