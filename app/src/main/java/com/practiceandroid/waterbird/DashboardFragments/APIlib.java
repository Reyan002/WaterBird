package com.practiceandroid.waterbird.DashboardFragments;

import com.anychart.anychart.AnyChartView;

class APIlib {
    private AnyChartView anyChartView;

    private static volatile APIlib instance;

    public static APIlib getInstance() {
        APIlib localInstance = instance;
        if (localInstance == null) {
            synchronized (APIlib.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new APIlib();
                }
            }
        }
        return localInstance;
    }

    public void setActiveAnyChartView(AnyChartView anyChartView) {
        this.anyChartView = anyChartView;
    }

}
