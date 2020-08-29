package com.example.juliocesar.diseologin;


class CameraInfo {

    private String featureName;
    private String featureValue;

    CameraInfo(String featureName, String featureValue) {
        this.featureName = featureName;
        this.featureValue = featureValue;
    }

    String getFeatureName() {
        return featureName;
    }

    String getFeatureValue() {
        return featureValue;
    }
}