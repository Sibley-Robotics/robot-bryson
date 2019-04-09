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

  private double triggerError = .1;

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    SmartDashboard.putNumber("Trigger Deadzone", triggerError);
    if(Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_RIGHT_TRIGGER) > triggerError) {
      double intakeSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_RIGHT_TRIGGER);
      Robot.m_collector.intakeCollector(intakeSpeed);
      SmartDashboard.putNumber("Trigger Value", intakeSpeed);
    }
    else if(Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_LEFT_TRIGGER) > triggerError){
      double intakeSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_LEFT_TRIGGER);
      Robot.m_collector.intakeCollector(-intakeSpeed);
      SmartDashboard.putNumber("Trigger Value", intakeSpeed);
    }
    else {
      Robot.m_collector.intakeCollector(0.0);
    }
    
  }

  @Override
  protected boolean isFinished() {
    return false;
  } 

  protected void end() {
    Robot.m_collector.intakeCollector(0.0);
  }

  protected void interrupted() {
    end();
  }
}
