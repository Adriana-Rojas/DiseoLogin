/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.controller;

import com.udec.musicbv.modelo.Conexion;
import com.udec.musicbv.modelo.InformeResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author diego
 */
@Named(value = "reportes")
@ViewScoped
public class Reportes implements Serializable {

    private BarChartModel barModel;
    private PieChartModel livePieModel;
    private HorizontalBarChartModel horizontalBarModel;
    Conexion conexion;
    /**
     * Creates a new instance of Reportes
     */
    public Reportes() {
        conexion = new Conexion();
    }

    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }

    public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
        this.horizontalBarModel = horizontalBarModel;
    }

    public PieChartModel getLivePieModel() {
        return livePieModel;
    }

    public void setLivePieModel(PieChartModel livePieModel) {
        this.livePieModel = livePieModel;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    
    @PostConstruct
    public void init() {
        initBarModel();
        initLivePieModel();
        initHorizontalBarModel();
    }
    
    private void initBarModel() {
        barModel = new BarChartModel();
        ChartSeries ventas = new ChartSeries();
        List<InformeResult> results;
        results = conexion.obtenerVentasPorDisco();
        ventas.setLabel("Ventas por Artista");
        for (InformeResult result : results) {
            ventas.set(result.getNombre(), result.getTotal());
        }
        barModel.addSeries(ventas);
        barModel.setTitle("Ventas por Disco");
        barModel.setLegendPosition("ne");
 
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Artista");
 
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Ventas");

    }
    
    private void initLivePieModel() {
        livePieModel = new PieChartModel();
        List<InformeResult> results;
        results = conexion.obtenerVentasPorArtista();
        for (InformeResult result : results) {
            livePieModel.set(result.getNombre(), result.getTotal());
        }
        livePieModel.setTitle("Ventas por Arista");
        livePieModel.setLegendPosition("w");
        livePieModel.setShadow(false);
    }
    private void initHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
        List<InformeResult> results;
        results = conexion.obtenerVentasPorCancion();
        ChartSeries ventas = new ChartSeries();
        ventas.setLabel("Ventas por canción");
        
        for (InformeResult result : results) {
            ventas.set(result.getNombre(), result.getTotal());
        }
 
        horizontalBarModel.addSeries(ventas);
 
        horizontalBarModel.setTitle("Ventas por Canción");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
 
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Canción");
 
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Ventas");
    }
    
}
