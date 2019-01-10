package org.usfirst.frc.team6956.robot.subsystems;

import org.usfirst.frc.team6956.robot.RobotMap;
import org.usfirst.frc.team6956.robot.commands.TeleopArm;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Arm extends Subsystem {
	Talon motor = new Talon(RobotMap.arm);
	Potentiometer potentiometer = new AnalogPotentiometer(RobotMap.potentiometer);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleopArm());
    }
    
    public void setArmSpeed(double speed) {
		motor.setSpeed(speed);
	}
    
    public double getSensorPosition() {
    	return potentiometer.get();
    }
}

