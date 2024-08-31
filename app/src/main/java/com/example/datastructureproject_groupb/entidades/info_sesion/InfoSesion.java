package com.example.datastructureproject_groupb.entidades.info_sesion;

public class InfoSesion {
    private int  TipoSesion;
    private String CorreoSesion;

    public InfoSesion(long id, int tipoSesion, String correoSesion){
        if (correoSesion == null || correoSesion.isEmpty()) {
            throw new IllegalArgumentException("CorreoSesion cannot be null or empty");
        }
        this.TipoSesion = tipoSesion;
        this.CorreoSesion = correoSesion;
    };
    public int getTipoSesion() {
        return TipoSesion;
    }

    public void setTipoSesion(int tipoSesion) {
        this.TipoSesion = tipoSesion;
    }
    public String getCorreoSesion() {
        return CorreoSesion;
    }

    public void setCorreoSesion(String correoSesion) {
        CorreoSesion = correoSesion;
    }



    ;

}
