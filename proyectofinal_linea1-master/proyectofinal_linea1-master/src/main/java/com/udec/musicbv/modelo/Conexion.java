/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

/**
 *
 * @author Daniel Barreto, Julian vallejo clase que conecta al gestor de BD
 */
public class Conexion implements Serializable {

    private static final String host = "jdbc:postgresql://localhost:5432/discotienda";
    private static final String user = "postgres";
    private static final String password = "diego123";

    /**
     * metodo se encarga de agragar artista a la BD con procedimiento quemado
     *
     * @param artista
     */
    public void agregarArtista(Artista artista) {

        String qry = "insert into  artista(nombre, apellido, fecha_nacimiento, nacionalidad) "
                + "values('" + artista.getNombre()
                + "', '" + artista.getApellido()
                + "', '" + artista.getFechaNacimiento()
                + "', '" + artista.getNacionalidad() + "')";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * metodo encargado de eliminar artista
     *
     * @param id_artista
     */
    public void eliminarArtistas(int id_artista) {

        String qry = "DELETE FROM  artista WHERE id =" + id_artista;

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * metodo encargado de editar artista
     *
     * @param artista
     */
    public void editarArtistas(Artista artista) {

        String qry = "UPDATE artista SET nombre ='" + artista.getNombre() + "',"
                + "apellido ='" + artista.getApellido() + "',"
                + "fecha_nacimiento ='" + artista.getFechaNacimiento() + "',"
                + "nacionalidad ='" + artista.getNacionalidad()
                + "'WHERE id = " + artista.getId();

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * metodo encargado de retornar la lista de los artistas
     *
     * @return
     */
    public List<Artista> obtenerArtistas() {

        List<Artista> artistas = new ArrayList<>();
        String qry = "Select * from artista";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            //While es para los select

            while (resultSet.next()) {
                System.out.println();
                Artista artista = new Artista(resultSet.getString("nombre"), resultSet.getString("apellido"), 
                        Date.valueOf(resultSet.getString("fecha_nacimiento")), resultSet.getString("nacionalidad"));
                artista.setId(Integer.parseInt(resultSet.getString("id")));
                artistas.add(artista);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return artistas;
    }

    /**
     * metodo encargado de agregar el album
     *
     * @param album
     */
    public void agregarAlbum(Album album) {

        String qry = "insert into disco(nombre, id_artista) "
                + "values('" + album.getNombre() + "', '" + album.getArtista() + "')";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * metodo encargado de obtener albumes
     *
     * @return
     */
    public List<AlbumJoin> obtenerAlbumes() {

        List<AlbumJoin> albumes = new ArrayList<>();
        String qry = "SELECT di.nombre as disco, ar.nombre as artista, di.id as id_disco, ar.id as id_artista "
                + "FROM artista AS ar JOIN disco AS di ON ar.id = di.id_artista";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            //While es para los select

            while (resultSet.next()) {
                System.out.println();
                AlbumJoin album = new AlbumJoin();
                album.setNombre(resultSet.getString("disco"));
                album.setArtista(resultSet.getString("artista"));
                album.setId_disco(Integer.parseInt(resultSet.getString("id_disco")));
                album.setId_artista(Integer.parseInt(resultSet.getString("id_artista")));
                albumes.add(album);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return albumes;
    }

    /**
     * metodo encargado de eliminar album
     *
     * @param id_album
     */
    public void eliminarAlbum(int id_album) {

        String qry = "DELETE FROM  disco WHERE id =" + id_album;

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * metodo encargado de editar album
     *
     * @param album
     */
    public void editarAlbum(AlbumJoin album) {

        String qry = "UPDATE disco SET nombre ='" + album.getNombre() + "',"
                + "id_artista ='" + album.getId_artista()
                + "'WHERE id = " + album.getId_disco();

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * metodo encargado de obtener informacion del disco
     *
     * @return
     */
    public List<Album> obtenerAlbumesMenu() {

        List<Album> albumes = new ArrayList<>();
        String qry = "Select * from disco";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            //While es para los select

            while (resultSet.next()) {
                System.out.println();
                Album album = new Album();
                album.setNombre(resultSet.getString("nombre"));
                album.setId(Integer.parseInt(resultSet.getString("id")));
                albumes.add(album);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return albumes;
    }

    /**
     * metodo encargado de agregar la cancion
     *
     * @param cancion
     */
    public void agregarCancion(Cancion cancion) {

        String qry = "insert into  cancion(nombre, precio, id_disco, duracion) "
                + "values('" + cancion.getNombre()
                + "', '" + cancion.getPrecio()
                + "', '" + cancion.getAlbum()
                + "', '" + cancion.getDuracion() + "')";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * metodo encargado de obtener canciones
     *
     * @return
     */
    public List<CancionJoin> obtenerCanciones() {

        List<CancionJoin> canciones = new ArrayList<>();
        String qry = "SELECT ca.id AS id_cancion, di.id AS id_album, ca.nombre AS cancion, ca.precio, "
                + "di.nombre AS album, ca.duracion FROM cancion AS ca JOIN disco AS di ON ca.id_disco = di.id";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            //While es para los select

            while (resultSet.next()) {
                System.out.println();
                CancionJoin cancion = new CancionJoin();
                cancion.setId_cancion(Integer.parseInt(resultSet.getString("id_cancion")));
                cancion.setId_album(Integer.parseInt(resultSet.getString("id_album")));
                cancion.setCancion(resultSet.getString("cancion"));
                cancion.setPrecio(Integer.parseInt(resultSet.getString("precio")));
                cancion.setAlbum(resultSet.getString("album"));
                cancion.setDuracion(Float.parseFloat(resultSet.getString("duracion")));
                canciones.add(cancion);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return canciones;
    }

    /**
     * metodo encargado de eliminar canciones
     *
     * @param id_cancion
     */
    public void eliminarCancion(int id_cancion) {

        String qry = "DELETE FROM  cancion WHERE id =" + id_cancion;

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * metodo encargado de editar la cancion
     *
     * @param cancion
     */
    public void editarCancion(CancionJoin cancion) {

        String qry = "UPDATE cancion SET nombre ='" + cancion.getCancion() + "',"
                + "precio ='" + cancion.getPrecio() + "',"
                + "id_disco ='" + cancion.getId_album() + "',"
                + "duracion ='" + cancion.getDuracion()
                + "'WHERE id = " + cancion.getId_cancion();

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * metodo encargado de obtener las canciones del album
     *
     * @param id_album
     * @return
     */
    public List<Cancion> obteberCanciones(int id_album) {

        List<Cancion> canciones = new ArrayList<>();
        String qry = "SELECT * FROM cancion WHERE id_disco = " + id_album;

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            //While es para los select

            while (resultSet.next()) {
                System.out.println();
                Cancion cancion = new Cancion();
                cancion.setId(resultSet.getInt("id"));
                cancion.setNombre(resultSet.getString("nombre"));
                cancion.setPrecio(Integer.parseInt(resultSet.getString("precio")));
                cancion.setDuracion(Float.parseFloat(resultSet.getString("duracion")));
                canciones.add(cancion);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return canciones;
    }

    /**
     * metodo encargado de obtener la compra
     *
     * @param carrito
     * @param cedula
     * @param total
     */
    public void comprar(List<Cancion> carrito, int cedula, int total) {
        agregarFactura(cedula, total);
        int id = obtenerFacturaId(cedula);
        agregarCompra(carrito, id);
    }

    /**
     * metodo encargado de agregar la compra a BD
     *
     * @param cedula
     * @param total
     */
    private void agregarFactura(int cedula, int total) {
        Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
        System.out.println(fecha);
        /*String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat fecha = new SimpleDateFormat(strDateFormat);
        System.out.println(fecha.format(objDate));*/
        String qry = "insert into factura(documento_usuario, total, fecha) "
                + "values(" + cedula + ", " + total + ", '" + fecha + "')";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * metodo encargado de obtener la compra del usuario
     *
     * @param cedula
     * @return
     */
    private int obtenerFacturaId(int cedula) {
        int id = 0;
        String qry = "Select id from factura WHERE documento_usuario = " + cedula +
                " ORDER BY documento_usuario DESC LIMIT 1";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            //While es para los select

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                System.out.println("iiiddd: " + id);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    /**
     * metodo encargado de agregar la compra
     *
     * @param carrito
     * @param id
     */
    private void agregarCompra(List<Cancion> carrito, int id) {
        for (Cancion cancion : carrito) {
            int cId = cancion.getId();
            String qry = "insert into compra(id_cancion, id_factura) "
                    + "values(" + cId + ", " + id + ")";

            // auto close connection and preparedStatement
            try (Connection conn = DriverManager.getConnection(host, user, password);
                    PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

                preparedStatement.executeQuery();

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public List<InformeResult> obtenerVentasPorArtista() {
        List<InformeResult> informe = new ArrayList<>();
        String qry = "SELECT ar.nombre, SUM(ca.precio) total\n" +
                    "FROM artista ar\n" +
                    "JOIN disco di ON di.id_artista = ar.id\n" +
                    "JOIN cancion ca ON ca.id_disco = di.id\n" +
                    "JOIN compra co ON co.id_cancion = ca.id\n" +
                    "GROUP BY ar.id\n" +
                    "ORDER BY ar.nombre";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                InformeResult informeResult = new InformeResult();
                informeResult.setNombre(resultSet.getString("nombre"));
                informeResult.setTotal(resultSet.getInt("total"));
                informe.add(informeResult);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return informe;
    }

    public List<InformeResult> obtenerVentasPorDisco() {
        List<InformeResult> informe = new ArrayList<>();
        String qry = "SELECT di.nombre, SUM(ca.precio) total\n" +
                    "FROM artista ar\n" +
                    "JOIN disco di ON di.id_artista = ar.id\n" +
                    "JOIN cancion ca ON ca.id_disco = di.id\n" +
                    "JOIN compra co ON co.id_cancion = ca.id\n" +
                    "GROUP BY di.id\n" +
                    "ORDER BY di.nombre";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                InformeResult informeResult = new InformeResult();
                informeResult.setNombre(resultSet.getString("nombre"));
                informeResult.setTotal(resultSet.getInt("total"));
                informe.add(informeResult);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return informe;
    }

    public List<InformeResult> obtenerVentasPorCancion() {
        List<InformeResult> informe = new ArrayList<>();
        String qry = "SELECT ca.nombre, SUM(ca.precio) total\n" +
                    "FROM artista ar\n" +
                    "JOIN disco di ON di.id_artista = ar.id\n" +
                    "JOIN cancion ca ON ca.id_disco = di.id\n" +
                    "JOIN compra co ON co.id_cancion = ca.id\n" +
                    "GROUP BY ca.id\n" +
                    "ORDER BY ca.nombre";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(qry)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                InformeResult informeResult = new InformeResult();
                informeResult.setNombre(resultSet.getString("nombre"));
                informeResult.setTotal(resultSet.getInt("total"));
                informe.add(informeResult);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return informe;
    }

}
