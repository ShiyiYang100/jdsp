package com.onyx.jdsp;

import com.onyx.jdsp.filter.Butterworth;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestButterworth {

    // 5Hz Sine + 15Hz Sine + 30Hz Sine sampled @ 100Hz with Nyquist of 50Hz
    private double[] signal = {0.0, 2.069, 0.951, 0.53, 1.314, 0.0, -0.588, 1.706, 2.127, 0.167, -0.0, -0.167, -2.127,
            -1.706, 0.588, 0.0, -1.314, -0.53, -0.951, -2.069, -0.0, 2.069, 0.951, 0.53, 1.314, 0.0, -0.588, 1.706,
            2.127, 0.167, -0.0,-0.167, -2.127, -1.706, 0.588, -0.0, -1.314, -0.53, -0.951, -2.069, -0.0, 2.069, 0.951,
            0.53, 1.314, 0.0,-0.588, 1.706, 2.127, 0.167, -0.0, -0.167, -2.127, -1.706, 0.588, 0.0, -1.314, -0.53,
            -0.951, -2.069, -0.0, 2.069, 0.951, 0.53, 1.314, 0.0, -0.588, 1.706, 2.127, 0.167, -0.0, -0.167, -2.127,
            -1.706, 0.588, 0.0, -1.314, -0.53, -0.951, -2.069, -0.0, 2.069, 0.951, 0.53, 1.314, 0.0, -0.588, 1.706,
            2.127, 0.167, -0.0, -0.167, -2.127, -1.706, 0.588, 0.0, -1.314, -0.53, -0.951, -2.069};

    private Butterworth flt = new Butterworth(this.signal, 100);

    @Test
    public void LowPassTest() {
        final double[] out = {0.0, 0.007, 0.049, 0.161, 0.35, 0.575, 0.774, 0.881, 0.879, 0.822, 0.779, 0.763, 0.726, 0.598,
                0.33, -0.049, -0.431, -0.713, -0.861, -0.901, -0.89, -0.867, -0.805, -0.633, -0.325, 0.071, 0.461,
                0.747, 0.881, 0.905, 0.891, 0.862, 0.792, 0.624, 0.324, -0.075, -0.463, -0.741, -0.878, -0.907, -0.887,
                -0.859, -0.795, -0.625, -0.32, 0.072, 0.46, 0.745, 0.879, 0.903, 0.889, 0.862, 0.792, 0.625, 0.324,
                -0.074, -0.463, -0.741, -0.879, -0.907, -0.887, -0.859, -0.795, -0.625, -0.32, 0.072, 0.46, 0.745,
                0.879, 0.903, 0.889, 0.862, 0.792, 0.625, 0.324, -0.074, -0.463, -0.741, -0.879, -0.907, -0.887, -0.859,
                -0.795, -0.625, -0.32, 0.072, 0.46, 0.745, 0.879, 0.903, 0.889, 0.862, 0.792, 0.625, 0.324, -0.074,
                -0.463, -0.741, -0.879, -0.907};

        double[] result = flt.low_pass_filter(4, 9);
        assertArrayEquals(out, result, 0.001);
    }

    @Test
    public void HighPassTest() {
        final double[] out = {0.0, 0.112, -0.468, 0.721, -0.364, -0.356, 0.688, -0.217, -0.6, 0.651, 0.227, -0.773,
                0.269, 0.579, -0.677, -0.178, 0.812, -0.282, -0.609, 0.651, 0.167, -0.793, 0.318, 0.629, -0.663, -0.2,
                0.766, -0.316, -0.6, 0.696, 0.21, -0.788, 0.282, 0.581, -0.684, -0.177, 0.814, -0.284, -0.61, 0.651,
                0.167, -0.793, 0.318, 0.629, -0.663, -0.2, 0.766, -0.316, -0.6, 0.696, 0.21, -0.788, 0.282, 0.581,
                -0.684, -0.177, 0.814, -0.284, -0.61, 0.651, 0.167, -0.793, 0.318, 0.629, -0.663, -0.2, 0.766, -0.316,
                -0.6, 0.696, 0.21, -0.788, 0.282, 0.581, -0.684, -0.177, 0.814, -0.284, -0.61, 0.651, 0.167, -0.793,
                0.318, 0.629, -0.663, -0.2, 0.766, -0.316,-0.6, 0.696, 0.21, -0.788, 0.282, 0.581, -0.684, -0.177,
                0.814, -0.284, -0.61, 0.651};

        double[] result = flt.high_pass_filter(4, 29);
        assertArrayEquals(out, result, 0.001);
    }

    @Test
    public void BandPassTest() {
        final double[] out = {0.0, 0.002, 0.008, 0.01, -0.01, -0.047, -0.052, 0.015, 0.116, 0.152, 0.035, -0.189,
                -0.321, -0.167, 0.216, 0.509, 0.393, -0.125, -0.646, -0.677, -0.099, 0.648, 0.914, 0.418, -0.478,
                -1.031, -0.742, 0.181, 0.978,0.982, 0.182, -0.769, -1.09, -0.518, 0.465, 1.05, 0.772, -0.125, -0.903,
                -0.93, -0.198, 0.68, 0.984, 0.48, -0.411, -0.957, -0.708, 0.127, 0.853, 0.874, 0.174, -0.674, -0.969,
                -0.46, 0.434, 0.972, 0.709, -0.141, -0.883, -0.901, -0.172, 0.7, 0.996, 0.475, -0.438, -0.994, -0.73,
                0.137, 0.889, 0.908, 0.183, -0.692, -0.998, -0.479, 0.433, 0.983, 0.723, -0.131, -0.879, -0.902, -0.179,
                0.689, 0.987, 0.473, -0.43, -0.981, -0.721, 0.137, 0.88, 0.898, 0.178, -0.69, -0.992, -0.473, 0.436,
                0.983, 0.721, -0.134, -0.882, -0.904};

        double[] result = flt.band_pass_filter(4, 12, 18);
        assertArrayEquals(out, result, 0.001);
    }

    @Test
    public void BandStopTest() {
        final double[] out = {0.0, 0.311, -0.459, 0.841, 0.154, -0.143, 1.176, 0.738, 0.001, 1.273, 1.342, 0.023, 0.739,
                1.414, -0.128,-0.359, 0.745, -0.363, -1.447, -0.255, -0.37, -1.788, -0.881, 0.126, -1.036, -0.771, 0.92,
                0.372, -0.227,1.359, 1.494, 0.132, 0.907, 1.609, -0.01, -0.311, 0.766, -0.383, -1.512, -0.331, -0.434,
                -1.841, -0.917, 0.115, -1.025, -0.748, 0.949, 0.403, -0.202, 1.375, 1.499, 0.13, 0.898, 1.596, -0.023,
                -0.322, 0.758, -0.387, -1.512, -0.327, -0.429, -1.835, -0.912, 0.119, -1.023, -0.748, 0.947, 0.401,
                -0.204, 1.373, 1.498, 0.129, 0.897, 1.597, -0.022, -0.321, 0.759, -0.386, -1.511, -0.327, -0.429,
                -1.835, -0.912, 0.118, -1.024, -0.748, 0.947, 0.401, -0.204, 1.373, 1.498, 0.129, 0.898, 1.597, -0.022,
                -0.321, 0.759, -0.386, -1.511, -0.327};

        double[] result = flt.band_stop_filter(4, 7, 28);
        assertArrayEquals(out, result, 0.001);
    }
}
