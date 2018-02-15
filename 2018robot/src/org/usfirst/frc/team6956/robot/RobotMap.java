/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6956.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	//USB Ports
	public static final int driverController = 0;
	public static final int operatorController = 1;
//	CAN
	public static final int rightDriveMotor = 0;
	public static final int leftDriveMotor = 1;
	public static final int rightDriveMotor2 = 0;
	public static final int leftDriveMotor2 = 1;
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	//PWM
	public static final int frontRight = 0;
	public static final int backRight = 1;
	public static final int frontLeft = 2;
	public static final int backLeft = 3;
	public static final int arm = 4;
	
	public static final int climberMotor1 = 6;
	public static final int climberMotor2 = 7;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//Analog ports
	public static final int potentiometer = 0;
	public static final int gyro = 1;
	
	//PCM
	public static final int doubleSolenoidA = 0;
	public static final int doubleSolenoidB = 1;
}