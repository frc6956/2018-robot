/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6956.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final boolean useJoysticks = false;
	XboxController driver = new XboxController(RobotMap.driverControllerLeft);
	Joystick driverLeft = new Joystick(RobotMap.driverControllerLeft);
	Joystick driverRight = new Joystick(RobotMap.driverControllerRight);
	XboxController operator = new XboxController(RobotMap.operatorController);
	
	public double getLeftDrive() {
		if (useJoysticks) {
			return -driverLeft.getY();
		} else {
			return -driver.getY(Hand.kLeft);
		}
	}
	public double getRightDrive() {
		if (useJoysticks) {
			return -driverRight.getY();
		} else {
			return -driver.getY(Hand.kRight);
		}
	}
	
	public double getArmSpeed() {
		return -operator.getY(Hand.kRight);
	}
	
	public double getClimber() {
		return Math.abs(operator.getY(Hand.kLeft));
	}
	
	public boolean openGrabber() {
		return operator.getBumperPressed(Hand.kRight);
	}
	
	public boolean closeGrabber() {
		return operator.getBumperPressed(Hand.kLeft);
	}
}
