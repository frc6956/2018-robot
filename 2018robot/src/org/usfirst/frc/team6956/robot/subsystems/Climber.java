package org.usfirst.frc.team6956.robot.subsystems;

import org.usfirst.frc.team6956.robot.RobotMap;
import org.usfirst.frc.team6956.robot.commands.TeleopClimber;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	SpeedController motor1 = new Talon(RobotMap.climberMotor1);
	SpeedController motor2 = new Talon(RobotMap.climberMotor2);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleopClimber());
    }
    
    public void climb(double speed) {
    	motor1.set(speed);
    	motor2.set(speed);
    }
}

