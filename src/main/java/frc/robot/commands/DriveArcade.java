/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveArcade extends Command {
  public DriveArcade() {
    //Saying that this code required Drivetrain.java to be used, freeing it from usage of other code
    requires(Robot.m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    /* On run of the Driving code, assign the axis value from the var "DRIVER_CONTROLLER_MOVE_AXIS" 
    which is assigned a port in the robot map, the port is assigned based on the axis in the 
    driverstation view of the controller
    */
    
    double moveSpeed = -Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
    double rotateSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_AXIS);

    SmartDashboard.putNumber("Left/Right Turn", rotateSpeed);
    SmartDashboard.putNumber("Forward/Backward Drive", moveSpeed);
    //Feed the method robotDrive the axis value for "moveSpeed" and "rotateSpeed"

    Robot.m_drivetrain.robotDrive(moveSpeed, rotateSpeed);
    
  }
  
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //When we are done calling the driving code, feed the robot 0 drive and 0 rotate speed to cause
    // it to stop moving
    Robot.m_drivetrain.robotDrive(0.0, 0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
