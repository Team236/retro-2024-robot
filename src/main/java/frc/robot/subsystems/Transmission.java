// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.TransmissionConstants;


public class Transmission extends SubsystemBase {
  private DoubleSolenoid transmission;


//** Creates a new Drive. */
  public Transmission() {
    //pneumatic double solenoid
    transmission = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.TransmissionConstants.SOL_LOW_GEAR, Constants.TransmissionConstants.SOL_HIGH_GEAR);
  }

  //methods start here
public void setGearHigh(){
  transmission.set(Value.kReverse);
}

public void setGearLow(){
  transmission.set(Value.kForward);
}

public boolean isInLowGear(){
  return transmission.get() == Value.kForward;
}

public boolean isInHighGear(){
  return transmission.get() == Value.kReverse;
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.getBoolean("In High Gear?", isInHighGear());
  }
}
