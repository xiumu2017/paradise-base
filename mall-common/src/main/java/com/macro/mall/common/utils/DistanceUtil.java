package com.macro.mall.common.utils;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalCoordinates;

import java.math.BigDecimal;

/**
 * @author Paradise
 */
public class DistanceUtil {
    public static void main(String[] args) {
        System.out.println(getDistance("117.13519769281386,31.83807472796166", "117.11732613414763,31.8370766738247"));
        System.out.println(getDistance("117.13519769281386,31.83807472796166", "117.21573101848601,31.920019564494538"));
        System.out.println(getDistance("117.13519769281386,31.83807472796166", "117.28628384441375,34.20347716453021"));
    }

    private static double getDistance(double longitudeFrom, double latitudeFrom, double longitudeTo, double latitudeTo) {
        GlobalCoordinates source = new GlobalCoordinates(latitudeFrom, longitudeFrom);
        GlobalCoordinates target = new GlobalCoordinates(latitudeTo, longitudeTo);
        return new GeodeticCalculator().calculateGeodeticCurve(Ellipsoid.Sphere, source, target).getEllipsoidalDistance();
    }

    public static BigDecimal getDistance(String from, String to) {
        double lof = Double.parseDouble(from.split(",")[0]);
        double laf = Double.parseDouble(from.split(",")[1]);
        double lot = Double.parseDouble(to.split(",")[0]);
        double lat = Double.parseDouble(to.split(",")[1]);
        double dis = getDistance(lof, laf, lot, lat);
        return new BigDecimal(String.valueOf(dis));
    }
}
