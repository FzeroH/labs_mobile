package maksimov.ru.lab.activity

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import maksimov.ru.lab.R

class SensorsActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var sensor: Sensor
    private lateinit var view: View
    private lateinit var cost: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensors)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        view = findViewById(R.id.view)
        cost = findViewById(R.id.rotation)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun onPause(){
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        val rotationMatrix = FloatArray(16)
        SensorManager.getRotationMatrixFromVector(
            rotationMatrix, p0?.values)
        val remappedRotationMatrix = FloatArray(16)
        SensorManager.remapCoordinateSystem(rotationMatrix,
            SensorManager.AXIS_X,
            SensorManager.AXIS_Z,
            remappedRotationMatrix)

// Convert to orientations
        val orientations = FloatArray(3)
        SensorManager.getOrientation(remappedRotationMatrix, orientations);
        for(i in 0..2) run {
            orientations[i] = Math.toDegrees(orientations[i].toDouble()).toFloat()
        }
        cost.text = orientations[2].toInt().toString()
        view.rotation = -orientations[2]
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}

