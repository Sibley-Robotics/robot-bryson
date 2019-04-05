/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
/**
 * Add your docs here.
 */
public class Collector extends Subsystem {
  DoubleSolenoid actuateSolenoid = null;

  public Collector() {
    actuateSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_SOLENOID_OPEN, RobotMap.COLLECTOR_SOLENOID_CLOSE);
  }
  public void actuateCollectorOpen() {
    actuateSolenoid.set(Value.kForward);
  }
  public void actuateCollectorClosed() {
    actuateSolenoid.set(Value.kForward);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
