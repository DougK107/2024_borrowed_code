package frc.robot.subsystems.drive;

// import com.ctre.phoenix6.configs.Pigeon2Configuration;
// import com.ctre.phoenix6.configs.Pigeon2Configurator;
// import com.ctre.phoenix6.hardware.Pigeon2;
import com.kauailabs.navx.frc.AHRS;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SPI;

public class GyroIONavX implements GyroIO {
    
    public static AHRS m_gyro = new AHRS(SPI.Port.kMXP);

    // private Pigeon2 gyro;
    // private Pigeon2Configurator gyroConfigurator;
    // private Pigeon2Configuration gyroConfig;

    // public GyroIOPigeon2() {
    //     gyro = new Pigeon2(Constants.Misc.GYRO_PORT, "rio");
    //     gyroConfigurator = gyro.getConfigurator();
    //     config();

    // }

    // private void config() {
    //     gyroConfig = new Pigeon2Configuration();
    //     gyroConfig.MountPose.MountPoseYaw = -0.263672;
    //     gyroConfig.MountPose.MountPosePitch = 0.307617;
    //     gyroConfig.MountPose.MountPoseRoll = -0.483398;
    //     gyroConfigurator.apply(gyroConfig);
    // }

    public void updateInputs(GyroIOInputs inputs) 
    {
        inputs.yaw = m_gyro.getYaw() * Constants.TAU/360 + Constants.TAU/2;
        inputs.pitch = m_gyro.getPitch() * Constants.TAU/360;
        inputs.roll = m_gyro.getRoll() * Constants.TAU/360;

        // inputs.yaw = gyro.getYaw().getValue() * Constants.TAU/360 + Constants.TAU/2;
        // inputs.pitch = gyro.getPitch().getValue() * Constants.TAU/360;
        // inputs.roll = gyro.getRoll().getValue() * Constants.TAU/360;
    }
//dk - only handling the zero for now, no way to set 
    public void setYaw(double angle) {
       m_gyro.zeroYaw(); //"Sets the user-specified yaw offset to the current yaw value reported by the sensor."
    }

}
