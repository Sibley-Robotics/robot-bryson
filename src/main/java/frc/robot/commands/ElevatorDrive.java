/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.*;



public class ElevatorDrive extends Command {
  public ElevatorDrive() {
    requires(Robot.m_elevator);
  }
  public boolean leftBumper;
  public boolean rightBumper;
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    //Declare a true or false value for the variables keftBumbper and rightBumper to test if 
    // they are activated or not
    
    //Assigns the recieved controller value from a port assigned in RobotMap
    leftBumper = Robot.m_oi.driverController.getRawButton(RobotMap.DRIVER_CONTROLLER_LEFT_BUMPER);
    rightBumper = Robot.m_oi.driverController.getRawButton(RobotMap.DRIVER_CONTROLLER_RIGHT_BUMPER);
    SmartDashboard.putBoolean("L Bumper Pressed?", leftBumper);
    SmartDashboard.putBoolean("R Bumper Pressed?", rightBumper);
    // Checks if the left bumper is activated, and if so it sets the elevator motor to 90% speed downward
    if(leftBumper == true) {
      //Set elevator motor speed to 90% power reverse
      Robot.m_elevator.driveElevator(-1); 
    }
    // If the left bumper is activated, it checks if the right bumper is activated, and if so it sets the elevator motor to 90% speed upward
    else if(rightBumper == true) {
      Robot.m_elevator.driveElevator(1);
    }
    else {
      Robot.m_elevator.driveElevator(0);
    }
    
   
  }

  
  protected boolean isFinished() {
    return false;
    
  }

  // Called once after isFinished returns true
  protected void end() {}
  protected void interrupted() {}
}
