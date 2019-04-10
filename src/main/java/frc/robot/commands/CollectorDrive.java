/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.*;

public class CollectorDrive extends Command {
  public CollectorDrive() {
    requires(Robot.m_collector);
  }
  //Declares a deadzone for the triggers so prevent continous activation
  private double triggerError = .1;

  protected void initialize() {}

  @Override
  protected void execute() {
    //Displays what the set triggerError value
    SmartDashboard.putNumber("Trigger Deadzone", triggerError);
    //Checks if the read value of the right trigger is greater than the error value
    if(Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_RIGHT_TRIGGER) > triggerError) {
      //Sets intake speed to the value of the trigger
      double intakeSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_RIGHT_TRIGGER);
      //Passes the motor speed
      Robot.m_collector.intakeCollector(intakeSpeed);
      //Displays what value is recieved from the trigger and what speed the collector is running at
      SmartDashboard.putNumber("Trigger Value", intakeSpeed);
    }
    //Next it tests the same thing for the left trigger
    else if(Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_LEFT_TRIGGER) > triggerError){
      double intakeSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_LEFT_TRIGGER);
      //Sets the speed to negative the trigger value, to spin the wheels the oposite way to intake
      Robot.m_collector.intakeCollector(-intakeSpeed);
      SmartDashboard.putNumber("Trigger Value", intakeSpeed);
    }
    else {
      //If no triggers are being pressed then set the motors to not move
      Robot.m_collector.intakeCollector(0.0);
    }
    
  }

  @Override
  protected boolean isFinished() {
    //Set to always run while the robot is on
    return false;
  } 

  protected void end() {
    //If the command ever ends, stop the intake mtoors
    Robot.m_collector.intakeCollector(0.0);
  }

  protected void interrupted() {
    //If the command is interrupted, stop the motors
    end();
  }
}
