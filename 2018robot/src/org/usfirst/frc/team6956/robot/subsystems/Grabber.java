package org.usfirst.frc.team6956.robot.subsystems;

import org.usfirst.frc.team6956.robot.RobotMap;
import org.usfirst.frc.team6956.robot.commands.TeleopGrabber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
	DoubleSolenoid doubleSolenoid = new DoubleSolenoid(RobotMap.doubleSolenoidA, RobotMap.doubleSolenoidB);
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
    	doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    	times_closed++;
    }
    
    public void open() {
    	doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    	times_opened++;
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

