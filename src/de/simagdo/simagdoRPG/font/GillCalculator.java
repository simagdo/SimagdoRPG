package de.simagdo.simagdoRPG.font;

public class GillCalculator implements FontVariablesCalculator {

    private static final float[] subOneAntialiasValues = {0.5f, 0.47f, 0.36f, 0.21f, 0.17f, 0.14f, 0.1297f, 0.126f, 0.0894f, 0.102f, 0.098f};
    private static final float[] subOneEdgeValues = {0.35f, 0.36f, 0.38f, 0.42f, 0.43f, 0.444f, 0.448f, 0.443f, 0.465f, 0.451f, 0.452f};

    public float calculateAntialiasValue(float size) {
        if (size >= 1) {
            size = ((size - 1) / (1f + size / 4f)) + 1f;
            return size;
        } else {
            return lookupInterpolatedValue(subOneAntialiasValues, size);
        }
    }

    @Override
    public float caculateEdgeValue(float size) {
        if (size >= 1) return ((1f / 300f) * size + (137f / 300f));
        else return lookupInterpolatedValue(subOneEdgeValues, size);
    }

    private float lookupInterpolatedValue(float[] data, float size) {
        float value = size / 0.1f;
        int firstIndex = (int) value;
        float progress = value - firstIndex;
        float lowerValue = data[firstIndex];
        float higherValue = data[firstIndex + 1];
        return linearInterpolate(lowerValue, higherValue, progress);
    }

    private float linearInterpolate(float lower, float higher, float progress) {
        float difference = higher - lower;
        return lower + (difference * progress);
    }

}
