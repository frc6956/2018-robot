package org.usfirst.frc.team6956.robot.subsystems;

import org.usfirst.frc.team6956.robot.RobotMap;
import org.usfirst.frc.team6956.robot.commands.TeleopDrive;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {
	static final double ticsPerInch = 4096/(6*Math.PI);
	private double speedLimit = 1.0; // note: 0.25 is too small to move the robot
	double zeroDistance;
	
//	VictorSP m_frontLeft = new VictorSP(RobotMap.frontLeft);
//	VictorSP m_rearLeft = new VictorSP(RobotMap.backLeft);
//	SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
//
//	VictorSP m_frontRight = new VictorSP(RobotMap.frontRight);
//	VictorSP m_rearRight = new VictorSP(RobotMap.backRight);
//	SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
	WPI_TalonSRX m_leftSRX = new WPI_TalonSRX(RobotMap.leftDriveMotor);
	WPI_VictorSPX m_leftSPX = new WPI_VictorSPX(RobotMap.leftDriveMotor2);
	SpeedControllerGroup m_left = new SpeedControllerGroup(m_leftSRX, m_leftSPX);
	
	
	WPI_TalonSRX m_rightSRX = new WPI_TalonSRX(RobotMap.rightDriveMotor);
	WPI_VictorSPX m_rightSPX = new WPI_VictorSPX(RobotMap.rightDriveMotor2);
	SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightSRX, m_rightSPX);
	
	DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public Drivetrain() {
		m_rightSRX.setInverted(true);
		m_rightSPX.setInverted(true);
		m_leftSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		m_rightSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		resetDistanceTravelled();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new TeleopDrive());
	}
	
	public void setTankDrive(double left_Power, double right_Power) {
		m_drive.tankDrive(left_Power * speedLimit, right_Power * speedLimit);	
	} 
	
	public void setArcadeMode(double xSpeed, double zRotation) {
		m_drive.arcadeDrive(xSpeed * speedLimit,  zRotation * speedLimit);	
	} 
	
	public double getDistanceTravelled() {
		return getRawDistanceTravelled() - zeroDistance;
	}
	public double getRawDistanceTravelled() {
		double total = m_leftSRX.getSelectedSensorPosition(0) / ticsPerInch;
		total += m_rightSRX.getSelectedSensorPosition(0) / ticsPerInch;
		return(total/2);
	}
	
	public void resetDistanceTravelled() {
		zeroDistance = getRawDistanceTravelled();
	}
}
