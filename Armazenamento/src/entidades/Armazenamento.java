package entidades;

public class Armazenamento {

    private String tipoDispo;
    private double espaco;
    private double ocupado;
    
    /**
     * @return String return the tipoDispo
     */
    public String getTipoDispo() {
        return tipoDispo;
    }

    /**
     * @param tipoDispo the tipoDispo to set
     */
    public void setTipoDispo(String tipoDispo) {
        this.tipoDispo = tipoDispo;
    }

    /**
     * @return double return the espaco
     */
    public double getEspaco() {
        return espaco;
    }

    /**
     * @param espaco the espaco to set
     */
    public void setEspaco(double espaco) {
        this.espaco = espaco;
    }

    /**
     * @return double return the ocupado
     */
    public double getOcupado() {
        return ocupado;
    }

    /**
     * @param ocupado the ocupado to set
     */
    public void setOcupado(double ocupado) {
        this.ocupado = ocupado;
    }

}
