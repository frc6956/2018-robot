package org.usfirst.frc.team6956.robot.subsystems;

import org.usfirst.frc.team6956.robot.RobotMap;
import org.usfirst.frc.team6956.robot.commands.TeleopGrabber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Grabber extends Subsystem {
	DoubleSolenoid doubleSolenoid = new DoubleSolenoid(RobotMap.doubleSolenoidA, RobotMap.doubleSolenoidB);
	Talon motor = new Talon(RobotMap.spinners);
	private int times_opened = 0;
	private int times_closed = 0;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleopGrabber());
    }
    
    public void close() {
		if (doubleSolenoid.get() != DoubleSolenoid.Value.kForward) {
			doubleSolenoid.set(DoubleSolenoid.Value.kForward);
			times_closed++;
			SmartDashboard.putNumber("Times Closed", times_closed);
			SmartDashboard.putString("Grabber State", "Closed");
		}
    }
    
    public void open() {
		if (doubleSolenoid.get() != DoubleSolenoid.Value.kReverse) {
			doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
			times_opened++;
			SmartDashboard.putNumber("Times Opened", times_opened);
			SmartDashboard.putString("Grabber State", "Open");
		}
    }
    
    public void spin(double speed) {
    	motor.setSpeed(speed);
    }
    
    public int getTimesOpened() {
    	return times_opened;
    }
    
    public int getTimesClosed() {
    	return times_closed;
    }
    
    public int getTimesOpenedAndClosed() {
    	return getTimesOpened() + getTimesClosed();
    }
}

